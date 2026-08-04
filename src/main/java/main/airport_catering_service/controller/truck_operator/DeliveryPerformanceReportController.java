package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class DeliveryPerformanceReportController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn orderIdColumn;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn assignmentIdColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private Button exportPdfButton;
    @javafx.fxml.FXML
    private Label successfulDeliveriesLabel;
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private Button printButton;
    @javafx.fxml.FXML
    private Label delayedDeliveriesLabel;
    @javafx.fxml.FXML
    private Label reportedIssuesLabel;
    @javafx.fxml.FXML
    private TableColumn flightNumberColumn;
    @javafx.fxml.FXML
    private Label totalDeliveriesLabel;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private TableColumn destinationColumn;
    @javafx.fxml.FXML
    private TableColumn deliveryTimeColumn;
    @javafx.fxml.FXML
    private ProgressBar onTimeProgressBar;

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
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
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
        Truckoperator.renderDeliveryHistoryView(actionEvent, loggedInUser);
    }
}