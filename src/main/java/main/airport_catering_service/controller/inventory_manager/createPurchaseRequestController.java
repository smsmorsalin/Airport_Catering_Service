package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.InventoryManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class createPurchaseRequestController implements UserReceiver
{
    @javafx.fxml.FXML
    private Text supplierText;
    @javafx.fxml.FXML
    private TextField supplierTextfield;
    @javafx.fxml.FXML
    private TextField requiredQuantityTextfield;
    @javafx.fxml.FXML
    private Text requiredQuantityText;
    @javafx.fxml.FXML
    private Text expectedDeliveryDateText;
    @javafx.fxml.FXML
    private Label StatusLabel;
    @javafx.fxml.FXML
    private Text ingredientNameText;
    @javafx.fxml.FXML
    private TextField ingredientNameTextfield;
    @javafx.fxml.FXML
    private DatePicker expectedDeliveryDateDatepicker;
    @javafx.fxml.FXML
    private TableColumn quantityTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn supplierTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn ingredientNameTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn purchaseRequestIdTableviewColumn;

    private InventoryManager loggedInUser;
    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof InventoryManager inventoryManager) {
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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {
    }
}