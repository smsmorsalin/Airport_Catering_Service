package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class HandleRejectedBatchController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn reasonColumn;
    @javafx.fxml.FXML
    private TableColumn actionColumn;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TableColumn assignedTeamColumn;
    @javafx.fxml.FXML
    private TextArea rejectionReasonTextArea;
    @javafx.fxml.FXML
    private TableView rejectedBatchTable;
    @javafx.fxml.FXML
    private TableColumn mealTypeColumn;
    @javafx.fxml.FXML
    private ComboBox actionComboBox;
    @javafx.fxml.FXML
    private ComboBox teamComboBox;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private Button loadBatchButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextArea chefRemarksTextArea;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField taskIdField;
    @javafx.fxml.FXML
    private TextField batchIdField;
    @javafx.fxml.FXML
    private TextField rejectedByField;
    @javafx.fxml.FXML
    private TableColumn batchIdColumn;

    private Headchef loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof Headchef headchef){
            loggedInUser = headchef;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void loadRejectedBatch(ActionEvent actionEvent) {
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
        if(rejectedBatchTable.getSelectionModel().getSelectedIndex() == -1){
            AlertGenerator.showAlert("Error", "Please select a rejected batch");
            return;
        }
        if(batchIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }
        int batchId;
        try {
            batchId = Integer.parseInt(batchIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid batch ID");
            return;
        }
        if(batchId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid batch ID");
            return;
        }

    }
    @javafx.fxml.FXML
    public void submitCorrectiveAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderHandleRejectedFoodBatches(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
        taskIdField.clear();
        batchIdField.clear();
        rejectedByField.clear();
        rejectionReasonTextArea.clear();
        chefRemarksTextArea.clear();
        chefRemarksTextArea.clear();

    }
}