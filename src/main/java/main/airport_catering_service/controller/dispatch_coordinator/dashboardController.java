package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class dashboardController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField enterTicketIdTextfield;
    @javafx.fxml.FXML
    private TableColumn statusTableviewColumn;
    @javafx.fxml.FXML
    private Label  emargencyIssueText;
    @javafx.fxml.FXML
    private Label updateIssueCurrentStatusText;
    @javafx.fxml.FXML
    private TableColumn issueTypeTableviewColumn;
    @javafx.fxml.FXML
    private ComboBox <String>statusCombobox;
    @javafx.fxml.FXML
    private TableColumn ticketIdTableviewColumn;
    @javafx.fxml.FXML
    private Label statusText;
    @javafx.fxml.FXML
    private Label enterTicketIdText;
    @javafx.fxml.FXML
    private TableView  tableView;
    @javafx.fxml.FXML
    private TableColumn descriptionTableviewColumn;
    @javafx.fxml.FXML
    private Text reasonText;
    @javafx.fxml.FXML
    private TextField reasonTextfield;


    //for all DispatchCoordinator just copy past
    private DispatchCoordinator loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof DispatchCoordinator dispatchCoordinator){
            loggedInUser = dispatchCoordinator;
            return;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusCombobox.getItems().addAll("Solved", "Unsolved");
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {

        tableView.getItems().clear();

        if (enterTicketIdTextfield.getText() == null
                || enterTicketIdTextfield.getText().trim().isEmpty()
                || reasonTextfield.getText() == null
                || reasonTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "Ticket ID and Reason must be filled.");
            return;
        }

        int ticketId;

        try {
            ticketId = Integer.parseInt(enterTicketIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID must be an integer.");
            return;
        }

        if (ticketId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID must be greater than 0.");
            return;
        }

        String reason = reasonTextfield.getText().trim();

        if (statusCombobox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Please select a status.");
            return;
        }

    }

    @javafx.fxml.FXML
    public void monitorDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderMonitorDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void scheduleDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderScheduleDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void assignTruckButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderAssignTruck(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderPackageOrder(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws IOException{
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderReceiveDispatchRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) throws IOException{
        DispatchCoordinator.renderManageDeliveryDelay(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderGenerateDispatchReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderEmergencyDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
    }
}