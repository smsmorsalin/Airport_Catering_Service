package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class scheduleDeliveryController implements UserReceiver
{
    @javafx.fxml.FXML
    private Text deliveryTimeText;
    @javafx.fxml.FXML
    private Text locationText;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private DatePicker deliveryDateDatepicker;
    @javafx.fxml.FXML
    private TextField locationTextfield;
    @javafx.fxml.FXML
    private TextField deliveryTimeTextfield;
    @javafx.fxml.FXML
    private Text deliveryDateText;


    private DispatchCoordinator loggedInUser;
    @javafx.fxml.FXML
    private TableColumn assignedTruckTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn flightNumberTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn scheduleIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn deliveryDateTableviewColumn;

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

        tableView.getItems().clear();

        if (orderIdTextfield.getText().trim().isEmpty() || locationTextfield.getText().trim().isEmpty()
                || deliveryTimeTextfield.getText().trim().isEmpty() || deliveryDateDatepicker.getValue() == null) {

            AlertGenerator.showAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        int orderId;

        try {
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be an integer.");
            return;
        }

        if (orderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be greater than 0.");
            return;
        }

        String location = locationTextfield.getText().trim();
        String deliveryTime = deliveryTimeTextfield.getText().trim();


        LocalDate deliveryDate = deliveryDateDatepicker.getValue();

    }
}