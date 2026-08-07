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
import nonuser.DeliveryAssignment;

import java.io.*;
import java.util.ArrayList;

public class CollectShipmentController implements UserReceiver {
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Button loadShipmentButton;
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
        } else {
            AlertGenerator.showAlert("Error",
                    "This is not a valid user for this page");
        }
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

    }
    @javafx.fxml.FXML
    public void confirmCollection(ActionEvent actionEvent) {

        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert("Error",
                    "Please enter an assignment ID");

            return;
        }


        int assignmentId;

        try {

            assignmentId = Integer.parseInt(
                    assignmentIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert("Error",
                    "Please enter a valid assignment ID");

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



            // READ OBJECTS FROM FILE

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



            // UPDATE OBJECT

            for (DeliveryAssignment assignment : assignmentList) {


                if (assignment.getAssignmentId() == assignmentId) {


                    if (assignment.getStatus().equals("Accepted")) {


                        assignment.setStatus("Collected");

                        found = true;

                        break;


                    } else {


                        AlertGenerator.showAlert("Error",
                                "Cannot collect shipment. Current status: "
                                        + assignment.getStatus());

                        return;
                    }
                }
            }




            // WRITE OBJECTS BACK TO FILE

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(file));


            for (DeliveryAssignment assignment : assignmentList) {

                oos.writeObject(assignment);

            }


            oos.close();




            if (found) {

                AlertGenerator.showAlert("Success",
                        "Shipment collected successfully.");

                assignmentIdField.clear();

            } else {

                AlertGenerator.showAlert("Error",
                        "Assignment not found.");

            }



        } catch (Exception e) {

            e.printStackTrace();

            AlertGenerator.showAlert("Error",
                    "Unable to update shipment.");

        }

    }

    @javafx.fxml.FXML
    public void loadShipment(ActionEvent actionEvent) {
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a assignment ID");
            return;
        }
        int assignmentId;

        try {
            assignmentId = Integer.parseInt(assignmentIdField.getText());

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert("Error",
                    "Please enter a valid assignment ID");

            return;
        }
    }
}