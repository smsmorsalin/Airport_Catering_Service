package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ConfirmDeliveryController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TextField flightNumberField;
    @javafx.fxml.FXML
    private TextField receiverIdField;
    @javafx.fxml.FXML
    private Button confirmButton;
    @javafx.fxml.FXML
    private TextField receiverNameField;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private Button resetButton;

    private Truckoperator loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof Truckoperator truckoperator){
            loggedInUser = truckoperator;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadAssignment(ActionEvent actionEvent) {
        if(orderIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a order ID");
            return;
        }
        int orderId;
        try {
            orderId = Integer.parseInt(orderIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }
        if(orderId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }
        if(receiverIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a receiver ID");
            return;
        }
        int receiverId;
        try {
            receiverId = Integer.parseInt(receiverIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if(receiverId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if(receiverNameField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }
        int receiverNameId;
        try {
            receiverNameId = Integer.parseInt(receiverNameField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if(receiverNameId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if(locationField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a location ID");
            return;
        }
        int locationId;
        try {
            locationId = Integer.parseInt(locationField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if(locationId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if ( deliveryDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please enter a delivery date from the delivery date field");
            return;
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        orderIdField.clear();
        receiverIdField.clear();
        flightNumberField.clear();
        receiverNameField.clear();
        orderIdField.clear();
        flightNumberField.clear();
        locationField.clear();
    }

    @javafx.fxml.FXML
    public void confirmDelivery(ActionEvent actionEvent) {
    }
}