package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.InventoryManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class updateInventoryController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label ingredientNameLabel;
    @javafx.fxml.FXML
    private TextField ingredientIdTextfield;
    @javafx.fxml.FXML
    private Text ingredientIdText;
    @javafx.fxml.FXML
    private Label newQuantityLabel;
    @javafx.fxml.FXML
    private Label ingredientIdLabel;
    @javafx.fxml.FXML
    private TextField newQuantityTextfield;
    @javafx.fxml.FXML
    private Text ingredientNameText;
    @javafx.fxml.FXML
    private Text newQuantityText;
    @javafx.fxml.FXML
    private TextField ingredientNameTextfield;
    @javafx.fxml.FXML
    private Label quantityLabel;


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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        InventoryManager.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {

        if (ingredientIdTextfield.getText().trim().isEmpty() || newQuantityTextfield.getText().trim().isEmpty()
                || ingredientNameTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        int ingredientId;
        int newQuantity;

        try {
            ingredientId = Integer.parseInt(ingredientIdTextfield.getText().trim());
            newQuantity = Integer.parseInt(newQuantityTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Ingredient ID and New Quantity must be integers.");
            return;
        }

        if (ingredientId <= 0 || newQuantity <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Ingredient ID and New Quantity must be greater than 0.");
            return;
        }

        String ingredientName = ingredientNameTextfield.getText().trim();
    }
}
