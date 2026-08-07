package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import nonuser.DeliveryAssignment;
import java.time.LocalDate;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class DeliveryPerformanceReportController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, Integer> assignmentIdColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, Integer> orderIdColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, String> flightNumberColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, String> airlineColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, String> destinationColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, LocalDate> deliveryTimeColumn;

    @javafx.fxml.FXML
    private TableColumn<DeliveryAssignment, String> statusColumn;

    @javafx.fxml.FXML
    private TableView<DeliveryAssignment> reportTable;

    private Truckoperator loggedInUser;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private Button exportPdfButton;
    @javafx.fxml.FXML
    private Label successfulDeliveriesLabel;
    @javafx.fxml.FXML
    private Button printButton;
    @javafx.fxml.FXML
    private Label delayedDeliveriesLabel;
    @javafx.fxml.FXML
    private Label reportedIssuesLabel;
    @javafx.fxml.FXML
    private Label totalDeliveriesLabel;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;

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

            assignmentIdColumn.setCellValueFactory(
                    new PropertyValueFactory<>("assignmentId"));

            orderIdColumn.setCellValueFactory(
                    new PropertyValueFactory<>("orderId"));

            flightNumberColumn.setCellValueFactory(
                    new PropertyValueFactory<>("flightNumber"));

            airlineColumn.setCellValueFactory(
                    new PropertyValueFactory<>("airline"));

            destinationColumn.setCellValueFactory(
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
    public void resetFilter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportPDF(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {

            if (fromDatePicker.getValue() == null ||
                    toDatePicker.getValue() == null) {

                AlertGenerator.showAlert("Error",
                        "Please select both dates.");

                return;
            }

            ObservableList<DeliveryAssignment> reportList =
                    FXCollections.observableArrayList();

            int total = 0;
            int delivered = 0;
            int delayed = 0;
            int issues = 0;

            File file = new File("DeliveryAssignment.bin");

            try {

                if (!file.exists()) {

                    AlertGenerator.showAlert("Error",
                            "No report data found.");

                    return;
                }

                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream(file));

                while (true) {

                    try {

                        DeliveryAssignment assignment =
                                (DeliveryAssignment) ois.readObject();

                        if (!assignment.getDeliveryDate().isBefore(fromDatePicker.getValue())
                                && !assignment.getDeliveryDate().isAfter(toDatePicker.getValue())) {

                            reportList.add(assignment);

                            total++;

                            if (assignment.getStatus().equals("Delivered")) {
                                delivered++;
                            }

                            if (assignment.getStatus().equals("Delayed")) {
                                delayed++;
                            }

                            if (assignment.getStatus().equals("Issue Reported")) {
                                issues++;
                            }

                        }

                    } catch (EOFException e) {

                        break;
                    }
                }

                ois.close();

                reportTable.setItems(reportList);

                totalDeliveriesLabel.setText(String.valueOf(total));
                successfulDeliveriesLabel.setText(String.valueOf(delivered));
                delayedDeliveriesLabel.setText(String.valueOf(delayed));
                reportedIssuesLabel.setText(String.valueOf(issues));

                AlertGenerator.showAlert("Success",
                        "Report generated successfully.");

            } catch (Exception e) {

                e.printStackTrace();

                AlertGenerator.showAlert("Error",
                        "Unable to generate report.");

            }

        }

    @javafx.fxml.FXML
    public void printReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshReport(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDeliveryHistoryView(actionEvent, loggedInUser);
    }
}