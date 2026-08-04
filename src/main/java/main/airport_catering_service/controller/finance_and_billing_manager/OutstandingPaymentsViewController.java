package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.DeliveryStatus;
import nonuser.Invoice;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class OutstandingPaymentsViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Invoice, LocalDate> dueDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> invoiceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn <Airline,String > airlineColumn;
    @javafx.fxml.FXML
    private TableColumn <DeliveryStatus,String> statusColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Double> amountColumn;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Integer> overdueColumn;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Label totalDueLabel;
    @javafx.fxml.FXML
    private TableView <Invoice> outstandingInvoiceTable;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Integer> invoiceIdColumn;

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
    public void sidebarOutstandingPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {

        if(invoiceStatusComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(startDatePicker.getValue() == null || endDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(startDatePicker.getValue().isAfter(endDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(endDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invalid Input","End date can not be present date");
            return;
        }


    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageOnAction(ActionEvent actionEvent) {
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
                loggedInUser);
    }

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
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/PaymentHistoryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/CalculateCostView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/FinancialReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/finance_and_billing_manager/OutstandingPaymentsView.fxml",
                loggedInUser);
    }
}