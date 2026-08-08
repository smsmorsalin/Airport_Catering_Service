package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class UpdateProductionStatusController implements UserReceiver {

    @FXML
    private TableColumn mealCategoryColumn;

    @FXML
    private TableView productionTable;

    @FXML
    private TableColumn remarksColumn;

    @FXML
    private Label completionLabel;

    @FXML
    private TextField currentStatusField;

    @FXML
    private Button loadButton;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private TableColumn completionColumn;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private TableColumn lastUpdatedColumn;

    @FXML
    private TableColumn teamColumn;

    @FXML
    private Button backButton;

    @FXML
    private Slider completionSlider;

    @FXML
    private Button updateButton;

    @FXML
    private TextArea remarksTextArea;

    @FXML
    private TextField taskIdField;

    @FXML
    private Button resetButton;


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


        completionSlider.setMin(0);
        completionSlider.setMax(100);
        completionSlider.setValue(0);


        completionSlider.valueProperty()
                .addListener((observable, oldValue, newValue) -> {

                    completionLabel.setText(
                            String.format("%.0f%%", newValue.doubleValue())
                    );
                });
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void updateStatus(ActionEvent actionEvent) {

        if(taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please load a task first"
            );

            return;
        }


        if(statusComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a status"
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
                "Production status updated successfully"
        );
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {

        Headchef.renderDisplayCookingProgress(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void resetForm(ActionEvent actionEvent) {

        taskIdField.clear();

        remarksTextArea.clear();

        currentStatusField.clear();

        statusComboBox.getSelectionModel()
                .clearSelection();

        completionSlider.setValue(0);

        completionLabel.setText("0%");
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


        AlertGenerator.showAlert(
                "Success",
                "Task loaded successfully"
        );
    }
}