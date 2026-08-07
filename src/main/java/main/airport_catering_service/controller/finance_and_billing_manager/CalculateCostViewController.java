package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.CateringOrder;
import nonuser.CostRecord;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalculateCostViewController implements UserReceiver
{
    private static final String AIRLINE_FILE = "Airline.bin";
    private static final String ORDER_FILE = "CateringOrder.bin";
    private static final String COST_FILE = "CostRecord.bin";
    private CateringOrder selectedOrder;
    private double calculatedTotal;

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


    private FinanceAndBillingManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FinanceAndBillingManager financeAndBillingManager){
            this.loggedInUser = financeAndBillingManager;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        for (Object object : BinaryFileUtility.readObjects(AIRLINE_FILE)) {
            if (object instanceof Airline airline) {
                airlineNameCombobox.getItems().add(
                        airline.getAirlineId() + " - " + airline.getAirlineName());
            }
        }
        resetSummary();
    }



    @javafx.fxml.FXML
    public void saveCostRecordOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null || selectedOrder == null || calculatedTotal <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Search an order and calculate its cost first");
            return;
        }
        CostRecord record = new CostRecord(
                selectedOrder.getOrderId(), parseCost(rawMaterialCostTextField),
                parseCost(ingredientCostTextField), parseCost(productionCostTextField),
                parseCost(operationalCostTextField), parseCost(packagingCostTextField),
                parseCost(transportationCostTextField),
                cateringdatepicker.getValue() == null ? LocalDate.now() : cateringdatepicker.getValue());
        if (!BinaryFileUtility.writeObjects(COST_FILE, record)) {
            AlertGenerator.showAlert("Error", "Cost record could not be saved");
            return;
        }
        AlertGenerator.showAlert("Success", "Cost record saved successfully");
    }

    @javafx.fxml.FXML
    public void calculateTotalCostOnAction(ActionEvent actionEvent) {
        if (selectedOrder == null || airlineNameCombobox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Search an order and select an airline first");
            return;
        }
        try {
            double raw = parseCost(rawMaterialCostTextField);
            double ingredient = parseCost(ingredientCostTextField);
            double production = parseCost(productionCostTextField);
            double operational = parseCost(operationalCostTextField);
            double packaging = parseCost(packagingCostTextField);
            double transport = parseCost(transportationCostTextField);
            calculatedTotal = raw + ingredient + production + operational + packaging + transport;
            setLabel(summaryRawMaterialCostLabel, raw);
            setLabel(summaryIngredientCostLabel, ingredient);
            setLabel(summaryProductionCostLabel, production);
            setLabel(summaryOperationalCostLabel, operational);
            setLabel(summaryPackagingCostLabel, packaging);
            setLabel(summaryTransportCostLabel, transport);
            setLabel(totalCostLabel, calculatedTotal);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "All costs must be valid non-negative numbers");
        }
    }

    @javafx.fxml.FXML
    public void searchorderOnAction(ActionEvent actionEvent) {
        int orderId;
        try {
            orderId = Integer.parseInt(orderidTextField.getText().trim());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID should be an integer");
            return;
        }
        selectedOrder = null;
        for (Object object : BinaryFileUtility.readObjects(ORDER_FILE)) {
            if (object instanceof CateringOrder order && order.getOrderId() == orderId) {
                selectedOrder = order;
                break;
            }
        }
        if (selectedOrder == null) {
            AlertGenerator.showAlert("Order Not Found", "No order was found with ID " + orderId);
            return;
        }
        orderStatusLabel.setText(selectedOrder.getStatus());
        productionStatusLabel.setText(selectedOrder.isDelay() ? "Delayed" : "Scheduled");
        cateringdatepicker.setValue(selectedOrder.getDeliveryDate());
        orderTimeField.setText(selectedOrder.getDeliveryTime() == null ? "" : selectedOrder.getDeliveryTime().toString());
        airlineNameCombobox.getSelectionModel().select(findAirline(selectedOrder.getAirlineId()));
        AlertGenerator.showAlert("Success", "Order details loaded");
    }

    private String findAirline(String airlineId) {
        for (String item : airlineNameCombobox.getItems()) {
            if (item.startsWith(airlineId + " - ")) return item;
        }
        return null;
    }

    private double parseCost(TextField field) {
        double value = Double.parseDouble(field.getText().trim());
        if (value < 0) throw new NumberFormatException();
        return value;
    }

    private void setLabel(Label label, double value) {
        label.setText(String.format("%.2f", value));
    }

    private void resetSummary() {
        setLabel(summaryRawMaterialCostLabel, 0);
        setLabel(summaryIngredientCostLabel, 0);
        setLabel(summaryProductionCostLabel, 0);
        setLabel(summaryOperationalCostLabel, 0);
        setLabel(summaryPackagingCostLabel, 0);
        setLabel(summaryTransportCostLabel, 0);
        setLabel(totalCostLabel, 0);
    }

    private void switchTo(ActionEvent actionEvent, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, view, loggedInUser);
    }



    @javafx.fxml.FXML
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/CalculateCostView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/GenerateInvoiceView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RecordPaymentView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/ProcessRefundView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/OutstandingPaymentsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/FinancialReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RevenueSummaryView.fxml",
                loggedInUser);
    }


    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/PaymentHistoryView.fxml",
                loggedInUser);
    }

}
