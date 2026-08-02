package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FinanceAndBillingManager;

import java.io.IOException;

public class OutstandingPaymentsViewController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn dueDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> invoiceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private TableColumn overdueColumn;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Label totalDueLabel;
    @javafx.fxml.FXML
    private TableView outstandingInvoiceTable;
    @javafx.fxml.FXML
    private TableColumn invoiceIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void sidebarOutstandingPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
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