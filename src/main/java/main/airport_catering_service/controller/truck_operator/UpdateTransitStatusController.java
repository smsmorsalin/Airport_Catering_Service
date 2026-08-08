package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nonuser.DeliveryAssignment;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.*;
import java.util.ArrayList;

public class UpdateTransitStatusController implements UserReceiver {

    @javafx.fxml.FXML
    private TextField updateTimeField;

    @javafx.fxml.FXML
    private Button loadButton;

    @javafx.fxml.FXML
    private Button backButton;

    @javafx.fxml.FXML
    private TextField assignmentIdField;

    @javafx.fxml.FXML
    private TextField currentLocationField;

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
    public void setLoggedInUser(User user) {

        if (user instanceof Truckoperator truckoperator) {

            loggedInUser = truckoperator;

        } else {

            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page"
            );

        }

    }


    @javafx.fxml.FXML
    public void initialize() {

        transitStatusComboBox.getItems().addAll(
                "In Transit",
                "Delivered"
        );

    }


    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Truckoperator.renderDashboardView(
                actionEvent,
                loggedInUser
        );

    }


    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {

        assignmentIdField.clear();
        currentLocationField.clear();
        destinationField.clear();
        updateTimeField.clear();

        transitStatusComboBox
                .getSelectionModel()
                .clearSelection();

    }


    @javafx.fxml.FXML
    public void loadAssignment(ActionEvent actionEvent) {

        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter an assignment ID"
            );

            return;
        }


        int assignmentId;

        try {

            assignmentId = Integer.parseInt(
                    assignmentIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid assignment ID"
            );

            return;
        }


        if (assignmentId <= 0) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid assignment ID"
            );

            return;
        }


        File file =
                new File("DeliveryAssignment.bin");


        if (!file.exists()) {

            AlertGenerator.showAlert(
                    "Error",
                    "No assignment file found."
            );

            return;
        }


        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(file)
                    );


            while (true) {

                try {

                    DeliveryAssignment assignment =
                            (DeliveryAssignment)
                                    ois.readObject();


                    if (assignment.getAssignmentId()
                            == assignmentId) {

                        currentLocationField.setText(
                                assignment.getLocation()
                        );

                        destinationField.setText(
                                assignment.getLocation()
                        );

                        AlertGenerator.showAlert(
                                "Success",
                                "Assignment loaded successfully."
                        );

                        ois.close();

                        return;
                    }

                } catch (EOFException e) {

                    break;
                }
            }


            ois.close();


            AlertGenerator.showAlert(
                    "Error",
                    "Assignment not found."
            );

        } catch (Exception e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Unable to load assignment."
            );

        }

    }


    @javafx.fxml.FXML
    public void updateTransitStatus(ActionEvent actionEvent) {

        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter an assignment ID"
            );

            return;
        }


        int assignmentId;


        try {

            assignmentId = Integer.parseInt(
                    assignmentIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid assignment ID"
            );

            return;
        }


        if (transitStatusComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a transit status"
            );

            return;
        }


        File file =
                new File("DeliveryAssignment.bin");


        ArrayList<DeliveryAssignment> assignmentList =
                new ArrayList<>();


        try {

            if (!file.exists()) {

                AlertGenerator.showAlert(
                        "Error",
                        "No assignment file found."
                );

                return;
            }


            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(file)
                    );


            while (true) {

                try {

                    DeliveryAssignment assignment =
                            (DeliveryAssignment)
                                    ois.readObject();

                    assignmentList.add(assignment);

                } catch (EOFException e) {

                    break;
                }
            }


            ois.close();


            boolean found = false;


            for (DeliveryAssignment assignment :
                    assignmentList) {

                if (assignment.getAssignmentId()
                        == assignmentId) {

                    if (assignment.getStatus()
                            .equals("Collected")
                            || assignment.getStatus()
                            .equals("In Transit")) {

                        assignment.setStatus(
                                transitStatusComboBox
                                        .getValue()
                                        .toString()
                        );

                        found = true;

                        break;

                    } else {

                        AlertGenerator.showAlert(
                                "Error",
                                "Cannot update transit status. Current status: "
                                        + assignment.getStatus()
                        );

                        return;
                    }
                }
            }


            if (!found) {

                AlertGenerator.showAlert(
                        "Error",
                        "Assignment not found."
                );

                return;
            }


            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(file)
                    );


            for (DeliveryAssignment assignment :
                    assignmentList) {

                oos.writeObject(assignment);
            }


            oos.close();


            AlertGenerator.showAlert(
                    "Success",
                    "Transit status updated successfully."
            );


            resetForm(null);


        } catch (Exception e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Unable to update transit status."
            );

        }

    }

}