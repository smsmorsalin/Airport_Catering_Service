package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class ApproveBatchController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalStatusLabel;
    @javafx.fxml.FXML
    private TextArea approvalRemarksTextArea;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalDateLabel;
    @javafx.fxml.FXML
    private TextField batchNumberTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalByLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalIdLabel;

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
    public void approveBatchOnAction(ActionEvent actionEvent) {

        if(batchNumberTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Wring Input","Batch number should be filled with integer");
            return;
        }
        if(approvalRemarksTextArea.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Wring Input","Approve remark should be filled with integer");
            return;
        }
        int batchId;
        try{
            batchId = Integer.parseInt(batchNumberTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid","Batch Id should be Integer");
            return;
        }
        if(batchId <= 0){
            AlertGenerator.showAlert("Invalid Inout","Batch id should ne grater than 0");
            return;
        }
        if(approvalRemarksTextArea.getText().matches("//d+")){
            AlertGenerator.showAlert("Invalid Input","Approve Remark should be Character");
            return;
        }
    }
    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent,loggedInUser);
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
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewManageQualityIssue(actionEvent,loggedInUser);
    }
}