package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryStatusViewController
{
    @javafx.fxml.FXML
    private TableView IngredientTableView;
    @javafx.fxml.FXML
    private TextField fxidIngredientNameField;
    @javafx.fxml.FXML
    private TableColumn tableCol_availableQty;
    @javafx.fxml.FXML
    private TableColumn tableCol_currentStock;
    @javafx.fxml.FXML
    private TableColumn tableCol_ingredientName;
    @javafx.fxml.FXML
    private TableColumn tableCol_ReservedQty;
    @javafx.fxml.FXML
    private TableColumn tableCol_recorderLevel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MonitorProductionDetailsButton(Event event) {
    }

    @javafx.fxml.FXML
    public void searchIngredientButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
    }
}