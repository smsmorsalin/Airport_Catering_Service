package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.InventoryManager;

import java.io.IOException;

public class checkIngredientAvailabilityController
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
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        InventoryManager.renderDashboard(actionEvent);
    }
}