package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Headchef;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class CollectShipmentController implements UserReceiver {
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

    private Truckoperator loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof Truckoperator truckoperator) {
            loggedInUser = truckoperator;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
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
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a assignment ID");
            return;
        }
        int assignmentId = Integer.parseInt(assignmentIdField.getText());
        try {
            assignmentId = Integer.parseInt(assignmentIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if (assignmentId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if (mealQuantityField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a mealQ ID");
            return;
        }
        int mealQuantity = Integer.parseInt(mealQuantityField.getText());
        try {
            mealQuantity = Integer.parseInt(mealQuantityField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid mealQ ID");
            return;
        }
        if (mealQuantity <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid mealQ ID");
            return;
        }
        if (flightNumberField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a flight ID");
            return;
        }
        int flightNumber = Integer.parseInt(flightNumberField.getText());
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
        if (orderIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a order ID");
            return;
        }
        int orderId;
        try {
            orderId = Integer.parseInt(orderIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }
        if (orderId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }
        if (airlineField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a airline ID");
            return;
        }
        int airlineId;
        try {
            airlineId = Integer.parseInt(airlineField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid airline ID");
            return;
        }
        if (airlineId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid airline ID");
            return;
        }
        if (locationField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a location ID");
            return;
        }
        int locationId;
        try {
            locationId = Integer.parseInt(locationField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if (locationId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if (collectionDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please enter a collection date");
            return;
        }
    }
}