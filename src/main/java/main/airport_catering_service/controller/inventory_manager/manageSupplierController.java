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

public class manageSupplierController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label contactInformationLabel;
    @javafx.fxml.FXML
    private Label supplierNameLabel;
    @javafx.fxml.FXML
    private TextField contactPersonTextfield;
    @javafx.fxml.FXML
    private TextField addressTextfield;
    @javafx.fxml.FXML
    private Text addressText;
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private TextField emailTextfield;
    @javafx.fxml.FXML
    private Label supplierIdLabel;
    @javafx.fxml.FXML
    private Text phoneNumberText;
    @javafx.fxml.FXML
    private Text supplierNameText;
    @javafx.fxml.FXML
    private TextField phoneNumberTextfield;
    @javafx.fxml.FXML
    private Label supplierStatusLabel;
    @javafx.fxml.FXML
    private Text contactPersonText;
    @javafx.fxml.FXML
    private TextField supplierNameTextfield;

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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
    }
}