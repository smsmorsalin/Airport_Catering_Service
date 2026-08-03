package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import user.InventoryManager;

import java.io.IOException;

public class lowStockAlertController
{
    @javafx.fxml.FXML
    private TableColumn shortageQuantityTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn ingredientIdTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn ingredientNameTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn currentQuantityTableviewColumn;

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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent)throws IOException {
        InventoryManager.renderDashboard(actionEvent);
    }
}