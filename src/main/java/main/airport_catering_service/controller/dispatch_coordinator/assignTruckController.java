package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;


public class assignTruckController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn driverIdTableviewColumn;
    @javafx.fxml.FXML
    private Text driverSelectionText;
    @javafx.fxml.FXML
    private Label assignmentIdLabel;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private Label flightNumberLabel;
    @javafx.fxml.FXML
    private TextField driverSelectionTextfield;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private Text truckSelectionText;
    @javafx.fxml.FXML
    private Label driverNameLabel;
    @javafx.fxml.FXML
    private TableColumn truckIdTableviewColumn;
    @javafx.fxml.FXML
    private Label deliveryscheduleLabel;
    @javafx.fxml.FXML
    private TextField truckSelectionTextfield;
    @javafx.fxml.FXML
    private TableColumn driverNameTableviewColumn;
    @javafx.fxml.FXML
    private Label truckIdLabel;
    @javafx.fxml.FXML
    private TableColumn truckNumberTableviewColumn;

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

        tableView.getItems().clear();

        if (orderIdTextfield.getText() == null || orderIdTextfield.getText().trim().isEmpty()
                || driverSelectionTextfield.getText() == null || driverSelectionTextfield.getText().trim().isEmpty()
                || truckSelectionTextfield.getText() == null || truckSelectionTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "All text fields must be filled.");
            return;
        }

        int orderId, driverId, truckId;

        try {
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
            driverId = Integer.parseInt(driverSelectionTextfield.getText().trim());
            truckId = Integer.parseInt(truckSelectionTextfield.getText().trim());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID, Driver ID, and Truck ID must be integers.");
            return;
        }

        if (orderId <= 0 || driverId <= 0 || truckId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "IDs must be greater than 0.");
            return;
        }



    }
}