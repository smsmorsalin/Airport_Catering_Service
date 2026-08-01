package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import user.FoodQualityControlOfficer;

import java.io.IOException;

public class QualityTrendAnalysisController
{
    @javafx.fxml.FXML
    private Label fxidDisplayCommonDefectLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayComplianceRateLabel;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Label fxidDisplayGenerateQAReportLabel;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private Label fxidDisplayRejectedBatchesLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayPassedBatchesLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void analyzeTrendsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarManageQualityIssueOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
    }
}