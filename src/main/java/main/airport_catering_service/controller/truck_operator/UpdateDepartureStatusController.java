package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class UpdateDepartureStatusController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private TextField airlineField;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TextField flightNumberField;
    @javafx.fxml.FXML
    private TextField assignmentIdField;
    @javafx.fxml.FXML
    private TextField departureTimeField;
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private DatePicker departureDatePicker;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private Button updateButton;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
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
        if(assignmentIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a assignment ID");
            return;
        }
        int assignmentId;
        try {
            assignmentId = Integer.parseInt(assignmentIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if(assignmentId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
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
        if(flightNumberField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a flight ID");
            return;
        }
        int flightNumber;
        try {
            flightNumber = Integer.parseInt(flightNumberField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid flight ID");
            return;
        }
        if(flightNumber <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid flight ID");
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
        if(departureTimeField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a departure ID");
            return;
        }
        int departureTime;
        try {
            departureTime = Integer.parseInt(departureTimeField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid departure time");
            return;
        }
        if(departureTime <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid departure ID");
            return;
        }
        if (remarksTextArea.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a remarks");
            return;
        }
        if (statusComboBox.getSelectionModel().getSelectedIndex() == 0){
            AlertGenerator.showAlert("Error", "Please select a status");
            return;
        }
        if (departureDatePicker.getValue() == null){
            AlertGenerator.showAlert("Error", "Please enter a departure date");
            return;
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void updateDepartureStatus(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        assignmentIdField.clear();
        departureTimeField.clear();
        orderIdField.clear();
        flightNumberField.clear();
        remarksTextArea.clear();
        airlineField.clear();
        locationField.clear();

    }
}