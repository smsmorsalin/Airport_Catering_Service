package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import nonuser.PurchaseRequest;
import user.InventoryManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private TableColumn<PurchaseRequest, Integer> quantityTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, String> supplierTableviewColumn;
    @javafx.fxml.FXML
    private TableView<PurchaseRequest> tableView;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, String> ingredientNameTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, Integer> purchaseRequestIdTableviewColumn;

    ArrayList<Object> purchaseRequestList;

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
        tableView.getItems().clear();

        ingredientNameTableviewColumn.setCellValueFactory(new PropertyValueFactory<PurchaseRequest, String>("ingredientName"));
        purchaseRequestIdTableviewColumn.setCellValueFactory(new PropertyValueFactory<PurchaseRequest, Integer>("ingredientId"));
        quantityTableviewColumn.setCellValueFactory(new PropertyValueFactory<PurchaseRequest, Integer>("quantity"));
        supplierTableviewColumn.setCellValueFactory(new PropertyValueFactory<PurchaseRequest, String>("supplier"));

        purchaseRequestList = BinaryFileUtility.readObjects("PurchaseRequest.bin");

        for (Object obj : purchaseRequestList){
            if (obj instanceof PurchaseRequest purchaseRequest){
                if(purchaseRequest.getStatus().equals("Pending")){
                    tableView.getItems().add(purchaseRequest);
                }
            }
        }


    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {


        if (supplierTextfield.getText().trim().isEmpty() || ingredientNameTextfield.getText().trim().isEmpty()
                || requiredQuantityTextfield.getText().trim().isEmpty() || expectedDeliveryDateDatepicker.getValue() == null) {

            AlertGenerator.showAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        int requiredQuantity;

        try {
            requiredQuantity = Integer.parseInt(requiredQuantityTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Required Quantity must be an integer.");
            return;
        }

        if (requiredQuantity <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Required Quantity must be greater than 0.");
            return;
        }

        String supplier = supplierTextfield.getText().trim();
        String ingredientName = ingredientNameTextfield.getText().trim();
        LocalDate expectedDeliveryDate = expectedDeliveryDateDatepicker.getValue();

        PurchaseRequest newRequest = loggedInUser.purchaseRequest(ingredientName, requiredQuantity, supplier, expectedDeliveryDate);
        if (newRequest != null){
            tableView.getItems().add(newRequest);
        }

    }






    //button0
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


}