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
        if(assignmentIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a assignment ID");
            return;
        }
        int assignmentId;
        try {
            assignmentId = Integer.parseInt(assignmentIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if(assignmentId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid assignment ID");
            return;
        }
        if(descriptionTextArea.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a description");
            return;
        }
        if(locationField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a location ID");
            return;
        }
        int locationId;
        try {
            locationId = Integer.parseInt(locationField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if(locationId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid location ID");
            return;
        }
        if (issueTypeComboBox.getSelectionModel().getSelectedIndex() == 0){
            AlertGenerator.showAlert("Error", "Please select a type of issue");
            return;
        }
        if (issueDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please enter a delivery date from the delivery date field");
            return;
        }
        if (severityComboBox.getSelectionModel().getSelectedIndex() == 0){
            AlertGenerator.showAlert("Error", "Please select a severity");
            return;
        }
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