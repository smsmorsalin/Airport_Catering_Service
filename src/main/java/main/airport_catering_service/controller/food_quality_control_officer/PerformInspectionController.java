package main.airport_catering_service.controller.food_quality_control_officer;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.airport_catering_service.HelloApplication;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class PerformInspectionController implements UserReceiver
{
    @javafx.fxml.FXML
    private ComboBox<String> tasteRatingComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayInspectionDateLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayInspectionIDLabel;
    @javafx.fxml.FXML
    private TextArea inspectionNotesTextArea;
    @javafx.fxml.FXML
    private TextField batchNumberTextField;
    @javafx.fxml.FXML
    private ComboBox<String> appearanceRatingComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayOverallScoreLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayInspectioStatusLabel;


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
        appearanceRatingComboBox.getItems().addAll("Excellent","Good","Fair","Poor");
        tasteRatingComboBox.getItems().addAll("1","2","3","4,","5");
    }

    @javafx.fxml.FXML
    public void saveInspectionOnAction(ActionEvent actionEvent) {

        if(batchNumberTextField.getText().trim().isEmpty() || inspectionNotesTextArea.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text Area/Text Filed should be filled");
            return;
        }
        int batchNum;
        try{
            batchNum = Integer.parseInt(batchNumberTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Input","Batch number should be filled with integer");
            return;
        }
        if (batchNum <= 0){
            AlertGenerator.showAlert("Invalid Input","Batch number should be grater than 0");
            return;
        }
        if (appearanceRatingComboBox.getValue() == null || tasteRatingComboBox.getValue() == null){
            AlertGenerator.showAlert("Selected Error","Combo Box valued should be select");
            return;
        }
        if (inspectionNotesTextArea.getText().matches("//d+")){
            AlertGenerator.showAlert("Invalid Error","TextArea should be fill with characters");
            return;
        }
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws  IOException{
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }


    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) throws IOException {

        FoodQualityControlOfficer.viewRejectBatch(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewQualityTrendAnalysis(actionEvent,loggedInUser);
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
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewApproveBatch(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewManageQualityIssue(actionEvent,loggedInUser);
    }


}