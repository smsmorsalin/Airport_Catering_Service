package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.CustomerSupportOfficer;
import user.FinanceAndBillingManager;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class CalculateCostViewController
{
    @javafx.fxml.FXML
    private Label summaryRawMaterialCostLabel;
    @javafx.fxml.FXML
    private TextField ingredientCostTextField;
    @javafx.fxml.FXML
    private Button calculateButton;
    @javafx.fxml.FXML
    private Label summaryProductionCostLabel;
    @javafx.fxml.FXML
    private Label productionStatusLabel;
    @javafx.fxml.FXML
    private Button searchOrderButton;
    @javafx.fxml.FXML
    private TextField transportationCostTextField;
    @javafx.fxml.FXML
    private TextField productionCostTextField;
    @javafx.fxml.FXML
    private TextField orderTimeField1;
    @javafx.fxml.FXML
    private TextField operationalCostTextField;
    @javafx.fxml.FXML
    private TextField rawMaterialCostTextField;
    @javafx.fxml.FXML
    private Label summaryPackagingCostLabel;
    @javafx.fxml.FXML
    private DatePicker cateringdatepicker;
    @javafx.fxml.FXML
    private TextField orderTimeField;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private Label summaryTransportCostLabel;
    @javafx.fxml.FXML
    private Button saveCostButton;
    @javafx.fxml.FXML
    private Label summaryOperationalCostLabel;
    @javafx.fxml.FXML
    private Label totalCostLabel;
    @javafx.fxml.FXML
    private ComboBox<String> airlineNameCombobox;
    @javafx.fxml.FXML
    private TextField packagingCostTextField;
    @javafx.fxml.FXML
    private Label summaryIngredientCostLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void resetOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageOnActioon(ActionEvent actionEvent) {
    }

    @Deprecated
    public void cancelOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveCostRecordOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateTotalCostOnAction(ActionEvent actionEvent) {
        if(ingredientCostTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        int ingredientId;
        try{
            ingredientId = Integer.parseInt(ingredientCostTextField.getText());
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","textField should be an integer");
            return;
        }
        if(ingredientId <= 0){
            AlertGenerator.showAlert("Invalid Input","Text field should be grater than 0");
            return;
        }

        if(airlineNameCombobox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(cateringdatepicker.getValue().isBefore(LocalDate.now())){
            AlertGenerator.showAlert("Wrong Input","Date should not be past date");
            return;
        }



    }

    @Deprecated
    public void sideBarCalculateCostOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchorderOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException{

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