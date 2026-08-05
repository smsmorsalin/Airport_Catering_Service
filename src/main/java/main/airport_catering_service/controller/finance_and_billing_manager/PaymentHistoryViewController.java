package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Payment;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentHistoryViewController implements UserReceiver {
    private static final String PAYMENT_FILE = "Payment.bin";

    @javafx.fxml.FXML private TextField invoiceIdTextField;
    @javafx.fxml.FXML private TableColumn<Payment, Double> amountColumn;
    @javafx.fxml.FXML private TableColumn<Payment, String> methodColumn;
    @javafx.fxml.FXML private TextField airlineTextField;
    @javafx.fxml.FXML private TableView<Payment> paymentTable;
    @javafx.fxml.FXML private TableColumn<Payment, String> airlineColumn;
    @javafx.fxml.FXML private TableColumn<Payment, String> statusColumn;
    @javafx.fxml.FXML private ComboBox<String> paymentStatusComboBox;
    @javafx.fxml.FXML private Button searchPaymentBtn;
    @javafx.fxml.FXML private TableColumn<Payment, String> invoiceColumn;
    @javafx.fxml.FXML private ComboBox<String> airlinenameComboBox;
    @javafx.fxml.FXML private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML private TableColumn<Payment, String> paymentIdColumn;
    @javafx.fxml.FXML private TableColumn<Payment, LocalDate> dateColumn;

    private FinanceAndBillingManager loggedInUser;

    @Override public void setLoggedInUser(User user) {
        if (user instanceof FinanceAndBillingManager manager) loggedInUser = manager;
        else AlertGenerator.showAlert("Error", "Authentication failed");
    }

    @javafx.fxml.FXML public void initialize() {
        paymentStatusComboBox.getItems().setAll("All", "Completed", "Refunded");
        paymentMethodComboBox.getItems().setAll("All", "Bank Transfer", "Credit Card", "Cash", "Mobile Banking");
        airlinenameComboBox.getItems().setAll("All Airlines");
        for (Object object : BinaryFileUtility.readObjects("Airline.bin")) {
            if (object instanceof nonuser.Airline airline) airlinenameComboBox.getItems().add(airline.getAirlineId());
        }
        paymentIdColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPaymentId()));
        invoiceColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getInvoiceId()));
        airlineColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(findAirline(data.getValue().getInvoiceId())));
        amountColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getAmount()));
        methodColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMethod()));
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPaymentDate()));
        statusColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        loadPayments(BinaryFileUtility.readObjects(PAYMENT_FILE));
    }

    @javafx.fxml.FXML public void SearchOnAction(ActionEvent event) {
        if (loggedInUser == null || airlinenameComboBox.getValue() == null
                || paymentStatusComboBox.getValue() == null || paymentMethodComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Select all search filters");
            return;
        }
        String invoiceFilter = invoiceIdTextField.getText().trim();
        ArrayList<Object> filtered = new ArrayList<>();
        for (Object object : BinaryFileUtility.readObjects(PAYMENT_FILE)) {
            if (object instanceof Payment payment
                    && (invoiceFilter.isEmpty() || payment.getInvoiceId().equalsIgnoreCase(invoiceFilter))
                    && ("All".equals(paymentStatusComboBox.getValue()) || payment.getStatus().equalsIgnoreCase(paymentStatusComboBox.getValue()))
                    && ("All".equals(paymentMethodComboBox.getValue()) || payment.getMethod().equalsIgnoreCase(paymentMethodComboBox.getValue()))
                    && ("All Airlines".equals(airlinenameComboBox.getValue()) || airlinenameComboBox.getValue().equals(findAirline(payment.getInvoiceId())))) {
                filtered.add(payment);
            }
        }
        loadPayments(filtered);
        AlertGenerator.showAlert("Success", "Payment history loaded");
    }

    private void loadPayments(ArrayList<Object> objects) {
        ArrayList<Payment> payments = new ArrayList<>();
        for (Object object : objects) if (object instanceof Payment payment) payments.add(payment);
        paymentTable.getItems().setAll(payments);
    }

    private String findAirline(String invoiceId) {
        for (Object object : BinaryFileUtility.readObjects("Invoice.bin")) {
            if (object instanceof nonuser.Invoice invoice && invoice.getInvoiceId().equals(invoiceId)) {
                for (Object orderObject : BinaryFileUtility.readObjects("CateringOrder.bin")) {
                    if (orderObject instanceof nonuser.CateringOrder order && order.getOrderId() == invoice.getOrderId()) return order.getAirlineId();
                }
            }
        }
        return "Unknown";
    }

    private void switchTo(ActionEvent event, String view) throws IOException { SceneSwitchingHelper.switchSceneWithData(event, view, loggedInUser); }
    @javafx.fxml.FXML public void sidebarHomePageButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/dashboardView.fxml"); }
    @javafx.fxml.FXML public void sidebardashboardButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/dashboardView.fxml"); }
    @javafx.fxml.FXML public void sideBarRevenueSummaryButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/RevenueSummaryView.fxml"); }
    @javafx.fxml.FXML public void sideBarRecordPaymentButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/RecordPaymentView.fxml"); }
    @javafx.fxml.FXML public void sideBarProcessRefundButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/ProcessRefundView.fxml"); }
    @javafx.fxml.FXML public void sideBarGenerateInvoiceButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/GenerateInvoiceView.fxml"); }
    @javafx.fxml.FXML public void sideBarPaymentHistoryButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/PaymentHistoryView.fxml"); }
    @javafx.fxml.FXML public void sideBarCalculateCostButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/CalculateCostView.fxml"); }
    @javafx.fxml.FXML public void sideBarFinancialReportsButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/FinancialReportsView.fxml"); }
    @javafx.fxml.FXML public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/OutstandingPaymentsView.fxml"); }
}
