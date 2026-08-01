package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.FoodQualityControlOfficer;

import java.io.IOException;

public class GenerateQAReportController
{
    @javafx.fxml.FXML
    private Label fxidDisplayTotalApprovedBatchesLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayAverageQualityScoreLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayCompliancePercentageLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalBatchesInspectedLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalRejectedBatchesLabel;
    @javafx.fxml.FXML
    private Label reportTypeComboBox1;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;

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
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportPDFOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
    }
}