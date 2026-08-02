package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Truckoperator;

import java.io.IOException;

public class CollectShipmentController
{
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private TextField airlineField;
    @javafx.fxml.FXML
    private DatePicker collectionDatePicker;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Button loadShipmentButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private TextField flightNumberField;
    @javafx.fxml.FXML
    private TextField mealQuantityField;
    @javafx.fxml.FXML
    private Button confirmCollectionButton;
    @javafx.fxml.FXML
    private TextField assignmentIdField;
    @javafx.fxml.FXML
    private Button resetButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent);
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        assignmentIdField.clear();
        flightNumberField.clear();
        mealQuantityField.clear();
        orderIdField.clear();
        airlineField.clear();
        locationField.clear();

    }

    @javafx.fxml.FXML
    public void confirmCollection(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadShipment(ActionEvent actionEvent) {
    }
}