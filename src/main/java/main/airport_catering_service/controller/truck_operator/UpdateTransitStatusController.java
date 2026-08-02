package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Truckoperator;

import java.io.IOException;

public class UpdateTransitStatusController
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