package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.InventoryManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class generateInventoryReportController implements UserReceiver
{
    @javafx.fxml.FXML
    private DatePicker startDateDatepicker;
    @javafx.fxml.FXML
    private Label purchaseHistoryLabel;
    @javafx.fxml.FXML
    private Text reportTypeText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private Label ingredientConsumptionLabel;
    @javafx.fxml.FXML
    private DatePicker endDateDatepicker;
    @javafx.fxml.FXML
    private TextField reportTypeTextfield;
    @javafx.fxml.FXML
    private Text endDateText;
    @javafx.fxml.FXML
    private Label currentStockSummaryLabel;

    private InventoryManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof InventoryManager inventoryManager){
            loggedInUser = inventoryManager;
            return;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void manageSupplierButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderManageSupplier(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void updateInventoryButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderUpdateInventory(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void createPurchaseRequestButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderCreatePurchaseRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateInventoryReportButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderGenerateInventoryReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void lowStockAlertButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderLowStockAlert(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void checkIngredientAvailabilityButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderCheckIngredientAvailability(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void reserveIngredientButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderReserveIngredient(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void downloadInventoryReportButtonOnAction(ActionEvent actionEvent) {

        if ( reportTypeTextfield.getText().trim().isEmpty()
                || startDateDatepicker.getValue() == null || endDateDatepicker.getValue() == null) {

            AlertGenerator.showAlert("Invalid Input", "Report Type, Start Date and End Date must be filled.");
            return;
        }

        String reportType = reportTypeTextfield.getText().trim();

        if (endDateDatepicker.getValue().isBefore(startDateDatepicker.getValue())) {
            AlertGenerator.showAlert("Invalid Input", "End Date cannot be before Start Date.");
            return;
        }
    }

    @javafx.fxml.FXML
    public void receiveIngredientButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderReceiveIngredient(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        InventoryManager.renderDashboard(actionEvent,loggedInUser);
    }
}