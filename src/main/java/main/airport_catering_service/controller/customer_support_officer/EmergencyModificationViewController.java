package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.CateringOrder;
import nonuser.EmergencyModificationRequest;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class EmergencyModificationViewController implements UserReceiver
{
    private static final String CATERING_ORDER_FILE = "CateringOrder.bin";
    private static final String EMERGENCY_MODIFICATION_FILE = "EmergencyModification.bin";

    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private TextArea modificationRequestTextField;
    @javafx.fxml.FXML
    private TextArea reasonTextField;
    @javafx.fxml.FXML
    private TextField orderIdTextField;


    private CustomerSupportOfficer loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof CustomerSupportOfficer customerSupportOfficer){
            this.loggedInUser = customerSupportOfficer;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }


    @javafx.fxml.FXML
    public void initialize() {
        priorityComboBox.getItems().setAll(
                "Low", "Medium", "High", "Critical");
    }


    @javafx.fxml.FXML
    public void SubmitButtonOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String orderIdText = orderIdTextField.getText().trim();
        if(orderIdText.isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Order ID should be filled");
            return;
        }

        int orderId;
        try{
            orderId = Integer.parseInt(orderIdText);
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","Order ID should be an integer");
            return;
        }
        if(orderId <= 0){
            AlertGenerator.showAlert("Invalid Input","Order ID should be greater than 0");
            return;
        }
        if(modificationRequestTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Modification request should be filled");
            return;
        }
        if(reasonTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Reason should be filled");
            return;
        }

        if(priorityComboBox.getValue() == null){
            AlertGenerator.showAlert("Invalid Input","Priority should be selected");
            return;
        }

        if (!orderExists(orderId)) {
            AlertGenerator.showAlert(
                    "Order Not Found",
                    "No catering order was found with ID " + orderId);
            return;
        }

        if (hasPendingRequest(orderId)) {
            AlertGenerator.showAlert(
                    "Request Already Exists",
                    "A pending emergency modification already exists for this order");
            return;
        }

        EmergencyModificationRequest request =
                new EmergencyModificationRequest(
                        orderId,
                        loggedInUser.getEmployeeId(),
                        modificationRequestTextField.getText().trim(),
                        reasonTextField.getText().trim(),
                        priorityComboBox.getValue());

        boolean saved = BinaryFileUtility.writeObjects(
                EMERGENCY_MODIFICATION_FILE, request);

        if (!saved) {
            AlertGenerator.showAlert(
                    "Error", "Emergency modification request could not be saved");
            return;
        }

        AlertGenerator.showAlert(
                "Success",
                "Emergency modification request submitted successfully. Request ID: "
                        + request.getRequestId());
        clearForm();
    }

    private boolean orderExists(int orderId) {
        ArrayList<Object> objects =
                BinaryFileUtility.readObjects(CATERING_ORDER_FILE);

        for (Object object : objects) {
            if (object instanceof CateringOrder order
                    && order.getOrderId() == orderId) {
                return true;
            }
        }

        return false;
    }

    private boolean hasPendingRequest(int orderId) {
        ArrayList<Object> objects =
                BinaryFileUtility.readObjects(EMERGENCY_MODIFICATION_FILE);

        for (Object object : objects) {
            if (object instanceof EmergencyModificationRequest request
                    && request.getOrderId() == orderId
                    && "Pending".equalsIgnoreCase(request.getStatus())) {
                return true;
            }
        }

        return false;
    }

    private void clearForm() {
        orderIdTextField.clear();
        modificationRequestTextField.clear();
        reasonTextField.clear();
        priorityComboBox.getSelectionModel().clearSelection();
    }











    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/RegisterComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/TrackComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws  IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/GenerateReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/ServiceUpdatesView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/FlightCancellationView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/ResolveComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/EmergencyModificationView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/customer_support_officer/FlightDelayRequestView.fxml",
                loggedInUser);
    }
}
