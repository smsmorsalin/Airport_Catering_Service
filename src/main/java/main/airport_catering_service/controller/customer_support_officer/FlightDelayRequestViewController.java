package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.CustomerSupportOfficer;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class FlightDelayRequestViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Button updateScheduleBtn;
    @javafx.fxml.FXML
    private TextField newTimeTextField;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private TextArea delayReasonTextField;
    @javafx.fxml.FXML
    private TextField previousTimeTextField;

    private FinanceAndBillingManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FinanceAndBillingManager FinanceAndBillingManager){
            this.loggedInUser = FinanceAndBillingManager;
        }
        AlertGenerator.showAlert("error", "error Authentication failed");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void UpdateScheduleOnAction(ActionEvent actionEvent) {
        if(orderidTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        if(newTimeTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        if(delayReasonTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        if(previousTimeTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
    }



    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewFlightDelayRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewGenerateReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewServiceUpdates(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewFlightCancellation(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewResolveComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }
}