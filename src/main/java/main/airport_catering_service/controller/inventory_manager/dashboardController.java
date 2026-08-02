package main.airport_catering_service.controller.inventory_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.InventoryManager;
import user.User;

import java.io.IOException;

public class dashboardController
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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageSupplierButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.renderManageSupplier(actionEvent);
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws IOException{
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void updateInventoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.renderUpdateInventory(actionEvent);
    }

    @javafx.fxml.FXML
    public void createPurchaseRequestButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.renderCreatePurchaseRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void generateInventoryReportButtonOnAction(ActionEvent actionEvent)throws IOException {
        InventoryManager.renderGenerateInventoryReport(actionEvent);
    }

    @javafx.fxml.FXML
    public void lowStockAlertButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.renderLowStockAlert(actionEvent);
    }

    @javafx.fxml.FXML
    public void checkIngredientAvailabilityButtonOnAction(ActionEvent actionEvent) throws IOException {
        InventoryManager.renderCheckIngredientAvailability(actionEvent);
    }

    @javafx.fxml.FXML
    public void reserveIngredientButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.renderReserveIngredient(actionEvent);
    }

    @javafx.fxml.FXML
    public void receiveIngredientButtonOnAction(ActionEvent actionEvent)throws IOException {
        InventoryManager.renderReceiveIngredient(actionEvent);
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        InventoryManager.reverseDashboard(actionEvent);
    }
}