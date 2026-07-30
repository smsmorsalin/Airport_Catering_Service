package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.CustomerSupportOfficer;

import java.io.IOException;

public class GenerateReportsViewController
{
    @javafx.fxml.FXML
    private Button generateReportBtn;
    @javafx.fxml.FXML
    private Label reportStatusLabel;
    @javafx.fxml.FXML
    private ComboBox reportTypeCombo;
    @javafx.fxml.FXML
    private Button exportPdfBtn;
    @javafx.fxml.FXML
    private Label generatedReportLabel;
    @javafx.fxml.FXML
    private TextField airlineTextField;
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private ComboBox dateRangeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ResetOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPDFOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void GenerateReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) {
    }
}