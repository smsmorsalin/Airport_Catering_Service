package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.DispatchCoordinator;
import user.InventoryManager;
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
    private ComboBox <String>statusCombobox;
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
    @javafx.fxml.FXML
    private Text reasonText;
    @javafx.fxml.FXML
    private TextField reasonTextfield;


    private InventoryManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof InventoryManager inventoryManager){
            loggedInUser = inventoryManager;
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

        if (enterTicketIdTextfield.getText().trim().isEmpty()
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
    public void manageSupplierButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderManageSupplier(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent)throws IOException{
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void updateInventoryButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderUpdateInventory(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void createPurchaseRequestButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderCreatePurchaseRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateInventoryReportButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderGenerateInventoryReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void lowStockAlertButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderLowStockAlert(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void checkIngredientAvailabilityButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderCheckIngredientAvailability(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void reserveIngredientButtonOnAction(ActionEvent actionEvent) {
        InventoryManager.renderReserveIngredient(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void receiveIngredientButtonOnAction(ActionEvent actionEvent){
        InventoryManager.renderReceiveIngredient(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) {
    }
}