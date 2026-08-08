package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ManageMealPreparationController implements UserReceiver {

    @FXML
    private TableColumn mealCategoryColumn;

    @FXML
    private TableColumn remarksColumn;

    @FXML
    private TableColumn assignedTeamColumn;

    @FXML
    private TextArea instructionTextArea;

    @FXML
    private Button startPreparationButton;

    @FXML
    private TextArea specialRequirementTextArea;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private Button clearButton;

    @FXML
    private Button updateStatusButton;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private Button backButton;

    @FXML
    private TextField taskIdField;

    @FXML
    private TableView preparationTable;


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

        statusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed",
                "Delayed"
        );
    }


    @FXML
    public void startPreparation(ActionEvent actionEvent) {

        if (taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        int taskId;

        try {
            taskId = Integer.parseInt(taskIdField.getText());

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
                    "Task ID must be greater than zero"
            );

            return;
        }


        if (statusComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a preparation status"
            );

            return;
        }


        if (specialRequirementTextArea.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter special requirements"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Meal preparation started successfully"
        );
    }


    @FXML
    public void updatePreparationStatus(ActionEvent actionEvent) {

        if (taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        if (statusComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a status"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Preparation status updated"
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

        Headchef.renderManageMealPreparation(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void clearForm(ActionEvent actionEvent) {

        taskIdField.clear();
        instructionTextArea.clear();
        specialRequirementTextArea.clear();

        statusComboBox.getSelectionModel()
                .clearSelection();
    }
}