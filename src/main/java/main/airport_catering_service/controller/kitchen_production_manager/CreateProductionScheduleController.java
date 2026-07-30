package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.KitchenProductionManager;

import java.io.IOException;

public class CreateProductionScheduleController
{
    @javafx.fxml.FXML
    private ComboBox<String> startsHoursTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> workShiftComboBox1;
    @javafx.fxml.FXML
    private Label fxidDisplayMealCategoriesLabel;
    @javafx.fxml.FXML
    private ComboBox<String> endsMinutiesTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> startHoursTimeComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayScheduleIDLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayScheduledStartTimeLabel;
    @javafx.fxml.FXML
    private TextField productionPlanIDTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayProductionPlanIDLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayWorkShiftLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayScheduledEndTimeLabel;
    @javafx.fxml.FXML
    private ComboBox endsHoursTimeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRequestQualityInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarManageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarAssignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarViewProductionTasksOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createScheduleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarUpdateProductionStatusOnAction(ActionEvent actionEvent) {
    }
}