package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nonuser.CateringOrder;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class FlightDelayRequestViewController implements UserReceiver
{
    private static final String CATERING_ORDER_FILE = "CateringOrder.bin";

    @javafx.fxml.FXML
    private Button updateScheduleBtn;
    @javafx.fxml.FXML
    private TextField newTimeTextField;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private TextArea delayReasonTextField;
    @javafx.fxml.FXML
    private TextField previousTimeTextField;

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
    }

    @javafx.fxml.FXML
    public void UpdateScheduleOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String orderIdText = orderidTextField.getText().trim();
        String previousTimeText = previousTimeTextField.getText().trim();
        String newTimeText = newTimeTextField.getText().trim();
        String reason = delayReasonTextField.getText().trim();

        if (orderIdText.isEmpty() || previousTimeText.isEmpty()
                || newTimeText.isEmpty() || reason.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "All fields should be filled");
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

        LocalTime previousTime;
        LocalTime newTime;
        try {
            previousTime = LocalTime.parse(previousTimeText);
            newTime = LocalTime.parse(newTimeText);
        } catch (DateTimeParseException e) {
            AlertGenerator.showAlert(
                    "Wrong Input", "Time must use 24-hour format, for example 14:30");
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
        if ("Cancelled".equalsIgnoreCase(selectedOrder.getStatus())) {
            AlertGenerator.showAlert("Invalid Request", "A cancelled order cannot be delayed");
            return;
        }
        if ("Delivered".equalsIgnoreCase(selectedOrder.getStatus())) {
            AlertGenerator.showAlert("Invalid Request", "A delivered order cannot be delayed");
            return;
        }
        if (selectedOrder.getDeliveryTime() == null
                || !selectedOrder.getDeliveryTime().equals(previousTime)) {
            AlertGenerator.showAlert(
                    "Invalid Previous Time",
                    "Previous departure time does not match the order's current schedule");
            return;
        }
        if (!newTime.isAfter(previousTime)) {
            AlertGenerator.showAlert(
                    "Invalid New Time", "New departure time must be later than the previous time");
            return;
        }

        selectedOrder.setDeliveryTime(newTime);
        selectedOrder.setDelay(true);
        selectedOrder.setOrderAcceptOrRejectBy(
                "Customer Support Officer " + loggedInUser.getEmployeeId());

        if (!BinaryFileUtility.overwriteObjects(CATERING_ORDER_FILE, orders)) {
            AlertGenerator.showAlert("Error", "The delay request could not be saved");
            return;
        }

        AlertGenerator.showAlert("Success", "Flight delay request submitted successfully");
        orderidTextField.clear();
        previousTimeTextField.clear();
        newTimeTextField.clear();
        delayReasonTextField.clear();
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
