package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.DeliveryAssignment;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.*;
import java.util.ArrayList;

public class UpdateDepartureStatusController implements UserReceiver {

    @FXML
    private Button loadButton;

    @FXML
    private TextField assignmentIdField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker departureDatePicker;

    @FXML
    private Button backButton;

    @FXML
    private Button updateButton;

    @FXML
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


    @FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "Departed",
                "Delayed",
                "Cancelled"
        );

    }


    @FXML
    public void loadAssignment(ActionEvent actionEvent) {

        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert("Error",
                    "Please enter assignment ID");

            return;
        }

        try {

            Integer.parseInt(assignmentIdField.getText());

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert("Error",
                    "Invalid assignment ID");
            return;

        }

    }


    @FXML
    public void updateDepartureStatus(ActionEvent actionEvent) {


        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert("Error",
                    "Please enter assignment ID");

            return;
        }


        int assignmentId;


        try {

            assignmentId =
                    Integer.parseInt(assignmentIdField.getText());

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert("Error",
                    "Invalid assignment ID");

            return;
        }


        if (departureDatePicker.getValue() == null) {

            AlertGenerator.showAlert("Error",
                    "Please select departure date");

            return;
        }


        if (statusComboBox.getValue() == null) {

            AlertGenerator.showAlert("Error",
                    "Please select status");

            return;
        }



        File file = new File("DeliveryAssignment.bin");

        ArrayList<DeliveryAssignment> assignmentList =
                new ArrayList<>();


        try {


            if (!file.exists()) {

                AlertGenerator.showAlert("Error",
                        "No assignment file found");

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



            boolean updated = false;



            for (DeliveryAssignment assignment : assignmentList) {


                if (assignment.getAssignmentId() == assignmentId) {

                    assignment.setStatus(
                            statusComboBox.getValue()
                    );

                    assignment.setDeliveryDate(
                            departureDatePicker.getValue()
                    );

                    updated = true;

                    break;
                }
            }



            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(file));



            for (DeliveryAssignment assignment : assignmentList) {

                oos.writeObject(assignment);

            }


            oos.close();



            if (updated) {


                AlertGenerator.showAlert(
                        "Success",
                        "Departure status updated successfully."
                );


                resetForm(null);


            } else {


                AlertGenerator.showAlert(
                        "Error",
                        "Assignment not found."
                );

            }


        } catch (Exception e) {


            e.printStackTrace();


            AlertGenerator.showAlert(
                    "Error",
                    "Unable to update departure status."
            );

        }

    }



    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Truckoperator.renderDashboardView(
                actionEvent,
                loggedInUser
        );

    }



    @FXML
    public void resetForm(ActionEvent actionEvent) {

        assignmentIdField.clear();
        departureDatePicker.setValue(null);
        statusComboBox.setValue(null);

    }

}