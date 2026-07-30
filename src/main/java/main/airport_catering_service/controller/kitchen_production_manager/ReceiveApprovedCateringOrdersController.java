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

    @FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }

    @FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}