package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.InventoryManager;

import java.io.IOException;

public class receiveIngredientController
{
    @javafx.fxml.FXML
    private Label ingredientNameLabel;
    @javafx.fxml.FXML
    private Text deliveryNoteNumberText;
    @javafx.fxml.FXML
    private Label supplierNameLabel;
    @javafx.fxml.FXML
    private Text supplierNameText;
    @javafx.fxml.FXML
    private Label receivingDateLabel;
    @javafx.fxml.FXML
    private Label receivingIdLabel;
    @javafx.fxml.FXML
    private Text receivedQuantityText;
    @javafx.fxml.FXML
    private Label quantityReceivedLabel;
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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void manageSupplierButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateInventoryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createPurchaseRequestButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateInventoryReportButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lowStockAlertButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkIngredientAvailabilityButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reserveIngredientButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void receiveIngredientButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        InventoryManager.renderDashboard(actionEvent);
    }
}