package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class HandleRejectedBatchController implements UserReceiver {

    @FXML
    private TableColumn reasonColumn;

    @FXML
    private TableColumn actionColumn;

    @FXML
    private Button submitButton;

    @FXML
    private TableColumn assignedTeamColumn;

    @FXML
    private TextArea rejectionReasonTextArea;

    @FXML
    private TableView rejectedBatchTable;

    @FXML
    private TableColumn mealTypeColumn;

    @FXML
    private ComboBox<String> actionComboBox;

    @FXML
    private ComboBox<String> teamComboBox;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private Button loadBatchButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextArea chefRemarksTextArea;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private Button backButton;

    @FXML
    private TextField taskIdField;

    @FXML
    private TextField batchIdField;

    @FXML
    private TextField rejectedByField;

    @FXML
    private TableColumn batchIdColumn;


    private Headchef loggedInUser;


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

        actionComboBox.getItems().addAll(
                "Redo Batch",
                "Modify Recipe",
                "Discard Batch"
        );

        teamComboBox.getItems().addAll(
                "Team A",
                "Team B",
                "Team C"
        );
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent, loggedInUser);
    }


    @FXML
    public void loadRejectedBatch(ActionEvent actionEvent) {

        if (rejectedBatchTable.getSelectionModel().getSelectedIndex() == -1) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a rejected batch"
            );

            return;
        }

        AlertGenerator.showAlert(
                "Success",
                "Rejected batch loaded"
        );
    }


    @FXML
    public void submitCorrectiveAction(ActionEvent actionEvent) {

        if (actionComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select a corrective action"
            );

            return;
        }


        if (teamComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please assign a team"
            );

            return;
        }


        if (chefRemarksTextArea.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter chef remarks"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Corrective action submitted successfully"
        );
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {

        Headchef.renderHandleRejectedFoodBatches(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void clearForm(ActionEvent actionEvent) {

        taskIdField.clear();
        batchIdField.clear();
        rejectedByField.clear();

        rejectionReasonTextArea.clear();
        chefRemarksTextArea.clear();

        actionComboBox.getSelectionModel().clearSelection();
        teamComboBox.getSelectionModel().clearSelection();
    }
}