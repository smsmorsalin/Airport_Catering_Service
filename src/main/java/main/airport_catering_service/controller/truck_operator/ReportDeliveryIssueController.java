package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.Truckoperator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ReportDeliveryIssueController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn severityColumn;
    @javafx.fxml.FXML
    private ComboBox issueTypeComboBox;
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TableColumn locationColumn;
    @javafx.fxml.FXML
    private TableColumn assignmentIdColumn;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn issueIdColumn;
    @javafx.fxml.FXML
    private TextField assignmentIdField;
    @javafx.fxml.FXML
    private TableView issueTable;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn reportedTimeColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private DatePicker issueDatePicker;
    @javafx.fxml.FXML
    private TableColumn issueTypeColumn;
    @javafx.fxml.FXML
    private ComboBox severityComboBox;

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
    public void loadAssignment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void submitIssueReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderReportDeliveryProblemsView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
        assignmentIdField.clear();
        locationField.clear();
        descriptionTextArea.clear();
    }
}