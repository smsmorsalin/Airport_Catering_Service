package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.DeliveryStatus;
import nonuser.Invoice;
import nonuser.Payment;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class PaymentHistoryViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField invoiceIdTextField;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Double> amountColumn;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> methodColumn;
    @javafx.fxml.FXML
    private TextField airlineTextField;
    @javafx.fxml.FXML
    private TableView <Payment> paymentTable;
    @javafx.fxml.FXML
    private TableColumn <Airline,String> airlineColumn;
    @javafx.fxml.FXML
    private TableColumn <DeliveryStatus,String> statusColumn;
    @javafx.fxml.FXML
    private ComboBox<String> paymentStatusComboBox;
    @javafx.fxml.FXML
    private Button searchPaymentBtn;
    @javafx.fxml.FXML
    private TableColumn<Invoice,Integer> invoiceColumn;
    @javafx.fxml.FXML
    private ComboBox <String> airlinenameComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn <Payment,Integer> paymentIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Invoice, LocalDate> dateColumn;

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
    public void sidebarPaymentHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
        if(invoiceIdTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        int invoiceId;
        try{
            invoiceId = Integer.parseInt(invoiceIdTextField.getText());
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","Invoice Id should be an integer");
            return;
        }
        if(invoiceId <= 0){
            AlertGenerator.showAlert("Invalid Input","InvoiceId Text field should be grater than 0");
            return;
        }

        if(airlinenameComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","airline name ComboBox Should be selected");
            return;
        }
        if(paymentStatusComboBox.getValue()==null){
            AlertGenerator.showAlert("Wrong Input","payment status ComboBox Should be selected");
        }

        if(paymentMethodComboBox.getValue()==null){
            AlertGenerator.showAlert("Wrong Input", "payment method ComboBox should be selected");

        }

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

