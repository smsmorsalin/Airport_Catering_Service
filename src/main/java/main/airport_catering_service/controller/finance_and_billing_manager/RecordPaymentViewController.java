package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.CateringOrder;
import nonuser.Invoice;
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

public class RecordPaymentViewController implements UserReceiver
{
    private static final String INVOICE_FILE = "Invoice.bin";
    private static final String PAYMENT_FILE = "Payment.bin";
    private Invoice selectedInvoice;
    @javafx.fxml.FXML
    private Button verifyInvoiceButton;
    @javafx.fxml.FXML
    private Label summaryAmountLabel;
    @javafx.fxml.FXML
    private Label paymentIdLabel;
    @javafx.fxml.FXML
    private TextField transactionReferenceTextField;
    @javafx.fxml.FXML
    private Label summaryInvoiceLabel;
    @javafx.fxml.FXML
    private Label airlinenameLabel;
    @javafx.fxml.FXML
    private DatePicker paymentDatePicker;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;
    @javafx.fxml.FXML
    private TextField amountPaidTextField;
    @javafx.fxml.FXML
    private Label amountDueLabel;
    @javafx.fxml.FXML
    private Button recordPaymentButton;
    @javafx.fxml.FXML
    private ComboBox<String > paymentMethodComboBox;
    @javafx.fxml.FXML
    private TextField invoiceidTextField;
    @javafx.fxml.FXML
    private Label invoiceAmountLabel;

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
        paymentMethodComboBox.getItems().setAll("Bank Transfer", "Credit Card", "Cash", "Mobile Banking");
        paymentDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void recordpaymentOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null || selectedInvoice == null) {
            AlertGenerator.showAlert("Invalid Input", "Verify an unpaid invoice first");
            return;
        }
        if (transactionReferenceTextField.getText().trim().isEmpty()
                || amountPaidTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Reference and amount should be filled");
            return;
        }
        if (paymentMethodComboBox.getValue() == null || paymentDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Payment method and date should be selected");
            return;
        }
        if (paymentDatePicker.getValue().isAfter(LocalDate.now())) {
            AlertGenerator.showAlert("Invalid Input", "Payment date cannot be in the future");
            return;
        }
        double amount;
        try {
            amount = Double.parseDouble(amountPaidTextField.getText().trim());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Amount should be numeric");
            return;
        }
        double due = selectedInvoice.getTotalAmount();
        for (Object object : BinaryFileUtility.readObjects(PAYMENT_FILE)) {
            if (object instanceof Payment payment && payment.getInvoiceId().equals(selectedInvoice.getInvoiceId())) {
                due -= payment.getAmount();
            }
        }
        if (amount <= 0 || amount > due) {
            AlertGenerator.showAlert("Invalid Amount", "Amount must be greater than 0 and no more than the amount due");
            return;
        }
        Payment payment = new Payment(selectedInvoice.getInvoiceId(), amount,
                paymentMethodComboBox.getValue(), transactionReferenceTextField.getText().trim(),
                paymentDatePicker.getValue());
        if (!BinaryFileUtility.writeObjects(PAYMENT_FILE, payment)) {
            AlertGenerator.showAlert("Error", "Payment could not be saved");
            return;
        }
        if (amount >= due) {
            selectedInvoice.setPaid(true);
            ArrayList<Object> invoices = BinaryFileUtility.readObjects(INVOICE_FILE);
            for (Object object : invoices) {
                if (object instanceof Invoice invoice && invoice.getInvoiceId().equals(selectedInvoice.getInvoiceId())) {
                    invoice.setPaid(true);
                }
            }
            BinaryFileUtility.overwriteObjects(INVOICE_FILE, invoices);
        }
        paymentIdLabel.setText(payment.getPaymentId());
        summaryInvoiceLabel.setText(payment.getInvoiceId());
        summaryAmountLabel.setText(String.format("%.2f", payment.getAmount()));
        paymentStatusLabel.setText(payment.getStatus());
        AlertGenerator.showAlert("Success", "Payment recorded successfully");
    }

    @javafx.fxml.FXML
    public void verifyInvoiceOnAction(ActionEvent actionEvent) {
        String invoiceId = invoiceidTextField.getText().trim();
        if (invoiceId.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Invoice ID should be filled");
            return;
        }
        selectedInvoice = null;
        for (Object object : BinaryFileUtility.readObjects(INVOICE_FILE)) {
            if (object instanceof Invoice invoice && invoice.getInvoiceId().equals(invoiceId)) {
                selectedInvoice = invoice;
                break;
            }
        }
        if (selectedInvoice == null) {
            AlertGenerator.showAlert("Invoice Not Found", "No invoice was found with ID " + invoiceId);
            return;
        }
        if (selectedInvoice.isPaid()) {
            AlertGenerator.showAlert("Already Paid", "This invoice has already been paid");
            return;
        }
        invoiceAmountLabel.setText(String.format("%.2f", selectedInvoice.getTotalAmount()));
        amountDueLabel.setText(String.format("%.2f", selectedInvoice.getTotalAmount()));
        summaryInvoiceLabel.setText(selectedInvoice.getInvoiceId());
        airlinenameLabel.setText(findAirline(selectedInvoice.getOrderId()));
        AlertGenerator.showAlert("Success", "Invoice verified");
    }

    private String findAirline(int orderId) {
        for (Object object : BinaryFileUtility.readObjects("CateringOrder.bin")) {
            if (object instanceof CateringOrder order && order.getOrderId() == orderId) return order.getAirlineId();
        }
        return "Unknown";
    }

    @Deprecated
    public void sidebarRecoedPaymentOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/dashboardView.fxml",
                loggedInUser);    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/RevenueSummaryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/RecordPaymentView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/ProcessRefundView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/GenerateInvoiceView.fxml",
                loggedInUser);    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/PaymentHistoryView.fxml",
                loggedInUser);    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/CalculateCostView.fxml",
                loggedInUser);    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/FinancialReportsView.fxml",
                loggedInUser);    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/OutstandingPaymentsView.fxml",
                loggedInUser);
    }
}
