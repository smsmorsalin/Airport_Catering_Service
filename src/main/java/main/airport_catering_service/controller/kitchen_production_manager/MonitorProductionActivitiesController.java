package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import user.KitchenProductionManager;

public class MonitorProductionActivitiesController
{
    @javafx.fxml.FXML
    private Label fxidDisplayCompletedQuantityLabel;
    @javafx.fxml.FXML
    private TableColumn ProductionStatusTableView;
    @javafx.fxml.FXML
    private TableColumn completionPercentageTableView;
    @javafx.fxml.FXML
    private Label productionOrderIDTextField1;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalQuantityLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayAssignedChefLabel;
    @javafx.fxml.FXML
    private TableColumn delayAlertTableView1;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayAirlineNameLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayRemainingQuantityLabel;
    @javafx.fxml.FXML
    private TableView mainTableView;
    @javafx.fxml.FXML
    private TableColumn productionOrderIDTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @Deprecated
    public void sideBarManageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarUpdateProductionStatusOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarMonitorCookingProgressOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarViewProductionTasksOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarassignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void refreshOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}