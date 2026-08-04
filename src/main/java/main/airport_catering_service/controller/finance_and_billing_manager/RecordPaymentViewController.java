package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class RecordPaymentViewController implements UserReceiver
{
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
        if (user instanceof FinanceAndBillingManager FinanceAndBillingManager){
            this.loggedInUser = FinanceAndBillingManager;
        }
        AlertGenerator.showAlert("error", "error Authentication failed");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void recordpaymentOnAction(ActionEvent actionEvent) {

        if(transactionReferenceTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Reference should be filled");
            return;
        }

        if(amountPaidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Amount Paid should be filled");
            return;
        }

        if(paymentMethodComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(paymentDatePicker.getValue().isBefore(LocalDate.now())){
            AlertGenerator.showAlert("Wrong Input","Date should not be past date");
            return;
        }
    }

    @javafx.fxml.FXML
    public void verifyInvoiceOnAction(ActionEvent actionEvent) {
        if(invoiceidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Invoice Id should be filled");
            return;
        }

        if(airlinenameLabel.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Invoice Id should be filled");
            return;
        }
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