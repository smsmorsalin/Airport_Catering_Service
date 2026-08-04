package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class packageOrderController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn packagingIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn completionTimeTableviewColumn;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TableColumn packagingTypeTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private Text packagingTypeText;
    @javafx.fxml.FXML
    private Text packagingNoteText;
    @javafx.fxml.FXML
    private ComboBox <String> packagingTypeComboBox;
    @javafx.fxml.FXML
    private TextArea packagingNoteTextArea;


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
        packagingTypeComboBox.getItems().addAll("Pending", "Complete");
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
        DispatchCoordinator.renderAssignTruck(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderPackageOrder(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderReceiveDispatchRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderManageDeliveryDelay(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderGenerateDispatchReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderEmergencyDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {

        if (orderIdTextfield.getText() == null
                || orderIdTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "Order ID must be filled.");
            return;
        }

        int orderId;

        try {
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be an integer.");
            return;
        }

        if (orderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Order ID must be greater than 0.");
            return;
        }

        if (packagingTypeComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Please select a packaging status.");
            return;
        }

        if (packagingNoteTextArea.getText() == null
                || packagingNoteTextArea.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "Packaging Note must be filled.");
            return;
        }

        String packagingNote = packagingNoteTextArea.getText().trim();

    }
}