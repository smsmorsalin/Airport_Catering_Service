package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import nonuser.DeliveryIssue;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReportDeliveryIssueController implements UserReceiver
{
    @FXML
    private TextField assignmentIdField;

    @FXML
    private TextField locationField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ComboBox issueTypeComboBox;

    @FXML
    private DatePicker issueDatePicker;

    @FXML
    private TableColumn<DeliveryIssue, Integer> issueIdColumn;

    @FXML
    private TableColumn<DeliveryIssue, Integer> assignmentIdColumn;

    @FXML
    private TableColumn<DeliveryIssue, String> issueTypeColumn;

    @FXML
    private TableColumn<DeliveryIssue, String> severityColumn;

    @FXML
    private TableColumn<DeliveryIssue, String> locationColumn;

    @FXML
    private TableColumn<DeliveryIssue, LocalDate> reportedTimeColumn;

    @FXML
    private TableColumn<DeliveryIssue, String> statusColumn;

    @FXML
    private TableView issueTable;

    @FXML
    private ComboBox severityComboBox;

    private Truckoperator loggedInUser;

    @FXML
    private Button submitButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button clearButton;

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
                    "This is not a valid user for this page"
            );

        }
    }


    @FXML
    public void initialize() {

        issueTypeComboBox.getItems().addAll(
                "Vehicle Problem",
                "Delay",
                "Food Damage",
                "Other"
        );

        severityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High"
        );

        issueIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("issueId")
        );

        assignmentIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("assignmentId")
        );

        issueTypeColumn.setCellValueFactory(
                new PropertyValueFactory<>("issueType")
        );

        severityColumn.setCellValueFactory(
                new PropertyValueFactory<>("severity")
        );

        locationColumn.setCellValueFactory(
                new PropertyValueFactory<>("location")
        );

        reportedTimeColumn.setCellValueFactory(
                new PropertyValueFactory<>("issueDate")
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        loadIssueReports();
    }


    @FXML
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

            assignmentId =
                    Integer.parseInt(
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

        File file = new File("DeliveryAssignment.bin");

        if (!file.exists()) {

            AlertGenerator.showAlert(
                    "Error",
                    "No delivery assignment data found."
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

                    nonuser.DeliveryAssignment assignment =
                            (nonuser.DeliveryAssignment)
                                    ois.readObject();

                    if (assignment.getAssignmentId() == assignmentId) {

                        AlertGenerator.showAlert(
                                "Success",
                                "Delivery assignment found."
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
                    "Delivery assignment not found."
            );

        } catch (Exception e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Unable to load delivery assignment."
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
    public void submitIssueReport(ActionEvent actionEvent) {

        if (assignmentIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter an assignment ID"
            );

            return;
        }

        int assignmentId;

        try {

            assignmentId =
                    Integer.parseInt(
                            assignmentIdField.getText()
                    );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Invalid assignment ID"
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

        if (issueTypeComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select an issue type"
            );

            return;
        }

        if (severityComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a severity"
            );

            return;
        }

        if (locationField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a location"
            );

            return;
        }

        if (issueDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select the issue date"
            );

            return;
        }

        if (descriptionTextArea.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a description"
            );

            return;
        }


        File file = new File("DeliveryIssue.bin");

        ArrayList<DeliveryIssue> issueList =
                new ArrayList<>();

        try {

            if (file.exists()) {

                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream(file)
                        );

                while (true) {

                    try {

                        DeliveryIssue issue =
                                (DeliveryIssue)
                                        ois.readObject();

                        issueList.add(issue);

                    } catch (EOFException e) {

                        break;
                    }
                }

                ois.close();
            }


            int issueId =
                    issueList.size() + 1;


            DeliveryIssue issue =
                    new DeliveryIssue(
                            issueId,
                            assignmentId,
                            issueTypeComboBox.getValue().toString(),
                            severityComboBox.getValue().toString(),
                            locationField.getText(),
                            issueDatePicker.getValue(),
                            descriptionTextArea.getText(),
                            "Reported"
                    );


            issueList.add(issue);


            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(file)
                    );


            for (DeliveryIssue i : issueList) {

                oos.writeObject(i);

            }


            oos.close();


            AlertGenerator.showAlert(
                    "Success",
                    "Issue reported successfully."
            );


            clearForm(null);

            loadIssueReports();

        } catch (Exception e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Unable to save issue report."
            );
        }
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) {

        loadIssueReports();

        AlertGenerator.showAlert(
                "Success",
                "Issue reports refreshed."
        );
    }


    private void loadIssueReports() {

        ObservableList<DeliveryIssue> issueList =
                FXCollections.observableArrayList();

        File file =
                new File("DeliveryIssue.bin");


        if (!file.exists()) {

            issueTable.setItems(issueList);

            return;
        }


        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(file)
                    );


            while (true) {

                try {

                    DeliveryIssue issue =
                            (DeliveryIssue)
                                    ois.readObject();

                    issueList.add(issue);

                } catch (EOFException e) {

                    break;
                }
            }


            ois.close();


            issueTable.setItems(issueList);

        } catch (Exception e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Unable to load issue reports."
            );
        }
    }


    @FXML
    public void clearForm(ActionEvent actionEvent) {

        assignmentIdField.clear();

        locationField.clear();

        descriptionTextArea.clear();

        issueTypeComboBox
                .getSelectionModel()
                .clearSelection();

        severityComboBox
                .getSelectionModel()
                .clearSelection();

        issueDatePicker.setValue(null);
    }
}