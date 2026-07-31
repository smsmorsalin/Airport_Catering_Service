package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;

import java.io.IOException;

public class KitchenPerformanceReportController
{
    @javafx.fxml.FXML
    private TableColumn mealCategoryColumn;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn productionTimeColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private Label totalTasksLabel;
    @javafx.fxml.FXML
    private Label mealsPreparedLabel;
    @javafx.fxml.FXML
    private Button exportPdfButton;
    @javafx.fxml.FXML
    private ProgressBar efficiencyProgressBar;
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private Button printButton;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private TableColumn completionColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableColumn teamColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Label completedTasksLabel;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Label pendingTasksLabel;
    @javafx.fxml.FXML
    private TableColumn preparedMealsColumn;
    @javafx.fxml.FXML
    private Label rejectedBatchLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent);
    }

    @Deprecated
    public void resetFilter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportPDF(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void printReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshReport(ActionEvent actionEvent) throws IOException {
        Headchef.renderViewKitchenPerformanceReport(actionEvent);
    }
}