package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.InventoryManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class checkIngredientAvailabilityController implements UserReceiver
{
    @javafx.fxml.FXML
    private Text ingredientNameText;
    @javafx.fxml.FXML
    private TableColumn reservedQuantityTableviewColumn;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TableColumn ingredientIdTableviewColumn;
    @javafx.fxml.FXML
    private TextField ingredientNameTextfield;
    @javafx.fxml.FXML
    private TableColumn ingredientNameTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn stockStatusTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TableColumn availableQuantityTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn requiredQuantityTableviewColumn;

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
    public void receiveIngredientButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderReceiveIngredient(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {

        tableview.getItems().clear();

        if (orderIdTextfield.getText().trim().isEmpty() || ingredientNameTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "Order ID and Ingredient Name must be filled.");
            return;
        }

        int orderId;

        try {
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be an integer.");
            return;
        }

        if (orderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be greater than 0.");
            return;
        }

        String ingredientName = ingredientNameTextfield.getText().trim();
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent){
        InventoryManager.renderDashboard(actionEvent, loggedInUser);
    }
}