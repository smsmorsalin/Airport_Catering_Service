package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.CateringOrder;
import nonuser.EmergencyModificationRequest;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateReportsViewController implements UserReceiver {
    private static final String AIRLINE_FILE = "Airline.bin";
    private static final String CATERING_ORDER_FILE = "CateringOrder.bin";
    private static final String EMERGENCY_MODIFICATION_FILE =
            "EmergencyModification.bin";

    @javafx.fxml.FXML
    private Button generateReportBtn;
    @javafx.fxml.FXML
    private Label reportStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeCombo;
    @javafx.fxml.FXML
    private Label generatedReportLabel;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> dateRangeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> airlineNameComboBox;

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
        reportTypeCombo.getItems().setAll(
                "Order Summary", "Delay Report", "Cancellation Report",
                "Emergency Issues");
        statusComboBox.getItems().setAll(
                "All", "Pending", "Approved", "Rejected", "Cancelled", "Delivered");
        dateRangeComboBox.getItems().setAll(
                "All Time", "Today", "Last 7 Days", "Last 30 Days");
        airlineNameComboBox.getItems().add("All Airlines");

        for (Object object : BinaryFileUtility.readObjects(AIRLINE_FILE)) {
            if (object instanceof Airline airline) {
                airlineNameComboBox.getItems().add(
                        airline.getAirlineId() + " - " + airline.getAirlineName());
            }
        }
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        if (reportTypeCombo.getValue() == null
                || statusComboBox.getValue() == null
                || dateRangeComboBox.getValue() == null
                || airlineNameComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Please select all report filters");
            return;
        }

        String reportType = reportTypeCombo.getValue();
        String selectedAirline = airlineNameComboBox.getValue();
        String selectedStatus = statusComboBox.getValue();
        LocalDate fromDate = getFromDate(dateRangeComboBox.getValue());

        int orderCount = 0;
        int delayedCount = 0;
        int cancelledCount = 0;
        int emergencyCount = 0;

        for (Object object : BinaryFileUtility.readObjects(CATERING_ORDER_FILE)) {
            if (object instanceof CateringOrder order
                    && matchesAirline(order.getAirlineId(), selectedAirline)
                    && matchesStatus(order.getStatus(), selectedStatus)
                    && matchesDate(order.getOrderDate(), fromDate)) {
                orderCount++;
                if (order.isDelay()) {
                    delayedCount++;
                }
                if ("Cancelled".equalsIgnoreCase(order.getStatus())) {
                    cancelledCount++;
                }
            }
        }

        for (Object object : BinaryFileUtility.readObjects(
                EMERGENCY_MODIFICATION_FILE)) {
            if (object instanceof EmergencyModificationRequest request
                    && matchesStatus(request.getStatus(), selectedStatus)
                    && matchesDate(request.getSubmittedAt().toLocalDate(), fromDate)) {
                emergencyCount++;
            }
        }

        String summary = switch (reportType) {
            case "Delay Report" -> "Delayed orders: " + delayedCount;
            case "Cancellation Report" -> "Cancelled orders: " + cancelledCount;
            case "Emergency Issues" -> "Emergency issues: " + emergencyCount;
            default -> "Matching orders: " + orderCount;
        };

        generatedReportLabel.setText(summary);
        reportStatusLabel.setText("Generated successfully");
        AlertGenerator.showAlert("Success", reportType + " generated successfully");
    }

    private boolean matchesAirline(String orderAirlineId, String selectedAirline) {
        return "All Airlines".equals(selectedAirline)
                || selectedAirline.startsWith(orderAirlineId + " - ");
    }

    private boolean matchesStatus(String actualStatus, String selectedStatus) {
        return "All".equals(selectedStatus)
                || selectedStatus.equalsIgnoreCase(actualStatus);
    }

    private boolean matchesDate(LocalDate date, LocalDate fromDate) {
        return fromDate == null || (date != null && !date.isBefore(fromDate));
    }

    private LocalDate getFromDate(String dateRange) {
        return switch (dateRange) {
            case "Today" -> LocalDate.now();
            case "Last 7 Days" -> LocalDate.now().minusDays(6);
            case "Last 30 Days" -> LocalDate.now().minusDays(29);
            default -> null;
        };
    }

    @javafx.fxml.FXML
    public void GenerateReportsOnAction(ActionEvent actionEvent) {
        GenerateReportOnAction(actionEvent);
    }

    private void switchTo(ActionEvent actionEvent, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, view, loggedInUser);
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
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/RegisterComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/TrackComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/GenerateReportsView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/ServiceUpdatesView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/FlightCancellationView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/ResolveComplaintView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/EmergencyModificationView.fxml");
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        switchTo(actionEvent, "/customer_support_officer/FlightDelayRequestView.fxml");
    }
}
