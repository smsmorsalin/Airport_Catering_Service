package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class MonitorCookingProgressController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn mealCategoryColumn;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn assignedTeamColumn;
    @javafx.fxml.FXML
    private TableView progressTable;
    @javafx.fxml.FXML
    private TableColumn estimatedTimeColumn;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private Button exportButton;
    @javafx.fxml.FXML
    private Label overallProgressLabel;
    @javafx.fxml.FXML
    private TableColumn progressColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private ProgressBar overallProgressBar;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField taskIdField;

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
        Headchef.renderDashboardView(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void refreshProgress(ActionEvent actionEvent) throws IOException {
        Headchef.renderDisplayPreparationProgress(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void exportProgressReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchTask(ActionEvent actionEvent) {
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
    }
}