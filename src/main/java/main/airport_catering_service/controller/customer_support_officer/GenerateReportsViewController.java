package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Report;
import user.CustomerSupportOfficer;

import java.io.IOException;

public class GenerateReportsViewController
{
    @javafx.fxml.FXML
    private Button generateReportBtn;
    @javafx.fxml.FXML
    private Label reportStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeCombo;
    @javafx.fxml.FXML
    private Label generatedReportLabel;
    @javafx.fxml.FXML
    private TextField airlineTextField;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> dateRangeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewFlightDelayRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws  IOException {
        CustomerSupportOfficer.viewGenerateReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewServiceUpdates(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewFlightCancellation(actionEvent);
    }


    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewResolveComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }
}