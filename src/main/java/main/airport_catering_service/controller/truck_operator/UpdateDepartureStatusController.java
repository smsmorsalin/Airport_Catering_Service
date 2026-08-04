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