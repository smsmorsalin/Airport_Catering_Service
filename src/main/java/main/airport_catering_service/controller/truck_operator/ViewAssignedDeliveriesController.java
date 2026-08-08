package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import nonuser.DeliveryAssignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.time.LocalDate;

public class ViewAssignedDeliveriesController implements UserReceiver
{
    @FXML
    private TableColumn<DeliveryAssignment, Integer> assignmentIdColumn;

    @FXML
    private TableColumn<DeliveryAssignment, Integer> orderIdColumn;

    @FXML
    private TableColumn<DeliveryAssignment, String> flightNumberColumn;

    @FXML
    private TableColumn<DeliveryAssignment, String> airlineColumn;

    @FXML
    private TableColumn<DeliveryAssignment, String> locationColumn;

    @FXML
    private TableColumn<DeliveryAssignment, String> statusColumn;

    @FXML
    private TableColumn<DeliveryAssignment, LocalDate> deliveryTimeColumn;

    @FXML
    private TableView<DeliveryAssignment> deliveryTable;

    @FXML
    private TextField assignmentIdField;

    private Truckoperator loggedInUser;
    @FXML
    private Button searchButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button backButton;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof Truckoperator truckoperator) {

            loggedInUser = truckoperator;

        } else {

            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {

            assignmentIdColumn.setCellValueFactory(
                    new PropertyValueFactory<>("assignmentId"));

            orderIdColumn.setCellValueFactory(
                    new PropertyValueFactory<>("orderId"));

            flightNumberColumn.setCellValueFactory(
                    new PropertyValueFactory<>("flightNumber"));

            airlineColumn.setCellValueFactory(
                    new PropertyValueFactory<>("airline"));

            locationColumn.setCellValueFactory(
                    new PropertyValueFactory<>("location"));

            deliveryTimeColumn.setCellValueFactory(
                    new PropertyValueFactory<>("deliveryDate"));

            statusColumn.setCellValueFactory(
                    new PropertyValueFactory<>("status"));
        }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @Deprecated
    public void clearSearch(ActionEvent actionEvent) {
        assignmentIdField.clear();
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderAssignmentDeliveryTasksView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchDeliveries(ActionEvent actionEvent) {
        if (assignmentIdField.getText().isEmpty()) {
            AlertGenerator.showAlert(
                    "Error",
                    "Please enter assignment ID");
            return;
        }
            int assignmentId;

            try {

                assignmentId = Integer.parseInt(
                        assignmentIdField.getText());

            } catch (NumberFormatException e) {

                AlertGenerator.showAlert(
                        "Error",
                        "Invalid assignment ID");

                return;
            }


            ObservableList<DeliveryAssignment> list =
                    FXCollections.observableArrayList();


            File file = new File("DeliveryAssignment.bin");
        if(!file.exists()){
            AlertGenerator.showAlert(
                    "Error",
                    "No delivery assignments found.");
            return;
        }


            try {

                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream(file));


                while(true){

                    try {

                        DeliveryAssignment assignment =
                                (DeliveryAssignment) ois.readObject();


                        if(assignment.getAssignmentId()==assignmentId){

                            list.add(assignment);

                        }


                    }catch(EOFException e){

                        break;
                    }
                }


                ois.close();


                deliveryTable.setItems(list);


                if(list.isEmpty()){

                    AlertGenerator.showAlert(
                            "Error",
                            "Assignment not found");

                }


            }catch(Exception e){

                AlertGenerator.showAlert(
                        "Error",
                        "Unable to load deliveries");

            }
        }
}