package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import user.KitchenProductionManager;

import java.io.IOException;


public class ReceiveApprovedCateringOrdersController
{
    @javafx.fxml.FXML
    private TableColumn productionOrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn mealTypesTableView;
    @javafx.fxml.FXML
    private TableColumn airlineNameTableView;
    @javafx.fxml.FXML
    private TableColumn deliveryDeadlineTableView;
    @javafx.fxml.FXML
    private TableView mainTableView;
    @FXML
    private TextField productionTaskIDTextField;
    @FXML
    private TableColumn mealQuantityTableView;
    @FXML
    private TextField orderIDTextField1;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarAirporCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);

    }

    @Deprecated
    public void manageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void assignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarmanageMealPreparationOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarRequestQualityInspectionOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarUpdateProductionStatusOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMonitorCookingProgressOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarassignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }
}