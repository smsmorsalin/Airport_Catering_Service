package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class UpdateTransitStatusController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField updateTimeField;
    @javafx.fxml.FXML
    private TextField airlineField;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField flightNumberField;
    @javafx.fxml.FXML
    private TextField assignmentIdField;
    @javafx.fxml.FXML
    private TextField currentLocationField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private ComboBox transitStatusComboBox;
    @javafx.fxml.FXML
    private Button updateTransitButton;
    @javafx.fxml.FXML
    private Button resetButton;
    @javafx.fxml.FXML
    private TextField destinationField;

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
        if(currentLocationField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a current location ID");
            return;
        }
        int currentLocationId;
        try {
            currentLocationId = Integer.parseInt(currentLocationField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid current location ID");
            return;
        }
        if(currentLocationId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid current location ID");
            return;
        }
        if(destinationField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a destination ID");
            return;
        }
        int destinationId;
        try {
            destinationId = Integer.parseInt(destinationField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid destination ID");
            return;
        }
        if(destinationId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid destination ID");
            return;
        }
        if (remarksTextArea.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a remarks text");
            return;
        }
        if (transitStatusComboBox.getSelectionModel().getSelectedIndex() == 0){
            AlertGenerator.showAlert("Error", "Please select a transit status");
            return;
        }

    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void updateTransitStatus(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        assignmentIdField.clear();
        currentLocationField.clear();
        flightNumberField.clear();
        destinationField.clear();
        remarksTextArea.clear();
        airlineField.clear();
        updateTimeField.clear();
    }
}