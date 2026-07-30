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

import java.io.IOException;

public class PerformInspectionController
{
    @javafx.fxml.FXML
    private ComboBox<String> tasteRatingComboBox;
    @javafx.fxml.FXML
    private TextField temperatureReadingTextField;
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
    private ComboBox<String> textureRatingbelComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayOverallScoreLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayInspectioStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApproveBatchView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveInspectionRequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveInspectionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) throws  IOException{
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

    @javafx.fxml.FXML
    public void searchBatchOnAction(ActionEvent actionEvent) {
    }
}