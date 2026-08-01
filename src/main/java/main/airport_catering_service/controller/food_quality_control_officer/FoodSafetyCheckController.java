package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.FoodQualityControlOfficer;

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

    @Deprecated
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void evaluateOnAction(ActionEvent actionEvent) {
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