package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class scheduleDeliveryController implements UserReceiver
{
    @javafx.fxml.FXML
    private Text deliveryTimeText;
    @javafx.fxml.FXML
    private Text locationText;
    @javafx.fxml.FXML
    private Label deliveryDateAndTimeLabel;
    @javafx.fxml.FXML
    private Label assignedTruckLabel;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private Label flightNumberLabel;
    @javafx.fxml.FXML
    private DatePicker deliveryDateDatepicker;
    @javafx.fxml.FXML
    private Label scheduleIdLabel;
    @javafx.fxml.FXML
    private TextField componentTextfield;
    @javafx.fxml.FXML
    private TextField locationTextfield;
    @javafx.fxml.FXML
    private TextField deliveryTimeTextfield;
    @javafx.fxml.FXML
    private Text deliveryDateText;
    @javafx.fxml.FXML
    private Label orderIdLabel;
    @javafx.fxml.FXML
    private Text componentText;


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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {
    }
}