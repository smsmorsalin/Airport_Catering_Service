package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import user.CustomerSupportOfficer;
import user.User;
import utility.AlertGenerator;

import java.io.IOException;

public class dashboardViewController
{
    @javafx.fxml.FXML
    private TableColumn<Airline,String> descriptionTableView;
    @javafx.fxml.FXML
    private Label emargencyIssueLabel;
    @javafx.fxml.FXML
    private TableColumn<Airline,Integer> ticketIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Airline,String> statusTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField enterticketIDTextField;
    @javafx.fxml.FXML
    private TableView<Airline> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<Airline,String> issueTypeTableView;

    private CustomerSupportOfficer loggedInUser;
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
    public void updateOnAction(ActionEvent actionEvent) {
        if(enterticketIDTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Ticket ID should be filled");
            return;
        }

        if(statusComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Status Combo Box should be selected");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarDashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewRegisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws  IOException{
        CustomerSupportOfficer.viewGenerateReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException{
        CustomerSupportOfficer.viewServiceUpdates(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFlightCancellationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        CustomerSupportOfficer.viewFlightCancellation(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewResolveComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyModificationButtonOnAction(ActionEvent actionEvent) throws  IOException {
        CustomerSupportOfficer.viewEmergencyModification(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewFlightDelayRequest(actionEvent);
    }

}