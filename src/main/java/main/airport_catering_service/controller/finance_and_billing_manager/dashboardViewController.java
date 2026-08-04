package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Airline;
import user.FinanceAndBillingManager;
//<<<<<<< HEAD
import user.KitchenProductionManager;
//=======
//>>>>>>> f82d5b9173af5fc5ed5a83068e71f706a69bcf2c
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import javax.imageio.IIOException;
import java.io.IOException;

public class dashboardViewController implements UserReceiver
{

    @javafx.fxml.FXML
    private TableColumn<Airline,String> descriptionTableView;
    @javafx.fxml.FXML
    private TextField  enterTicketIDtextField;
    @javafx.fxml.FXML
    private Label emargencyIssueLabel;
    @javafx.fxml.FXML
    private TableColumn <Airline,Integer> ticketIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Airline,String> statusTableView;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TableView <Airline> mainTableView;
    @javafx.fxml.FXML
    private TableColumn <Airline,String> issueTypeTableView;

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
    public void updateOnAction(ActionEvent actionEvent) {
        if(enterTicketIDtextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Ticket ID should be filled");
            return;
        }

        if(statusComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Status Combo Box should be selected");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewdashboard(actionEvent);

    }
    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewRevenueSummary(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewRecordPayment(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewProcessRefund(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewGenerateInvoice(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewPaymentHistory(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewCalculateCost(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewFinancialReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewOutstandingPayments(actionEvent);
    }


}