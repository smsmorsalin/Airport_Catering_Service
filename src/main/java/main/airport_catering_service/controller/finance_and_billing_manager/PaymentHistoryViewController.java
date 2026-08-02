package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FinanceAndBillingManager;

import java.io.IOException;

public class PaymentHistoryViewController
{
    @javafx.fxml.FXML
    private TextField invoiceIdTextField;
    @javafx.fxml.FXML
    private Button exportBtn;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private Button viewPaymentBtn;
    @javafx.fxml.FXML
    private Button receiptBtn;
    @javafx.fxml.FXML
    private TableColumn methodColumn;
    @javafx.fxml.FXML
    private Button resetBtn;
    @javafx.fxml.FXML
    private TextField airlineTextField;
    @javafx.fxml.FXML
    private TableView paymentTable;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private ComboBox<String> paymentStatusComboBox;
    @javafx.fxml.FXML
    private Button searchPaymentBtn;
    @javafx.fxml.FXML
    private TableColumn invoiceColumn;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn paymentIdColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ResetOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarPaymentHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DownloadReceiptOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPDFOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
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