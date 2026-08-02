package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FinanceAndBillingManager;

import java.io.IOException;

public class RecordPaymentViewController
{
    @javafx.fxml.FXML
    private Button verifyInvoiceButton;
    @javafx.fxml.FXML
    private Label summaryAmountLabel;
    @javafx.fxml.FXML
    private Label paymentIdLabel;
    @javafx.fxml.FXML
    private Button downloadReceiptButton;
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
    private Button cancelButton;
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
    @javafx.fxml.FXML
    private Button resetButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void printreceiptOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void downloadreceiptOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recordpaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifyInvoiceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cancelOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarRecoedPaymentOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewRevenueSummary(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewRecordPayment(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewProcessRefund(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewGenerateInvoice(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewPaymentHistory(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewCalculateCost(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewFinancialReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewOutstandingPayments(actionEvent);
    }
}