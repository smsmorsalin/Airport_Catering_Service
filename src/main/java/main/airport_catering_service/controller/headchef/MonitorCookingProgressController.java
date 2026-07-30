package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MonitorCookingProgressController
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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshProgress(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportProgressReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchTask(ActionEvent actionEvent) {
    }
}