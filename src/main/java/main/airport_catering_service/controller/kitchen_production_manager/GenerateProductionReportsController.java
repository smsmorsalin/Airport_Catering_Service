package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class GenerateProductionReportsController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalProductionOrdersLabel;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalMealsProducedLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayDelayedProductionsLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayAverageProductionTimeLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayCompletionRateLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sideBarmanageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
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
    public void sideBarViewProductionTasksOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarassignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eportPDFOnAction(ActionEvent actionEvent) {
    }
}