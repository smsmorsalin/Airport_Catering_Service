package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
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
    private Label emargencyIssueText;
    @javafx.fxml.FXML
    private Label updateIssueCurrentStatusText;
    @javafx.fxml.FXML
    private TableColumn issueTypeTableviewColumn;
    @javafx.fxml.FXML
    private ComboBox statusCombobox;
    @javafx.fxml.FXML
    private TableColumn ticketIdTableviewColumn;
    @javafx.fxml.FXML
    private Label statusText;
    @javafx.fxml.FXML
    private Label enterTicketIdText;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn descriptionTableviewColumn;

    //for all DispatchCoordinator just copy past
    private DispatchCoordinator loggedInUser;
    public void setLoggedInUser(User user){
        if (user instanceof DispatchCoordinator dispatchCoordinator){
            loggedInUser = dispatchCoordinator;
            return;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monitorDeliveryButtonOnAction(ActionEvent actionEvent) throws IOException{
        DispatchCoordinator.renderMonitorDelivery(actionEvent);
    }

    @javafx.fxml.FXML
    public void scheduleDeliveryButtonOnAction(ActionEvent actionEvent) throws IOException{
        DispatchCoordinator.renderScheduleDelivery(actionEvent);
    }

    @javafx.fxml.FXML
    public void assignTruckButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderAssignTruck(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderPackageOrder(actionEvent);
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws IOException{
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderReceiveDispatchRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) throws IOException{
        DispatchCoordinator.renderManageDeliveryDelay(actionEvent);
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderGenerateDispatchReport(actionEvent);
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderEmergencyDelivery(actionEvent);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
    }
}