package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import nonuser.DeliveryAssignment;

import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.*;
import java.util.ArrayList;

public class ConfirmDeliveryController implements UserReceiver {
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TextField receiverIdField;
    @javafx.fxml.FXML
    private Button confirmButton;
    @javafx.fxml.FXML
    private TextField receiverNameField;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private Button resetButton;

    private Truckoperator loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof Truckoperator truckoperator) {
            loggedInUser = truckoperator;
        } else {
            AlertGenerator.showAlert("Error",
                    "This is not a valid user for this page");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadAssignment(ActionEvent actionEvent) {
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
        if (receiverIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a receiver ID");
            return;
        }
        int receiverId;
        try {
            receiverId = Integer.parseInt(receiverIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if (receiverId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid receiver ID");
            return;
        }
        if (receiverNameField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter receiver name");
            return;
        }

        if (locationField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter location");
            return;
        }
        if (deliveryDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please enter a delivery date from the delivery date field");
            return;
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        orderIdField.clear();
        receiverIdField.clear();

        receiverNameField.clear();
        orderIdField.clear();

        locationField.clear();
    }

    @javafx.fxml.FXML
    public void confirmDelivery(ActionEvent actionEvent){

            if (orderIdField.getText().isEmpty()) {

                AlertGenerator.showAlert("Error",
                        "Please enter an order ID");

                return;
            }

            int orderId;

            try {

                orderId = Integer.parseInt(orderIdField.getText());

            } catch (NumberFormatException e) {

                AlertGenerator.showAlert("Error",
                        "Please enter a valid order ID");

                return;
            }

            File file = new File("DeliveryAssignment.bin");

            ArrayList<DeliveryAssignment> assignmentList = new ArrayList<>();

            try {

                if (!file.exists()) {

                    AlertGenerator.showAlert("Error",
                            "No assignment file found.");

                    return;
                }

                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream(file));

                while (true) {

                    try {

                        DeliveryAssignment assignment =
                                (DeliveryAssignment) ois.readObject();

                        assignmentList.add(assignment);

                    } catch (EOFException e) {

                        break;
                    }
                }

                ois.close();

                boolean found = false;

                for (DeliveryAssignment assignment : assignmentList) {

                    if (assignment.getOrderId() == orderId) {

                        if (assignment.getStatus().equals("In Transit")) {

                            assignment.setStatus("Delivered");

                            found = true;

                            break;

                        } else {

                            AlertGenerator.showAlert("Error",
                                    "Cannot confirm delivery. Current status: "
                                            + assignment.getStatus());

                            return;
                        }
                    }
                }

                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream(file));

                for (DeliveryAssignment assignment : assignmentList) {

                    oos.writeObject(assignment);

                }

                oos.close();

                if (found) {

                    AlertGenerator.showAlert("Success",
                            "Delivery confirmed successfully.");

                    resetForm(null);

                } else {

                    AlertGenerator.showAlert("Error",
                            "Assignment not found.");

                }

            } catch (Exception e) {

                e.printStackTrace();

                AlertGenerator.showAlert("Error",
                        "Unable to confirm delivery.");

            }

        }
    }