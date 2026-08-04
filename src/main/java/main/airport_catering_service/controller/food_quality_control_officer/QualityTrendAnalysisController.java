package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class QualityTrendAnalysisController implements UserReceiver
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
    }

    @javafx.fxml.FXML
    public void analyzeTrendsOnAction(ActionEvent actionEvent) {
        if (startDatePicker.getValue() == null || endDatePicker
                .getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Date picker should be selected");
            return;
        }
        if (startDatePicker.getValue().isAfter(endDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should not be after End Date");
            return;
        }
        if(endDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Wrong Input","End Date should not be present date");
            return;
        }
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