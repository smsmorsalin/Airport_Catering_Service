package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class RequestQualityInspectionController implements UserReceiver {

    @FXML
    private TableColumn mealCategoryColumn;

    @FXML
    private Button submitButton;

    @FXML
    private TableColumn remarksColumn;

    @FXML
    private TableColumn requestDateColumn;

    @FXML
    private Button loadTaskButton;

    @FXML
    private TableView inspectionTable;

    @FXML
    private ComboBox<String> priorityComboBox;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private TableColumn priorityColumn;

    @FXML
    private TableColumn inspectionStatusColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private DatePicker inspectionDatePicker;

    @FXML
    private Button backButton;

    @FXML
    private TextField mealCategoryField;

    @FXML
    private TextArea remarksTextArea;

    @FXML
    private TextField taskIdField;

    @FXML
    private Button resetButton;

    @FXML
    private TableColumn requestIdColumn;


    private Headchef loggedInUser;


    @Override
    public void setLoggedInUser(User user) {

        if (user instanceof Headchef headchef) {
            loggedInUser = headchef;
        }
        else {
            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page"
            );
        }
    }


    @FXML
    public void initialize() {

        priorityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Urgent"
        );
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {

        Headchef.renderDisplayUpdateConfirmation(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void resetForm(ActionEvent actionEvent) {

        taskIdField.clear();
        mealCategoryField.clear();
        remarksTextArea.clear();

        priorityComboBox.getSelectionModel()
                .clearSelection();

        inspectionDatePicker.setValue(null);
    }


    @FXML
    public void submitInspectionRequest(ActionEvent actionEvent) {

        if(taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        if(priorityComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select inspection priority"
            );

            return;
        }


        if(inspectionDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select inspection date"
            );

            return;
        }


        if(remarksTextArea.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter remarks"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Quality inspection request submitted"
        );
    }


    @FXML
    public void loadTask(ActionEvent actionEvent) {

        if(taskIdField.getText().isEmpty()) {

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


        if(taskId <= 0) {

            AlertGenerator.showAlert(
                    "Error",
                    "Task ID must be greater than zero"
            );

            return;
        }


        if(inspectionDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select an inspection date"
            );

            return;
        }


        if(inspectionDatePicker.getValue()
                .isBefore(LocalDate.now())) {

            AlertGenerator.showAlert(
                    "Error",
                    "Inspection date cannot be in the past"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Task loaded successfully"
        );
    }
}