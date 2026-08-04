package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class emergencyDeliveryController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label emergencyDispatchIdLabel;
    @javafx.fxml.FXML
    private Text emergencyRequestIdText;
    @javafx.fxml.FXML
    private TextField emergencyRequestIdTextfield;
    @javafx.fxml.FXML
    private Label assignedTruckLabel;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TextField emergencyNotetextfield;
    @javafx.fxml.FXML
    private Text emergencyNotetext;
    @javafx.fxml.FXML
    private Label estimatedDeliveryTimelabel;

    private DispatchCoordinator loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof DispatchCoordinator dispatchCoordinator){
            loggedInUser = dispatchCoordinator;
            return;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monitorDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderMonitorDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void scheduleDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderScheduleDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void assignTruckButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderAssignTruck(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderPackageOrder(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderReceiveDispatchRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderManageDeliveryDelay(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderGenerateDispatchReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderEmergencyDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {

        if (emergencyRequestIdTextfield.getText() == null
                || emergencyRequestIdTextfield.getText().trim().isEmpty()
                || orderIdTextfield.getText() == null
                || orderIdTextfield.getText().trim().isEmpty()
                || emergencyNotetextfield.getText() == null
                || emergencyNotetextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        int emergencyRequestId, orderId;

        try {
            emergencyRequestId = Integer.parseInt(emergencyRequestIdTextfield.getText().trim());
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Emergency Request ID and Order ID must be integers.");
            return;
        }

        if (emergencyRequestId <= 0 || orderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "IDs must be greater than 0.");
            return;
        }

        String emergencyNote = emergencyNotetextfield.getText().trim();

    }
}