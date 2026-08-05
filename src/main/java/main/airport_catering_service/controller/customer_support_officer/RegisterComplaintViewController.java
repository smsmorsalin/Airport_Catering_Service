package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.CateringOrder;
import nonuser.Complaint;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterComplaintViewController implements UserReceiver
{
    private static final String AIRLINE_FILE = "Airline.bin";
    private static final String CATERING_ORDER_FILE = "CateringOrder.bin";
    private static final String COMPLAINT_FILE = "Complaint.bin";

    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> airlineComboBox;
    @javafx.fxml.FXML
    private CheckBox highCheckBox;
    @javafx.fxml.FXML
    private CheckBox mediumCheckBox;
    @javafx.fxml.FXML
    private TextField orderIdTextField;
    @javafx.fxml.FXML
    private CheckBox criticalCheckBox;
    @javafx.fxml.FXML
    private TextArea descriptionAreaTextField;
    @javafx.fxml.FXML
    private CheckBox lowCheckBox;

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
        categoryComboBox.getItems().setAll(
                "Order Issue", "Delivery Issue", "Food Quality", "Billing Issue", "Other");
        for (Object object : BinaryFileUtility.readObjects(AIRLINE_FILE)) {
            if (object instanceof Airline airline) {
                airlineComboBox.getItems().add(
                        airline.getAirlineId() + " - " + airline.getAirlineName());
            }
        }

        CheckBox[] priorities = {lowCheckBox, mediumCheckBox, highCheckBox, criticalCheckBox};
        for (CheckBox priority : priorities) {
            priority.setOnAction(event -> {
                if (priority.isSelected()) {
                    for (CheckBox other : priorities) {
                        if (other != priority) {
                            other.setSelected(false);
                        }
                    }
                }
            });
        }
    }

    @Deprecated
    public void RegisterComplaintOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitComplaintOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String orderIdText = orderIdTextField.getText().trim();
        if (orderIdText.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Order ID should be filled");
            return;
        }

        int orderId;
        try {
            orderId = Integer.parseInt(orderIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Wrong Input", "Order ID should be an integer");
            return;
        }
        if (orderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Order ID should be greater than 0");
            return;
        }

        if (descriptionAreaTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Complaint description should be filled");
            return;
        }
        if (airlineComboBox.getValue() == null || categoryComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Airline and category should be selected");
            return;
        }

        String priority = getSelectedPriority();
        if (priority == null) {
            AlertGenerator.showAlert("Invalid Input", "One priority level should be selected");
            return;
        }

        CateringOrder order = null;
        for (Object object : BinaryFileUtility.readObjects(CATERING_ORDER_FILE)) {
            if (object instanceof CateringOrder cateringOrder
                    && cateringOrder.getOrderId() == orderId) {
                order = cateringOrder;
                break;
            }
        }
        if (order == null) {
            AlertGenerator.showAlert("Order Not Found", "No catering order was found with ID " + orderId);
            return;
        }
        String airlineId = airlineComboBox.getValue().split(" - ", 2)[0];
        if (!airlineId.equals(order.getAirlineId())) {
            AlertGenerator.showAlert("Invalid Airline", "The selected airline does not own this order");
            return;
        }

        for (Object object : BinaryFileUtility.readObjects(COMPLAINT_FILE)) {
            if (object instanceof Complaint complaint
                    && complaint.getOrderId() == orderId
                    && !"Resolved".equalsIgnoreCase(complaint.getStatus())) {
                AlertGenerator.showAlert("Complaint Exists", "An active complaint already exists for this order");
                return;
            }
        }

        Complaint complaint = new Complaint(
                orderId, airlineId, categoryComboBox.getValue(),
                descriptionAreaTextField.getText().trim(), priority,
                loggedInUser.getEmployeeId());
        if (!BinaryFileUtility.writeObjects(COMPLAINT_FILE, complaint)) {
            AlertGenerator.showAlert("Error", "Complaint could not be saved");
            return;
        }

        AlertGenerator.showAlert(
                "Success", "Complaint registered successfully. Complaint ID: "
                        + complaint.getComplaintId());
        clearForm();
    }

    private String getSelectedPriority() {
        if (criticalCheckBox.isSelected()) return "CRITICAL";
        if (highCheckBox.isSelected()) return "HIGH";
        if (mediumCheckBox.isSelected()) return "MEDIUM";
        if (lowCheckBox.isSelected()) return "LOW";
        return null;
    }

    private void clearForm() {
        orderIdTextField.clear();
        descriptionAreaTextField.clear();
        airlineComboBox.getSelectionModel().clearSelection();
        categoryComboBox.getSelectionModel().clearSelection();
        lowCheckBox.setSelected(false);
        mediumCheckBox.setSelected(false);
        highCheckBox.setSelected(false);
        criticalCheckBox.setSelected(false);

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
