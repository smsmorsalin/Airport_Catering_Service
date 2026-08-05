package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import nonuser.FoodRejection;
import user.FoodQualityControlOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;


public class RejectBatchController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionReasonLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionIDLabel;
    @javafx.fxml.FXML
    private TextArea rejectionReasonTextArea;
    @javafx.fxml.FXML
    private TextField batchNumberTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionDateLabel;

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

        //check that all field are not empty
        //load FoodRejection.bin file
        //FoodRejection newRejection = new FoodRejection(rejectionId, batchNumber, rejectionId, rejectionStatus)
        //write new reject in foodRejection.bin file

//        fxidDisplayRejectionIDLabel.setText("Rejection ID: "+ newRejection.rejectionId);
//        fxidDisplayRejectionDateLabel.setText("rejection Date: "+ newRejection.rejectionDate);
//        fxidDisplayRejectionReasonLabel.setText("rejection Status"+ newRejection.rejectionStatus);
    }


    @javafx.fxml.FXML
    public void rejectionBatchOnAction(ActionEvent actionEvent) {
        rejectionReasonTextArea.clear();
        batchNumberTextField.clear();


        if(batchNumberTextField.getText() == null || rejectionReasonTextArea.getText() == null){
            AlertGenerator.showAlert("Missing Information", "Please enter the batch batch number and rejection reason");
            return;
        }
        int batchNum;
        try{
            batchNum = Integer.parseInt(batchNumberTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Inpujt","Batch Number must be filled with integer");
            return;
        }
        if (batchNum<= 0){
            AlertGenerator.showAlert("Invalid Input","Batch number must be grater that 0");
            return;
        }
//public FoodRejection(int rejectionId, int batchNumber, LocalDate rejectionDate, String rejectionReason, String rejectionStatus)
//        FoodRejection newRejection = new FoodRejection(
//                 Integer.parseInt(rejectionReasonTextArea.getText()),
//                Integer.parseInt(rejectionReasonTextArea.getText()),
//        );
//
//
//        fxidDisplayRejectionIDLabel.setText(
//                "Rejection ID: " + newRejection.getRejectionId()
//        );
//
//        fxidDisplayRejectionDateLabel.setText(
//                "Rejection Date: " + newRejection.getRejectionDate()
//        );
//
//        fxidDisplayRejectionReasonLabel.setText(
//                "Rejection Status: " + newRejection.getRejectionStatus()
//        );
//
//
//        AlertGenerator.showAlert("Batch Rejected", "The batch was rejected successfully");
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
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
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent) {
       FoodQualityControlOfficer.viewPerformInspection(actionEvent,loggedInUser);
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