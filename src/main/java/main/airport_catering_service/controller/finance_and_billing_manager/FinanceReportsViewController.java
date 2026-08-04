package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.FinancialReport;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class FinanceReportsViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label outstandingLabel;
    @javafx.fxml.FXML
    private TableView<FinancialReport> financialReportTable;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> profitColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> paymentColumn;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> revenueColumn;
    @javafx.fxml.FXML
    private Label costLabel;
    @javafx.fxml.FXML
    private Label profitLabel;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> costColumn;
    @javafx.fxml.FXML
    private Label revenueLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport, LocalDate> dateColumn;

    private FinanceAndBillingManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FinanceAndBillingManager FinanceAndBillingManager){
            this.loggedInUser = FinanceAndBillingManager;
        }
        AlertGenerator.showAlert("error", "error Authentication failed");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void sidebarFinancialReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
        if(reportTypeComboBox.getValue() == null){
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

    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
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

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
    }
}