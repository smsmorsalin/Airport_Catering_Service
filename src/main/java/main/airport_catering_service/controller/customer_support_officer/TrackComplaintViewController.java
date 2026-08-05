package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Complaint;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class TrackComplaintViewController implements UserReceiver
{
    private static final String COMPLAINT_FILE = "Complaint.bin";

    @javafx.fxml.FXML
    private Label complaintIdLabel;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private Label orderLabel;
    @javafx.fxml.FXML
    private Label categoryLabel;
    @javafx.fxml.FXML
    private Label airlineLabel;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Label departmentLabel;
    @javafx.fxml.FXML
    private TextField complaintIdTextField;


    private CustomerSupportOfficer loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof CustomerSupportOfficer customerSupportOfficer){
            this.loggedInUser = customerSupportOfficer;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        clearDetails();
    }

    @javafx.fxml.FXML
    public void ResolveComplaintOnAction(ActionEvent actionEvent) throws IOException {
        if (complaintIdTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Complaint ID should be filled");
            return;
        }
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/ResolveComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void SearchComplaintOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String complaintIdText = complaintIdTextField.getText().trim();
        if (complaintIdText.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Complaint ID should be filled");
            return;
        }

        int complaintId;
        try {
            complaintId = Integer.parseInt(complaintIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Wrong Input", "Complaint ID should be an integer");
            return;
        }
        if (complaintId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Complaint ID should be greater than 0");
            return;
        }

        Complaint selectedComplaint = null;
        ArrayList<Object> complaints = BinaryFileUtility.readObjects(COMPLAINT_FILE);
        for (Object object : complaints) {
            if (object instanceof Complaint complaint
                    && complaint.getComplaintId() == complaintId) {
                selectedComplaint = complaint;
                break;
            }
        }

        if (selectedComplaint == null) {
            clearDetails();
            AlertGenerator.showAlert("Complaint Not Found", "No complaint was found with ID " + complaintId);
            return;
        }

        showDetails(selectedComplaint);
        AlertGenerator.showAlert("Success", "Complaint details loaded");
    }

    private void showDetails(Complaint complaint) {
        complaintIdLabel.setText(String.valueOf(complaint.getComplaintId()));
        airlineLabel.setText(complaint.getAirlineId());
        orderLabel.setText(String.valueOf(complaint.getOrderId()));
        categoryLabel.setText(complaint.getCategory());
        departmentLabel.setText(getDepartment(complaint.getCategory()));
        statusLabel.setText(complaint.getStatus());
    }

    private String getDepartment(String category) {
        return switch (category) {
            case "Food Quality" -> "Quality Assurance";
            case "Billing Issue" -> "Finance and Billing";
            case "Delivery Issue" -> "Dispatch Operations";
            default -> "Customer Support";
        };
    }

    private void clearDetails() {
        complaintIdLabel.setText("-");
        airlineLabel.setText("-");
        orderLabel.setText("-");
        categoryLabel.setText("-");
        departmentLabel.setText("-");
        statusLabel.setText("-");
    }

    @javafx.fxml.FXML
    public void sidebarHomaPageOnAction(ActionEvent actionEvent) throws IOException {
        sidebarHomePageOnAction(actionEvent);
    }


    @Deprecated
    public void TrackComplaintOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/RegisterComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/TrackComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws  IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/GenerateReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/ServiceUpdatesView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/FlightCancellationView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/ResolveComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/EmergencyModificationView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/FlightDelayRequestView.fxml",
                loggedInUser);
    }
}
