package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import user.Truckoperator;

import java.io.IOException;

public class AcceptAssignmentController
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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadAssignment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent);

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