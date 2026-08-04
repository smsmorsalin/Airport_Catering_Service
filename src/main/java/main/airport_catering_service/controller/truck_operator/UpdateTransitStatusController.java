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