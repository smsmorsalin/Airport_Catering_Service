package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Invoice;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OutstandingPaymentsViewController implements UserReceiver
{
    private static final String INVOICE_FILE = "Invoice.bin";
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Invoice, LocalDate> dueDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> invoiceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String > airlineColumn;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> statusColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Double> amountColumn;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Integer> overdueColumn;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Label totalDueLabel;
    @javafx.fxml.FXML
    private TableView <Invoice> outstandingInvoiceTable;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> invoiceIdColumn;

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
        invoiceStatusComboBox.getItems().setAll("All", "Unpaid", "Paid", "Overdue");
        invoiceIdColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getInvoiceId()));
        airlineColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(findAirline(data.getValue().getOrderId())));
        amountColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getTotalAmount()));
        dueDateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getDueDate()));
        overdueColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(daysOverdue(data.getValue())));
        statusColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(status(data.getValue())));
        totalDueLabel.setText("0.00");
    }

    @Deprecated
    public void sidebarOutstandingPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {

        if(invoiceStatusComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(startDatePicker.getValue() == null || endDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(startDatePicker.getValue().isAfter(endDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(endDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invalid Input","End date can not be present date");
            return;
        }

        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        java.util.ArrayList<Invoice> rows = new java.util.ArrayList<>();
        for (Object object : BinaryFileUtility.readObjects(INVOICE_FILE)) {
            if (object instanceof Invoice invoice
                    && !invoice.getDueDate().isBefore(startDatePicker.getValue())
                    && !invoice.getDueDate().isAfter(endDatePicker.getValue())
                    && matchesStatus(invoice, invoiceStatusComboBox.getValue())) {
                rows.add(invoice);
            }
        }
        outstandingInvoiceTable.getItems().setAll(rows);
        double totalDue = rows.stream().filter(invoice -> !invoice.isPaid())
                .mapToDouble(Invoice::getTotalAmount).sum();
        totalDueLabel.setText(String.format("%.2f", totalDue));
        AlertGenerator.showAlert("Success", "Outstanding payment report generated");
    }

    private boolean matchesStatus(Invoice invoice, String selected) {
        return "All".equals(selected)
                || ("Paid".equals(selected) && invoice.isPaid())
                || ("Unpaid".equals(selected) && !invoice.isPaid())
                || ("Overdue".equals(selected) && !invoice.isPaid() && daysOverdue(invoice) > 0);
    }

    private String status(Invoice invoice) {
        if (invoice.isPaid()) return "Paid";
        return daysOverdue(invoice) > 0 ? "Overdue" : "Unpaid";
    }

    private int daysOverdue(Invoice invoice) {
        if (invoice.isPaid() || !invoice.getDueDate().isBefore(LocalDate.now())) return 0;
        return (int) ChronoUnit.DAYS.between(invoice.getDueDate(), LocalDate.now());
    }

    private String findAirline(int orderId) {
        for (Object object : BinaryFileUtility.readObjects("CateringOrder.bin")) {
            if (object instanceof nonuser.CateringOrder order && order.getOrderId() == orderId) {
                return order.getAirlineId();
            }
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
