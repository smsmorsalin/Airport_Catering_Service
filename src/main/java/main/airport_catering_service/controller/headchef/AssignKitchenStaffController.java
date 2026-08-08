package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class AssignKitchenStaffController implements UserReceiver
{
    @javafx.fxml.FXML
    private ComboBox workStationComboBox;
    @javafx.fxml.FXML
    private TableColumn assignmentIdColumn;
    @javafx.fxml.FXML
    private TableColumn staffNameColumn;
    @javafx.fxml.FXML
    private TableColumn stationColumn;
    @javafx.fxml.FXML
    private Button assignButton;
    @javafx.fxml.FXML
    private TableColumn shiftColumn;
    @javafx.fxml.FXML
    private ComboBox shiftComboBox;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn assignedTaskColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableView assignmentTable;
    @javafx.fxml.FXML
    private ComboBox staffComboBox;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField taskIdField;

    private Headchef loggedInUser;

    @Override
    public void setLoggedInUser(User user){
        if (user instanceof Headchef headchef){
            loggedInUser = headchef;
        } else {
            AlertGenerator.showAlert("Error", "This is not a valid user for this page");
        }
    }

    @javafx.fxml.FXML
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
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
        taskIdField.clear();
        staffComboBox.getSelectionModel().clearSelection();
        shiftComboBox.getSelectionModel().clearSelection();
        workStationComboBox.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void assignKitchenStaff(ActionEvent actionEvent) {
        if(taskIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }

        int taskId;

        try {
            taskId = Integer.parseInt(taskIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }

        if(taskId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }

        if (staffComboBox.getSelectionModel().getSelectedItem() == null) {
            AlertGenerator.showAlert("Error", "Please select a Staff");
            return;
        }

        if (shiftComboBox.getSelectionModel().getSelectedItem() == null) {
            AlertGenerator.showAlert("Error", "Please select a Shift");
            return;
        }

        if (workStationComboBox.getSelectionModel().getSelectedItem() == null) {
            AlertGenerator.showAlert("Error", "Please select a Work Station");
            return;
        }

        AlertGenerator.showAlert(
                "Success",
                "Kitchen staff assigned successfully"
        );
    }

    @javafx.fxml.FXML
    public void refreshAssignments(ActionEvent actionEvent) throws IOException {
        Headchef.renderProductionTaskInformation(actionEvent, loggedInUser);
    }
}