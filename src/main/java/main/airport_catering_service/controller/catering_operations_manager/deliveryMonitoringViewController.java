package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class deliveryMonitoringViewController
{
    @javafx.fxml.FXML
    private TableColumn tableCol_driverName;
    @javafx.fxml.FXML
    private TableColumn tableCol_DeliveryTime;
    @javafx.fxml.FXML
    private DatePicker fxidFromDatePicker;
    @javafx.fxml.FXML
    private TableColumn tabelCol_DeliveryStatus;
    @javafx.fxml.FXML
    private DatePicker fxidToDatePicker;
    @javafx.fxml.FXML
    private TableView deliveryStatusTableView;
    @javafx.fxml.FXML
    private TableColumn tableCol_truckNumber;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadDeliveryStatusButton(ActionEvent actionEvent) {
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
    public void MonitorProductionDetailsButton(Event event) {
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
    }
}