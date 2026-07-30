package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import user.FinanceAndBillingManager;

import javax.imageio.IIOException;
import java.io.IOException;

public class dashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewCalculateCost(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {

        FinanceAndBillingManager.viewRevenueSummary(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException {

        FinanceAndBillingManager.viewRecordPayment(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException {

        FinanceAndBillingManager.viewProcessRefund(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws  IOException{

        FinanceAndBillingManager.viewGenerateInvoice(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException {

        FinanceAndBillingManager.viewPaymentHistory(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException {

        FinanceAndBillingManager.viewFinancialReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws  IOException {

        FinanceAndBillingManager.viewOutstandingPayments(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
    }
}