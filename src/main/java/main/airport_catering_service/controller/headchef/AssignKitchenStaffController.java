package main.airport_catering_service.controller.headchef;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.KitchenStaffAssignment;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class AssignKitchenStaffController implements UserReceiver {

    @FXML
    private ComboBox<String> workStationComboBox;

    @FXML
    private TableColumn<KitchenStaffAssignment, Integer> assignmentIdColumn;

    @FXML
    private TableColumn<KitchenStaffAssignment, String> staffNameColumn;

    @FXML
    private TableColumn<KitchenStaffAssignment, String> stationColumn;

    @FXML
    private Button assignButton;

    @FXML
    private TableColumn<KitchenStaffAssignment, String> shiftColumn;

    @FXML
    private ComboBox<String> shiftComboBox;

    @FXML
    private TableColumn<KitchenStaffAssignment, Integer> taskIdColumn;

    @FXML
    private Button clearButton;

    @FXML
    private TableColumn<KitchenStaffAssignment, String> assignedTaskColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn<KitchenStaffAssignment, String> statusColumn;

    @FXML
    private TableView<KitchenStaffAssignment> assignmentTable;

    @FXML
    private ComboBox<String> staffComboBox;

    @FXML
    private Button backButton;

    @FXML
    private TextField taskIdField;


    private Headchef loggedInUser;

    private final ObservableList<KitchenStaffAssignment> assignments =
            FXCollections.observableArrayList();

    private int nextAssignmentId = 1;


    @Override
    public void setLoggedInUser(User user) {

        if (user instanceof Headchef headchef) {
            loggedInUser = headchef;
        } else {
            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page"
            );
        }
    }


    @FXML
    public void initialize() {

        staffComboBox.getItems().addAll(
                "Kitchen Staff 1",
                "Kitchen Staff 2",
                "Kitchen Staff 3"
        );

        shiftComboBox.getItems().addAll(
                "Morning",
                "Afternoon",
                "Night"
        );

        workStationComboBox.getItems().addAll(
                "Preparation",
                "Cooking",
                "Packaging"
        );


        assignmentIdColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(
                        cellData.getValue().getAssignmentId()
                ).asObject()
        );

        staffNameColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getStaffName()
                )
        );

        stationColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getStation()
                )
        );

        shiftColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getShift()
                )
        );

        taskIdColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(
                        cellData.getValue().getTaskId()
                ).asObject()
        );

        assignedTaskColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getAssignedTask()
                )
        );

        statusColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getStatus()
                )
        );


        assignmentTable.setItems(assignments);
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void clearForm(ActionEvent actionEvent) {

        taskIdField.clear();

        staffComboBox.getSelectionModel()
                .clearSelection();

        shiftComboBox.getSelectionModel()
                .clearSelection();

        workStationComboBox.getSelectionModel()
                .clearSelection();
    }


    @FXML
    public void assignKitchenStaff(ActionEvent actionEvent) {

        if (taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        int taskId;

        try {

            taskId = Integer.parseInt(
                    taskIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid task ID"
            );

            return;
        }


        if (taskId <= 0) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid task ID"
            );

            return;
        }


        if (staffComboBox.getSelectionModel()
                .getSelectedItem() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a Staff"
            );

            return;
        }


        if (shiftComboBox.getSelectionModel()
                .getSelectedItem() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a Shift"
            );

            return;
        }


        if (workStationComboBox.getSelectionModel()
                .getSelectedItem() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a Work Station"
            );

            return;
        }


        String staffName =
                staffComboBox.getSelectionModel()
                        .getSelectedItem();

        String shift =
                shiftComboBox.getSelectionModel()
                        .getSelectedItem();

        String station =
                workStationComboBox.getSelectionModel()
                        .getSelectedItem();


        KitchenStaffAssignment assignment =
                new KitchenStaffAssignment(
                        nextAssignmentId++,
                        staffName,
                        station,
                        shift,
                        taskId,
                        "Production Task " + taskId,
                        "Assigned"
                );


        assignments.add(assignment);

        assignmentTable.refresh();


        AlertGenerator.showAlert(
                "Success",
                "Kitchen staff assigned successfully"
        );


        clearForm(actionEvent);
    }


    @FXML
    public void refreshAssignments(ActionEvent actionEvent) {
        assignments.clear();
        assignmentTable.refresh();

        AlertGenerator.showAlert(
                "Success",
                "All kitchen staff assignments have been cleared"
        );
    }
}