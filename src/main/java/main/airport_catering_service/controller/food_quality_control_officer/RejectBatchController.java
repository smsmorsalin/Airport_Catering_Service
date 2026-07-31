package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import user.FoodQualityControlOfficer;

import java.io.IOException;


public class RejectBatchController
{
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionReasonLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionIDLabel;
    @javafx.fxml.FXML
    private TextArea rejectionReasonTextArea;
    @javafx.fxml.FXML
    private TextArea correctiveActionRecommendationTextArea;
    @javafx.fxml.FXML
    private TextField batchNumberTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayRejectionDateLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectionBatchOnAction(ActionEvent actionEvent) {
        //check that all field are not empty
        //load FoodRejection.bin file
        //FoodRejection newRejection = new FoodRejection(rejectionId, batchNumber, rejectionId, rejectionStatus)
        //write new reject in foodRejection.bin file

//        fxidDisplayRejectionIDLabel.setText("Rejection ID: "+ newRejection.rejectionId);
//        fxidDisplayRejectionDateLabel.setText("rejection Date: "+ newRejection.rejectionDate);
//        fxidDisplayRejectionReasonLabel.setText("rejection Status"+ newRejection.rejectionStatus);
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
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
    }
}