package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class AcceptAssignmentController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private TextField airlineField;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private TextField flightNumberField;
    @javafx.fxml.FXML
    private TextField assignmentIdField;
    @javafx.fxml.FXML
    private Button acceptButton;
    @javafx.fxml.FXML
    private DatePicker deliverytimeDatePicker;

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
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }
        int taskId;
        try {
            taskId = Integer.parseInt(assignmentIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }
        if (taskId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }
        if (flightNumberField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a flight ID");
            return;
        }
        int flightNumber;
        try {
            flightNumber = Integer.parseInt(flightNumberField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid flight ID");
            return;
        }
        if (flightNumber <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid flight ID");
            return;
        }
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
        if(airlineField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a airline ID");
            return;
        }
        int airlineId;
        try {
            airlineId = Integer.parseInt(airlineField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid airline ID");
            return;
        }
        if(airlineId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid airline ID");
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
        if (deliverytimeDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please enter a deliverytime date");
            return;
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);

    }

    @Deprecated
    public void rejectAssignment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
        assignmentIdField.clear();
        flightNumberField.clear();
        orderIdField.clear();
        airlineField.clear();
        locationField.clear();

    }

    @javafx.fxml.FXML
    public void acceptAssignment(ActionEvent actionEvent) {
    }
}