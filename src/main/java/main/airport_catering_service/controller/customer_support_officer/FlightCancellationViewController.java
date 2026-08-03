package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.CustomerSupportOfficer;

import java.io.IOException;

public class FlightCancellationViewController
{
    @javafx.fxml.FXML
    private Button verifyOrderBtn;
    @javafx.fxml.FXML
    private Button cancelFlightBtn;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private TextArea notesTextField;
    @javafx.fxml.FXML
    private Label cancelStatusLabel;
    @javafx.fxml.FXML
    private Label summaryOrderidLabel;
    @javafx.fxml.FXML
    private Label refundStatusLabel;
    @javafx.fxml.FXML
    private Label Statuslabel;
    @javafx.fxml.FXML
    private ComboBox<String> reasonComboBox;
    @javafx.fxml.FXML
    private TextField airlineNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CancelFlightOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void FlightCancellationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void VerifyOrderOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewFlightDelayRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewGenerateReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws  IOException{
        CustomerSupportOfficer.viewServiceUpdates(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewFlightCancellation(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewResolveComplaint(actionEvent);
    }
}