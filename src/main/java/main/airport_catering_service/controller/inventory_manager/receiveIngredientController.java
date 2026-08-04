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

public class receiveIngredientController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label ingredientNameLabel;
    @javafx.fxml.FXML
    private Text deliveryNoteNumberText;
    @javafx.fxml.FXML
    private Text supplierNameText;
    @javafx.fxml.FXML
    private Label receivingDateLabel;
    @javafx.fxml.FXML
    private Label receivingIdLabel;
    @javafx.fxml.FXML
    private Text receivedQuantityText;
    @javafx.fxml.FXML
    private TextField purchaseRequestIdTextfield;
    @javafx.fxml.FXML
    private TextField supplierNameTextfield;
    @javafx.fxml.FXML
    private Text purchaseRequestIdText;
    @javafx.fxml.FXML
    private TextField deliveryNoteNumberTextfield;
    @javafx.fxml.FXML
    private TextField receivedQuantityTextfield;
    @javafx.fxml.FXML
    private Label quantityLabel;
    @javafx.fxml.FXML
    private Label supplierLabel;

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
    }
}