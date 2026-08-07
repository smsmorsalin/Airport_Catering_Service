package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class KitchenPerformanceReportController implements UserReceiver {

    @FXML
    private TableColumn mealCategoryColumn;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private TableColumn remarksColumn;

    @FXML
    private TableColumn productionTimeColumn;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private Label totalTasksLabel;

    @FXML
    private Label mealsPreparedLabel;

    @FXML
    private Button exportPdfButton;

    @FXML
    private ProgressBar efficiencyProgressBar;

    @FXML
    private TableView reportTable;

    @FXML
    private Button printButton;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private TableColumn completionColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private TableColumn teamColumn;

    @FXML
    private Button backButton;

    @FXML
    private Label completedTasksLabel;

    @FXML
    private Button generateReportButton;

    @FXML
    private Label pendingTasksLabel;

    @FXML
    private TableColumn preparedMealsColumn;

    @FXML
    private Label rejectedBatchLabel;


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

        efficiencyProgressBar.setProgress(0);
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void resetFilter(ActionEvent actionEvent) {

        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);

        reportTable.getItems().clear();

        totalTasksLabel.setText("0");
        completedTasksLabel.setText("0");
        pendingTasksLabel.setText("0");
        mealsPreparedLabel.setText("0");
        rejectedBatchLabel.setText("0");

        efficiencyProgressBar.setProgress(0);
    }


    @FXML
    public void generateReport(ActionEvent actionEvent) {

        if (fromDatePicker.getValue() == null ||
                toDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select both start and end dates"
            );

            return;
        }


        if (toDatePicker.getValue()
                .isBefore(fromDatePicker.getValue())) {

            AlertGenerator.showAlert(
                    "Error",
                    "End date cannot be before start date"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Kitchen performance report generated"
        );
    }


    @FXML
    public void exportPDF(ActionEvent actionEvent) {

        if(reportTable.getItems().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Generate a report before exporting"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Report exported as PDF"
        );
    }


    @FXML
    public void printReport(ActionEvent actionEvent) {

        if(reportTable.getItems().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Generate a report before printing"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Report sent to printer"
        );
    }


    @FXML
    public void refreshReport(ActionEvent actionEvent) throws IOException {

        Headchef.renderViewKitchenPerformanceReport(
                actionEvent,
                loggedInUser
        );
    }
}