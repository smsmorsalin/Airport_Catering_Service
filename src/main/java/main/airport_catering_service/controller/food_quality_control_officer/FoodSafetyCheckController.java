package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FoodQualityControlOfficer;
import utility.AlertGenerator;

import java.io.IOException;

public class FoodSafetyCheckController
{
    @javafx.fxml.FXML
    private Label fxidDisplayBatchNumberLabel;
    @javafx.fxml.FXML
    private CheckBox hygieneChecklistCheckBox;
    @javafx.fxml.FXML
    private Label fxidDisplayComplianceIdLabel;
    @javafx.fxml.FXML
    private CheckBox expiryVerificationCheckBox;
    @javafx.fxml.FXML
    private TextField batchNumberTextField;
    @javafx.fxml.FXML
    private TextField storageTemperatureTextField;
    @javafx.fxml.FXML
    private Label fxidDisplaySafetyStatusLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayViolationsFoundLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void evaluateOnAction(ActionEvent actionEvent) {

        if (batchNumberTextField.getText().trim().isEmpty() || storageTemperatureTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Wrong Input", "TextFiled should be filled with number");
            return;
        }
        int batchNum;
        float temperatureNum;
        try{
            batchNum = Integer.parseInt(batchNumberTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid","Batch number should be an Integer");
            return;
        }
        try {
            temperatureNum = Float.parseFloat(storageTemperatureTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Input","Temperature should be an float number");
            return;
        }
        if(batchNum <= 0){
            AlertGenerator.showAlert("Invalid Input","Batch number should not be less than 0");
            return;
        }
        if(temperatureNum < 0){
            AlertGenerator.showAlert("Invalid Input","Temperature should not be less than 0");
            return;
        }
        if(!expiryVerificationCheckBox.isSelected() || !hygieneChecklistCheckBox.isSelected()){
            AlertGenerator.showAlert("Validation Error","Select the checkBox  Expiry Verification / Hygiene Checklist");
            return;
        }
    }


    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void slideBarPerformInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
    }
}