package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.CustomerSupportOfficer;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;

public class EmergencyModificationViewController implements UserReceiver
{

    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private TextArea modificationRequestTextField;
    @javafx.fxml.FXML
    private TextArea reasonTextField;
    @javafx.fxml.FXML
    private TextField orderIdTextField;

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
    public void SubmitButtonOnAction(ActionEvent actionEvent) {
        if(orderIdTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        int orderId;
        try{
            orderId = Integer.parseInt(orderIdTextField.getText());
        }
        catch (NumberFormatException e){
            AlertGenerator.showAlert("Wrong Input","textField should be an integer");
            return;
        }
        if(orderId <= 0){
            AlertGenerator.showAlert("Invalid Input","Text field should be grater than 0");
            return;
        }
        if(modificationRequestTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }
        if(reasonTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Text field should be filled");
            return;
        }

        if(priorityComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Date should not be past date");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
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
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
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
}