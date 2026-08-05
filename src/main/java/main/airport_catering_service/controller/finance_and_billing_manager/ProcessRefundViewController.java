package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Payment;
import nonuser.RefundRecord;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class ProcessRefundViewController implements UserReceiver
{
    private static final String PAYMENT_FILE = "Payment.bin";
    private static final String REFUND_FILE = "RefundRecord.bin";
    @javafx.fxml.FXML
    private Label paymentMethodLabel;
    @javafx.fxml.FXML
    private Label refundIdLabel;
    @javafx.fxml.FXML
    private Label refundStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> refundReasonComboBox;
    @javafx.fxml.FXML
    private Label refundAmountLabel;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private Label refundDateLabel;
    @javafx.fxml.FXML
    private TextArea additionalNotesTextField;
    @javafx.fxml.FXML
    private TextField refundRequestIdField;
    @javafx.fxml.FXML
    private ComboBox<String> refundMethodComboBox;
    @javafx.fxml.FXML
    private Button processRefundButton;
    @javafx.fxml.FXML
    private Label transactionMethodLabel;
    @javafx.fxml.FXML
    private TextField refundAmountTextField;

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
        refundReasonComboBox.getItems().setAll("Order Cancelled", "Duplicate Payment", "Service Issue", "Other");
        refundMethodComboBox.getItems().setAll("Original Payment Method", "Bank Transfer", "Cash", "Mobile Banking");
        clearSummary();
    }

    @Deprecated
    public void sidebarProcessRefundOnAction(ActionEvent actionEvent) {
        if(refundRequestIdField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Refund Request Id should be filled");
            return;
        }
        if(orderidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Order Id should be filled");
            return;
        }
        if(refundAmountTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Refund Amount should be filled");
            return;
        }

        if(additionalNotesTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Additional Notes should be filled");
            return;
        }
        if(refundReasonComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Refund Reason ComboBox Should be selected");
            return;
        }
        if(refundMethodComboBox.getValue()==null){
            AlertGenerator.showAlert("Wrong Input","Refund Method ComboBox Should be selected");
        }
    }



    @javafx.fxml.FXML
    public void processRefundOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        String paymentId = refundRequestIdField.getText().trim();
        String orderText = orderidTextField.getText().trim();
        String amountText = refundAmountTextField.getText().trim();
        if (paymentId.isEmpty() || orderText.isEmpty() || amountText.isEmpty()
                || additionalNotesTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "All refund fields should be filled");
            return;
        }
        if (refundReasonComboBox.getValue() == null || refundMethodComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Refund reason and method should be selected");
            return;
        }
        int orderId;
        double amount;
        try {
            orderId = Integer.parseInt(orderText);
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID and refund amount must be numeric");
            return;
        }
        Payment payment = null;
        for (Object object : BinaryFileUtility.readObjects(PAYMENT_FILE)) {
            if (object instanceof Payment candidate
                    && candidate.getPaymentId().equals(paymentId)) {
                payment = candidate;
                break;
            }
        }
        if (payment == null) {
            AlertGenerator.showAlert("Payment Not Found", "No payment was found with ID " + paymentId);
            return;
        }
        if (amount <= 0 || amount > payment.getPaymentAmount()) {
            AlertGenerator.showAlert("Invalid Amount", "Refund cannot exceed the payment amount");
            return;
        }
        RefundRecord refund = new RefundRecord(paymentId, orderId, amount,
                refundReasonComboBox.getValue(), refundMethodComboBox.getValue(),
                additionalNotesTextField.getText().trim(), loggedInUser.getEmployeeId());
        if (!BinaryFileUtility.writeObjects(REFUND_FILE, refund)) {
            AlertGenerator.showAlert("Error", "Refund could not be saved");
            return;
        }
        refundIdLabel.setText(refund.getRefundId());
        refundAmountLabel.setText(String.format("%.2f", refund.getAmount()));
        refundStatusLabel.setText(refund.getStatus());
        refundDateLabel.setText(refund.getRefundDate().toString());
        paymentMethodLabel.setText(payment.getPaymentType());
        transactionMethodLabel.setText(refund.getMethod());
        AlertGenerator.showAlert("Success", "Refund processed successfully");
    }

    private void clearSummary() {
        refundIdLabel.setText("-");
        refundAmountLabel.setText("0.00");
        refundStatusLabel.setText("-");
        refundDateLabel.setText("-");
        paymentMethodLabel.setText("-");
        transactionMethodLabel.setText("-");
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
