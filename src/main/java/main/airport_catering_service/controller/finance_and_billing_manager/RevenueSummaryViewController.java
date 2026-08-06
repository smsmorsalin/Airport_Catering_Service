package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.Invoice;
import nonuser.Payment;
import nonuser.RefundRecord;
import nonuser.Revenue;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RevenueSummaryViewController implements UserReceiver
{
    private static final String INVOICE_FILE = "Invoice.bin";
    private static final String PAYMENT_FILE = "Payment.bin";
    private static final String REFUND_FILE = "RefundRecord.bin";
    @javafx.fxml.FXML
    private Label paidAmountLabel;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private Label totalRevenueLabel;
    @javafx.fxml.FXML
    private TableView <Revenue>revenueTable;
    @javafx.fxml.FXML
    private Label pendingAmountLabel;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> airlineComboBox;
    @javafx.fxml.FXML
    private Label netRevenueLabel;
    @javafx.fxml.FXML
    private TableColumn <Revenue,Integer>revenueColumn;
    @javafx.fxml.FXML
    private TableColumn <Revenue,Integer> netRevenueColumn;
    @javafx.fxml.FXML
    private Label refundAmountLabel;
    @javafx.fxml.FXML
    private TableColumn <Revenue, LocalDate>dateColumn;
    @javafx.fxml.FXML
    private TableColumn <Revenue,Integer> orderColumn;
    @javafx.fxml.FXML
    private Button generateSummaryButton;
    @javafx.fxml.FXML
    private TableColumn <Revenue,Integer> paymentreceiveColumn;

    private FinanceAndBillingManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FinanceAndBillingManager financeAndBillingManager){
            this.loggedInUser = financeAndBillingManager;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        airlineComboBox.getItems().setAll("All Airlines");
        for (Object object : BinaryFileUtility.readObjects("Airline.bin")) {
            if (object instanceof Airline airline) {
                airlineComboBox.getItems().add(airline.getAirlineId());
            }
        }
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getDate()));
        orderColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getOrders()));
        revenueColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getRevenue()));
        paymentreceiveColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getReceived()));
        netRevenueColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getNetrevenue()));
    }

    @javafx.fxml.FXML
    public void GenerateSummaryOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        if(airlineComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(fromDatePicker.getValue() == null || toDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(fromDatePicker.getValue().isAfter(toDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(toDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invalid Input","End date can not be present date");
            return;
        }

        Map<LocalDate, Integer> orderCounts = new HashMap<>();
        Map<LocalDate, Double> revenues = new HashMap<>();
        Map<LocalDate, Double> received = new HashMap<>();
        Map<String, Double> paidByInvoice = new HashMap<>();
        for (Object object : BinaryFileUtility.readObjects(PAYMENT_FILE)) {
            if (object instanceof Payment payment) {
                paidByInvoice.merge(payment.getInvoiceId(), payment.getPaymentAmount(), Double::sum);
            }
        }
        double total = 0, paid = 0, pending = 0;
        for (Object object : BinaryFileUtility.readObjects(INVOICE_FILE)) {
            if (object instanceof Invoice invoice
                    && !invoice.getDueDate().isBefore(fromDatePicker.getValue())
                    && !invoice.getDueDate().isAfter(toDatePicker.getValue())
                    && matchesAirline(invoice.getOrderId(), airlineComboBox.getValue())) {
                double invoicePaid = paidByInvoice.getOrDefault(invoice.getInvoiceId(), 0.0);
                total += invoice.getTotalAmount();
                paid += invoicePaid;
                pending += Math.max(0, invoice.getTotalAmount() - invoicePaid);
                orderCounts.merge(invoice.getDueDate(), 1, Integer::sum);
                revenues.merge(invoice.getDueDate(), invoice.getTotalAmount(), Double::sum);
                received.merge(invoice.getDueDate(), invoicePaid, Double::sum);
            }
        }
        double refunds = 0;
        for (Object object : BinaryFileUtility.readObjects(REFUND_FILE)) {
            if (object instanceof RefundRecord refund
                    && !refund.getRefundDate().isBefore(fromDatePicker.getValue())
                    && !refund.getRefundDate().isAfter(toDatePicker.getValue())) {
                refunds += refund.getAmount();
            }
        }
        ArrayList<Revenue> rows = new ArrayList<>();
        for (LocalDate date : orderCounts.keySet()) {
            int revenue = (int) Math.round(revenues.getOrDefault(date, 0.0));
            int receivedAmount = (int) Math.round(received.getOrDefault(date, 0.0));
            rows.add(new Revenue(date, orderCounts.get(date), revenue, receivedAmount, revenue - receivedAmount));
        }
        rows.sort((first, second) -> second.getDate().compareTo(first.getDate()));
        revenueTable.getItems().setAll(rows);
        totalRevenueLabel.setText(String.format("%.2f", total));
        paidAmountLabel.setText(String.format("%.2f", paid));
        pendingAmountLabel.setText(String.format("%.2f", pending));
        refundAmountLabel.setText(String.format("%.2f", refunds));
        netRevenueLabel.setText(String.format("%.2f", paid - refunds));
        AlertGenerator.showAlert("Success", "Revenue summary generated successfully");
    }

    private boolean matchesAirline(int orderId, String selectedAirline) {
        return "All Airlines".equals(selectedAirline) || selectedAirline.equals(findAirline(orderId));
    }

    private String findAirline(int orderId) {
        for (Object object : BinaryFileUtility.readObjects("CateringOrder.bin")) {
            if (object instanceof nonuser.CateringOrder order && order.getOrderId() == orderId) return order.getAirlineId();
        }
        return "Unknown";
    }

    private void switchTo (ActionEvent event, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(event, view, loggedInUser);
    }


    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/CalculateCostView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/GenerateInvoiceView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RecordPaymentView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/ProcessRefundView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/OutstandingPaymentsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/FinancialReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RevenueSummaryView.fxml",
                loggedInUser);
    }


    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/PaymentHistoryView.fxml",
                loggedInUser);
    }
}
