package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class MonitorCookingProgressController implements UserReceiver {

    @FXML
    private TableColumn mealCategoryColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn remarksColumn;

    @FXML
    private TableColumn assignedTeamColumn;

    @FXML
    private TableView progressTable;

    @FXML
    private TableColumn estimatedTimeColumn;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private Button exportButton;

    @FXML
    private Label overallProgressLabel;

    @FXML
    private TableColumn progressColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private ProgressBar overallProgressBar;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private Button backButton;

    @FXML
    private TextField taskIdField;


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

        overallProgressBar.setProgress(0);
        overallProgressLabel.setText("0%");
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void refreshProgress(ActionEvent actionEvent) throws IOException {

        Headchef.renderDisplayPreparationProgress(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void exportProgressReport(ActionEvent actionEvent) {

        if(progressTable.getItems().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "No progress data available to export"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Cooking progress report exported"
        );
    }


    @FXML
    public void searchTask(ActionEvent actionEvent) {

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


        AlertGenerator.showAlert(
                "Success",
                "Cooking progress loaded for Task ID: " + taskId
        );
    }
}