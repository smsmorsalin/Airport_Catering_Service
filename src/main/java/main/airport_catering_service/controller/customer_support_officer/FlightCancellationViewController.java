package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import nonuser.CateringOrder;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class FlightCancellationViewController implements UserReceiver
{
    private static final String AIRLINE_FILE = "Airline.bin";
    private static final String CATERING_ORDER_FILE = "CateringOrder.bin";

    @javafx.fxml.FXML
    private Button cancelFlightBtn;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private TextArea notesTextField;
    @javafx.fxml.FXML
    private ComboBox <String> cancellationreasonComboBox;
    @javafx.fxml.FXML
    private ComboBox <String > airlinenameComboBox;

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
        cancellationreasonComboBox.getItems().setAll(
                "Flight cancelled by airline",
                "Operational issue",
                "Weather disruption",
                "Schedule change",
                "Other");

        for (Object object : BinaryFileUtility.readObjects(AIRLINE_FILE)) {
            if (object instanceof Airline airline) {
                airlinenameComboBox.getItems().add(
                        airline.getAirlineId() + " - " + airline.getAirlineName());
            }
        }
    }

    @javafx.fxml.FXML
    public void CancelFlightOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String orderIdText = orderidTextField.getText().trim();
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
        if (notesTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Additional notes should be filled");
            return;
        }

        if (airlinenameComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Airline should be selected");
            return;
        }
        if (cancellationreasonComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Cancellation reason should be selected");
            return;
        }

        ArrayList<Object> orders = BinaryFileUtility.readObjects(CATERING_ORDER_FILE);
        CateringOrder selectedOrder = null;
        for (Object object : orders) {
            if (object instanceof CateringOrder order && order.getOrderId() == orderId) {
                selectedOrder = order;
                break;
            }
        }

        if (selectedOrder == null) {
            AlertGenerator.showAlert("Order Not Found", "No catering order was found with ID " + orderId);
            return;
        }

        String selectedAirlineId = airlinenameComboBox.getValue().split(" - ", 2)[0];
        if (!selectedOrder.getAirlineId().equals(selectedAirlineId)) {
            AlertGenerator.showAlert("Invalid Airline", "The selected airline does not own this order");
            return;
        }
        if ("Cancelled".equalsIgnoreCase(selectedOrder.getStatus())) {
            AlertGenerator.showAlert("Already Cancelled", "This order has already been cancelled");
            return;
        }

        selectedOrder.setStatus("Cancelled");
        selectedOrder.setOrderAcceptOrRejectBy(
                "Customer Support Officer " + loggedInUser.getEmployeeId());

        if (!BinaryFileUtility.overwriteObjects(CATERING_ORDER_FILE, orders)) {
            AlertGenerator.showAlert("Error", "The cancellation could not be saved");
            return;
        }

        AlertGenerator.showAlert("Success", "Flight order cancelled successfully");
        orderidTextField.clear();
        notesTextField.clear();
        airlinenameComboBox.getSelectionModel().clearSelection();
        cancellationreasonComboBox.getSelectionModel().clearSelection();
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
