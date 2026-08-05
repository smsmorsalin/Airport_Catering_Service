package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class GenerateQAReportController implements UserReceiver
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

    private FoodQualityControlOfficer loggedInUser;

    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FoodQualityControlOfficer foodQualityControlOfficer){
            loggedInUser = foodQualityControlOfficer;
            return;
        }
        AlertGenerator.showAlert("Error", "You are not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll( "Daily", "Weekly", "Monthly", "Inspection", "Approval", "Rejection", "Compliance", "Quality Trend");
    }

    @Deprecated
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
            AlertGenerator.showAlert("Invalid Input","End date can not be present date");
            return;
        }
        if(reportTypeComboBox.getItems()==null){
            AlertGenerator.showAlert("Wrong Input","Combo Box must be selected ");
        }
    }
    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewRejectBatch(actionEvent,loggedInUser);

    }
    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewQualityTrendAnalysis(actionEvent, loggedInUser);

    }
    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewFoodSafetyCheck(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewReceiveInspectionRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewPerformInspection(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewRejectBatch(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewManageQualityIssue(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void exportPDFOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportOA(ActionEvent actionEvent) {
    }
}