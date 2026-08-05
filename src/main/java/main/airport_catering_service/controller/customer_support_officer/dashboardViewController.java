package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.DashBoard;
import nonuser.EmergencyModificationRequest;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class dashboardViewController implements UserReceiver {
    private static final String EMERGENCY_MODIFICATION_FILE =
            "EmergencyModification.bin";

    @javafx.fxml.FXML
    private TableColumn<DashBoard, String> descriptionTableView;
    @javafx.fxml.FXML
    private Label emargencyIssueLabel;
    @javafx.fxml.FXML
    private TableColumn<DashBoard, Integer> ticketIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DashBoard, String> statusTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField enterticketIDTextField;
    @javafx.fxml.FXML
    private TableView<DashBoard> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<DashBoard, String> issueTypeTableView;

    private CustomerSupportOfficer loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CustomerSupportOfficer customerSupportOfficer) {
            loggedInUser = customerSupportOfficer;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().setAll(
                "Pending", "Approved", "Rejected", "Resolved");

        ticketIDTableColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        cellData.getValue().getTicketID()));
        issueTypeTableView.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        "Emergency Modification"));
        descriptionTableView.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getDescription()));
        statusTableView.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getStatus()));

        loadEmergencyRequests();
    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String ticketText = enterticketIDTextField.getText().trim();
        if (ticketText.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID should be filled");
            return;
        }

        int ticketId;
        try {
            ticketId = Integer.parseInt(ticketText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Wrong Input", "Ticket ID should be an integer");
            return;
        }
        if (ticketId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID should be greater than 0");
            return;
        }
        if (statusComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Status should be selected");
            return;
        }

        ArrayList<Object> requests =
                BinaryFileUtility.readObjects(EMERGENCY_MODIFICATION_FILE);
        EmergencyModificationRequest selectedRequest = null;
        for (Object object : requests) {
            if (object instanceof EmergencyModificationRequest request
                    && request.getRequestId() == ticketId) {
                selectedRequest = request;
                break;
            }
        }

        if (selectedRequest == null) {
            AlertGenerator.showAlert(
                    "Ticket Not Found",
                    "No emergency issue was found with ticket ID " + ticketId);
            return;
        }
        if ("Resolved".equalsIgnoreCase(selectedRequest.getStatus())
                && !"Resolved".equalsIgnoreCase(statusComboBox.getValue())) {
            AlertGenerator.showAlert(
                    "Invalid Update", "A resolved issue cannot be reopened");
            return;
        }

        selectedRequest.setStatus(statusComboBox.getValue());
        if (!BinaryFileUtility.overwriteObjects(
                EMERGENCY_MODIFICATION_FILE, requests)) {
            AlertGenerator.showAlert("Error", "The issue status could not be saved");
            return;
        }

        AlertGenerator.showAlert("Success", "Issue status updated successfully");
        enterticketIDTextField.clear();
        statusComboBox.getSelectionModel().clearSelection();
        loadEmergencyRequests();
    }

    private void loadEmergencyRequests() {
        ArrayList<DashBoard> rows = new ArrayList<>();
        int pendingCount = 0;

        for (Object object : BinaryFileUtility.readObjects(
                EMERGENCY_MODIFICATION_FILE)) {
            if (object instanceof EmergencyModificationRequest request) {
                String description = request.getModificationRequest()
                        + " | Reason: " + request.getReason()
                        + " | Priority: " + request.getPriority();
                rows.add(new DashBoard(
                        description,
                        request.getRequestId(),
                        request.getStatus(),
                        true));
                if ("Pending".equalsIgnoreCase(request.getStatus())) {
                    pendingCount++;
                }
            }
        }

        mainTableView.getItems().setAll(rows);
        emargencyIssueLabel.setText("Emergency Issues: " + pendingCount);
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/dashboardView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/dashboardView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/RegisterComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/TrackComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/GenerateReportsView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/ServiceUpdatesView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/FlightCancellationView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/ResolveComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/EmergencyModificationView.fxml");
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/FlightDelayRequestView.fxml");
    }

    private void switchTo(ActionEvent actionEvent, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, view, loggedInUser);
    }
}
