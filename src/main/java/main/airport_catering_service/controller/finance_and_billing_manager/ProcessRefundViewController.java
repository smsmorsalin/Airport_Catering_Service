package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FinanceAndBillingManager;

import java.io.IOException;

public class ProcessRefundViewController
{
    @javafx.fxml.FXML
    private Label paymentMethodLabel;
    @javafx.fxml.FXML
    private Label refundIdLabel;
    @javafx.fxml.FXML
    private Label refundStatusLabel;
    @javafx.fxml.FXML
    private Button viewRefundButton;
    @javafx.fxml.FXML
    private Button verifyRequestButton;
    @javafx.fxml.FXML
    private ComboBox<String> refundReasonComboBox;
    @javafx.fxml.FXML
    private TextField refundAmounTextField;
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
    public void initialize() {
    }

    @Deprecated
    public void sidebarProcessRefundOnAction(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void processRefundOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifyrequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewRefundDetailsOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
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