package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreateProductionPlanController
{
    @javafx.fxml.FXML
    private ComboBox<String> miniutesTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private TableColumn statusTableView;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfProductionDatePicker;
    @javafx.fxml.FXML
    private Label fxidDisplayProductionDateLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayProductionPlanIDLabel;
    @javafx.fxml.FXML
    private ComboBox<String> hourTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayMealCategoriesLabel;
    @javafx.fxml.FXML
    private TableColumn endTimeTableView;
    @javafx.fxml.FXML
    private Label fxidDisplayCompletionTimeLabel;
    @javafx.fxml.FXML
    private TableColumn startTimeTableView;
    @javafx.fxml.FXML
    private TextArea specialInstructionsTextArea;
    @javafx.fxml.FXML
    private TableColumn stageNameTableView;
    @javafx.fxml.FXML
    private TableView mainTableView;

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
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createPlanOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRequestQualityInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarUpdateProductionStatusOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorCookingProgressOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarAssignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarViewProductionTasksOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }
}