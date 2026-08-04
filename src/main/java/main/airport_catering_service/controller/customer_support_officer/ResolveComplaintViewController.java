package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.CustomerSupportOfficer;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class ResolveComplaintViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label complaintIdLabel;
    @javafx.fxml.FXML
    private Label currentStatusLabel;
    @javafx.fxml.FXML
    private Label orderIdLabel;
    @javafx.fxml.FXML
    private Label airlineLabel;
    @javafx.fxml.FXML
    private TextField complaintidTextField;
    @javafx.fxml.FXML
    private TextArea resolutionNotesTextField;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionStatusComboBox;


    private CustomerSupportOfficer loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof CustomerSupportOfficer CustomerSupportOfficer){
            this.loggedInUser = CustomerSupportOfficer;
        }
        AlertGenerator.showAlert("error", "error Authentication failed");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ResolveComplaintOnAction(ActionEvent actionEvent) {
        if(complaintidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        int orderId;
        try{
            orderId = Integer.parseInt(complaintidTextField.getText());
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","textField should be an integer");
            return;
        }
        if(orderId <= 0){
            AlertGenerator.showAlert("Invalid Input","Text field should be grater than 0");
            return;
        }
        if(resolutionNotesTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Text field should be filled");
            return;
        }

        if(resolutionStatusComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Date should not be past date");
            return;
        }

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