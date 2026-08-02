package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.FoodQualityControlOfficer;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

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
        reportTypeComboBox.getItems().addAll( "Daily", "Weekly", "Monthly", "Inspection", "Approval", "Rejection", "Compliance", "Quality Trend");
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
        if(startDatePicker.getValue() == null || endDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(startDatePicker.getValue().isAfter(endDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(endDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invaid Input","End date can not be present date");
            return;
        }
        if(reportTypeComboBox.getItems()==null){
            AlertGenerator.showAlert("Wrong Input","Combo Box must be selected ");
        }
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