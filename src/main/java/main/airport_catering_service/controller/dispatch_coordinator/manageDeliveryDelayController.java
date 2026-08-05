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

public class manageDeliveryDelayController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label revisedDeliveryTimeLabel;
    @javafx.fxml.FXML
    private TextField deliveryIdTextfield;
    @javafx.fxml.FXML
    private Label delayReasonLabel;
    @javafx.fxml.FXML
    private TextField delayReasonTextfield;
    @javafx.fxml.FXML
    private Text revisedDeliveryTimeText;
    @javafx.fxml.FXML
    private Label deliveryIdLabel;
    @javafx.fxml.FXML
    private Text deliveryIdText;
    @javafx.fxml.FXML
    private Text delayReasonText;
    @javafx.fxml.FXML
    private TextField revisedDeliveryTimeTextfield;

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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {

        if ( deliveryIdTextfield.getText().trim().isEmpty()
                || delayReasonTextfield.getText().trim().isEmpty() || revisedDeliveryTimeTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        int deliveryId;

        try {
            deliveryId = Integer.parseInt(deliveryIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Delivery ID must be an integer.");
            return;
        }

        if (deliveryId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Delivery ID must be greater than 0.");
            return;
        }

        String delayReason = delayReasonTextfield.getText().trim();
        String revisedDeliveryTime = revisedDeliveryTimeTextfield.getText().trim();

    }
}