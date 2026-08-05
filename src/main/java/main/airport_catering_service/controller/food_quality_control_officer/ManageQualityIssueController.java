package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ManageQualityIssueController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextArea followUpNotesTextArea;
    @javafx.fxml.FXML
    private Label fxidDisplayFollowUpdateLabel;
    @javafx.fxml.FXML
    private TextField issueIDTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayResponsibleDepartmentLabel;

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
    public void searchOnAction(ActionEvent actionEvent) {
        if (issueIDTextField.getText().trim().isEmpty() || followUpNotesTextArea.getText().isEmpty()){
            AlertGenerator.showAlert("Wrong Input", "TextFiled and Text Area should be filled");
            return;
        }
        int issueId;
        try{
            issueId = Integer.parseInt(issueIDTextField.getText());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Input","Issue Id should be an Integer");
            return;
        }
        if(issueId <= 0){
            AlertGenerator.showAlert("Invalid Input","Issue Id should be grater than 0");
            return;
        }
        if (followUpNotesTextArea.getText().matches("\\d+")){
            AlertGenerator.showAlert("Invalid Input","Follow up notes should be done with character not Numbers");
            return;
        }

    }
    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @Deprecated
    public void sideBarQAReportOnAction(ActionEvent actionEvent)  {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewRejectBatch(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewFoodSafetyCheck(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent){
        FoodQualityControlOfficer.viewPerformInspection(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewApproveBatch(actionEvent,loggedInUser );

    }
    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewQualityTrendAnalysis(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent,loggedInUser);
    }


    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
    }
}