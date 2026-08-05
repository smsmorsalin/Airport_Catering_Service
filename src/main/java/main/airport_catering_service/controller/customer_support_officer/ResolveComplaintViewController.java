package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Complaint;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class ResolveComplaintViewController implements UserReceiver
{
    private static final String COMPLAINT_FILE = "Complaint.bin";

    @javafx.fxml.FXML
    private Label complaintIdLabel;
    @javafx.fxml.FXML
    private Label currentStatusLabel;
    @javafx.fxml.FXML
    private Label orderIdLabel;
    @javafx.fxml.FXML
    private Label airlineLabel;
    @javafx.fxml.FXML
    private TextField complaintidTextField;
    @javafx.fxml.FXML
    private TextArea resolutionNotesTextField;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionStatusComboBox;


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
        resolutionStatusComboBox.getItems().setAll("In Progress", "Resolved", "Rejected");
        clearComplaintDetails();
    }

    @javafx.fxml.FXML
    public void ResolveComplaintOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String complaintIdText = complaintidTextField.getText().trim();
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
        if (resolutionStatusComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Resolution status should be selected");
            return;
        }
        String notes = resolutionNotesTextField.getText().trim();
        if (notes.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Resolution notes should be filled");
            return;
        }

        ArrayList<Object> complaints = BinaryFileUtility.readObjects(COMPLAINT_FILE);
        Complaint selectedComplaint = null;
        for (Object object : complaints) {
            if (object instanceof Complaint complaint
                    && complaint.getComplaintId() == complaintId) {
                selectedComplaint = complaint;
                break;
            }
        }
        if (selectedComplaint == null) {
            AlertGenerator.showAlert("Complaint Not Found", "No complaint was found with ID " + complaintId);
            clearComplaintDetails();
            return;
        }
        if ("Resolved".equalsIgnoreCase(selectedComplaint.getStatus())) {
            AlertGenerator.showAlert("Already Resolved", "This complaint has already been resolved");
            return;
        }

        selectedComplaint.setStatus(resolutionStatusComboBox.getValue());
        selectedComplaint.resolve(notes, loggedInUser.getEmployeeId());
        if (!BinaryFileUtility.overwriteObjects(COMPLAINT_FILE, complaints)) {
            AlertGenerator.showAlert("Error", "Complaint resolution could not be saved");
            return;
        }

        showComplaintDetails(selectedComplaint);
        AlertGenerator.showAlert("Success", "Complaint status updated successfully");
        complaintidTextField.clear();
        resolutionNotesTextField.clear();
        resolutionStatusComboBox.getSelectionModel().clearSelection();
    }

    private void showComplaintDetails(Complaint complaint) {
        complaintIdLabel.setText(String.valueOf(complaint.getComplaintId()));
        airlineLabel.setText(complaint.getAirlineId());
        orderIdLabel.setText(String.valueOf(complaint.getOrderId()));
        currentStatusLabel.setText(complaint.getStatus());
    }

    private void clearComplaintDetails() {
        complaintIdLabel.setText("-");
        airlineLabel.setText("-");
        orderIdLabel.setText("-");
        currentStatusLabel.setText("-");

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
