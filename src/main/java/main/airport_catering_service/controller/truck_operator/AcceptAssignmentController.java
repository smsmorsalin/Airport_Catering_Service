package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import nonuser.DeliveryAssignment;
import java.io.*;
import java.util.ArrayList;

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

    private Truckoperator loggedInUser;
    @FXML
    private TextField deliveryTimeField;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof Truckoperator truckoperator) {
            loggedInUser = truckoperator;
        } else {
            AlertGenerator.showAlert("Error", "This is not a valid user for this page");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadAssignment(ActionEvent actionEvent) {
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a assignment ID");
            return;
        }
        int assignmentId;

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
        File file = new File("DeliveryAssignment.bin");

        try {

            if (!file.exists()) {
                AlertGenerator.showAlert("Error", "No assignment file found.");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            boolean found = false;

            while (true) {

                try {

                    DeliveryAssignment assignment =
                            (DeliveryAssignment) ois.readObject();

                    if (assignment.getAssignmentId() == assignmentId) {

                        orderIdField.setText(String.valueOf(assignment.getOrderId()));
                        flightNumberField.setText(assignment.getFlightNumber());
                        airlineField.setText(assignment.getAirline());
                        locationField.setText(assignment.getLocation());

                        found = true;
                        break;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (found) {
                AlertGenerator.showAlert("Success",
                        "Assignment loaded successfully.");
            } else {
                AlertGenerator.showAlert("Error",
                        "Assignment not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            AlertGenerator.showAlert("Error",
                    "Unable to load assignment.");
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
    @FXML
    public void acceptAssignment(ActionEvent actionEvent) {
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter an assignment ID");
            return;
        }

        int assignmentId;

        try {
            assignmentId = Integer.parseInt(assignmentIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if (flightNumberField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Flight Number cannot be empty.");
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
        if (airlineField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Airline cannot be empty.");
            return;
        }
        if (locationField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Location cannot be empty.");
            return;
        }

        File file = new File("DeliveryAssignment.bin");
        ArrayList<DeliveryAssignment> assignmentList = new ArrayList<>();

        try {

            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

                while (true) {
                    try {
                        DeliveryAssignment assignment = (DeliveryAssignment) ois.readObject();
                        assignmentList.add(assignment);
                    } catch (EOFException e) {
                        break;
                    }
                }

                ois.close();
            }

            boolean found = false;

            for (DeliveryAssignment assignment : assignmentList) {

                if (assignment.getAssignmentId() == assignmentId) {

                    assignment.setStatus("Accepted");
                    found = true;
                    break;
                }
            }

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(file));

            for (DeliveryAssignment assignment : assignmentList) {
                oos.writeObject(assignment);
            }

            oos.close();

            if (found) {
                AlertGenerator.showAlert("Success",
                        "Assignment accepted successfully.");
            } else {
                AlertGenerator.showAlert("Error",
                        "Assignment not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            AlertGenerator.showAlert("Error",
                    "Unable to update assignment.");
        }
    }
}