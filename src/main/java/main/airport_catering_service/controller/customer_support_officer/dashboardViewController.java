package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import user.CustomerSupportOfficer;

import java.io.IOException;

public class dashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
        CustomerSupportOfficer c = null;

    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarDashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws  IOException{
        CustomerSupportOfficer.viewGenerateReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewServiceUpdates(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        CustomerSupportOfficer.viewFlightCancellation(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewResolveComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewFlightDelayRequest(actionEvent);
    }
}