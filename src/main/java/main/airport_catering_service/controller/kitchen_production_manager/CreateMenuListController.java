package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.KitchenProductionManager;

import java.io.IOException;

public class CreateMenuListController
{
    @javafx.fxml.FXML
    private Label fxidDisplayMenuStatusLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayStaffRequirementLabel;
    @javafx.fxml.FXML
    private TextField staffRequirementTextField;
    @javafx.fxml.FXML
    private ComboBox<String> equipmentComboBox;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> kitchenSectionComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayAssignedEquipmentLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayMenuListIDLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayKitchenSectionLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sideBarmanageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CreateListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRequestQualityInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorCookingProgressOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarViewProductionTasksOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarassignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOrderOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void claerOnAction(ActionEvent actionEvent) {
    }
}