package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class PerformInspectionController
{
    @javafx.fxml.FXML
    private ComboBox tasteRatingComboBox;
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
    private ComboBox appearanceRatingComboBox;
    @javafx.fxml.FXML
    private ComboBox textureRatingbelComboBox;
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
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
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
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) {
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