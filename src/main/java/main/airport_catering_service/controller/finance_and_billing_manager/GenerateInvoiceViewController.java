package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.CateringOrder;
import nonuser.Invoice;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateInvoiceViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label packagingCostLabel;
    @javafx.fxml.FXML
    private Label rawMaterialCostLabel;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private Label summaryTotalAmountLabel;
    @javafx.fxml.FXML
    private Label productionCostLabel;
    @javafx.fxml.FXML
    private Label summaryAirlineNameLabel;
    @javafx.fxml.FXML
    private Label invoiceIdLabel;
    @javafx.fxml.FXML
    private Label summaryDateLabel;
    @javafx.fxml.FXML
    private Label summaryOrderLabel;
    @javafx.fxml.FXML
    private Label ingredientCostLabel;
    @javafx.fxml.FXML
    private DatePicker dueDatePicker;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private Label transportCostLabel;
    @javafx.fxml.FXML
    private Label operationCostLabel;
    @javafx.fxml.FXML
    private Label airlineNameLabel;
    @javafx.fxml.FXML
    private TextField billingAddressTextField;
    @javafx.fxml.FXML
    private Button verifyOrderButton;
    @javafx.fxml.FXML
    private Button generateInvoiceButton;

    private int selectedCateringOrderId;
    private ArrayList<Object> selectedObjectedList;
    @javafx.fxml.FXML
    private Label OrderIdLabel;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    private CateringOrder selectedCateringOrder;

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
    public void generateinvoiceOnAction(ActionEvent actionEvent) {

        if(orderidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        if(billingAddressTextField.getText().trim().matches("//d+")){
            AlertGenerator.showAlert("Invalid Input","Billing Address  Should be String");
            return;
        }
        int ingredientId;
        try{
            ingredientId = Integer.parseInt(orderidTextField.getText());
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","textField should be an integer");
            return;
        }
        if(ingredientId <= 0){
            AlertGenerator.showAlert("Invalid Input","Text field should be grater than 0");
            return;
        }

        if(orderidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }

        if(dueDatePicker.getValue().isBefore(LocalDate.now()) || dueDatePicker.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Date should not be past date");
            return;
        }


    }

    @Deprecated
    public void sidebarGenerateInvoiceOnAction(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void VerifyOrderOnAction(ActionEvent actionEvent) {
        try{
            selectedCateringOrderId = Integer.parseInt(orderidTextField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("error", "Enter an integer Value");
            return;
        }
        selectedObjectedList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for(Object obj : selectedObjectedList){
            if (obj instanceof CateringOrder cateringOrder){
                if(cateringOrder.getOrderId() == selectedCateringOrderId){
                    if(cateringOrder.getStatus().equals("Canceled")){
                        AlertGenerator.showAlert("error", "Order Already canceled");
                        return;
                    }
                    if(cateringOrder.getStatus().equals("Delivery")){
                        AlertGenerator.showAlert("error", "Order Already Delivered");
                        return;
                    }
                    if(cateringOrder.getStatus().equals("Rejected")){
                        AlertGenerator.showAlert("error", "Order Already Rejected");
                        return;
                    }
                    ArrayList<Object> selectedInvoiceList = BinaryFileUtility.readObjects("Invoice.bin");

                    for (Object obj2 : selectedInvoiceList){
                        if (obj2 instanceof Invoice invoice){
                            if(invoice.getOrderId() == selectedCateringOrderId){
                                AlertGenerator.showAlert("error", "Already Invoice Generated");
                                return;
                            }
                            selectedCateringOrder = cateringOrder;
                        }
                    }
                    OrderIdLabel.setText("Order Id: " +cateringOrder.getOrderId());
                    orderStatusLabel.setText("Order Status: "+ cateringOrder.getStatus());
                    return;
                }
            }
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