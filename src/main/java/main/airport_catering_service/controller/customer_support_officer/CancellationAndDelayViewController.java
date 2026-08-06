package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.CateringOrder;
import user.CustomerSupportOfficer;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class CancellationAndDelayViewController implements UserReceiver
{
    private static final String ORDER_FILE = "CateringOrder.bin";

    @javafx.fxml.FXML
    private TableView<CateringOrder> orderTable;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, Integer> orderIdColumn;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> airlineColumn;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> statusColumn;
    @javafx.fxml.FXML
    private Label summaryOrderidLabel;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> dateColumn;

    private CustomerSupportOfficer loggedInUser;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private Button updateServiceBtn;

    @Override
    public void setLoggedInUser(User user){
        if (user instanceof CustomerSupportOfficer customerSupportOfficer){
            loggedInUser = customerSupportOfficer;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        orderIdColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleObjectProperty<>(
                cell.getValue().getOrderId()));
        dateColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                String.valueOf(cell.getValue().getDeliveryDate())));
        airlineColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getAirlineId()));
        statusColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getStatus()));
        loadOrders();
        summaryOrderidLabel.setText("-");
    }

    private void loadOrders() {
        orderTable.getItems().setAll(BinaryFileUtility.readObjects(ORDER_FILE).stream()
                .filter(CateringOrder.class::isInstance)
                .map(CateringOrder.class::cast)
                .toList());
    }

    @javafx.fxml.FXML
    public void UpdateServiceOnActionButton(ActionEvent actionEvent) {
        String text = orderidTextField.getText().trim();
        if (text.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Order ID should be filled");
            return;
        }
        int id;
        try {
            id = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Wrong Input", "Order ID should be an integer");
            return;
        }
        ArrayList<Object> orders = BinaryFileUtility.readObjects(ORDER_FILE);
        CateringOrder selected = orders.stream()
                .filter(CateringOrder.class::isInstance)
                .map(CateringOrder.class::cast)
                .filter(order -> order.getOrderId() == id).findFirst().orElse(null);
        if (selected == null) {
            AlertGenerator.showAlert("Order Not Found", "No order was found with ID " + id);
            return;
        }
        if ("Cancelled".equalsIgnoreCase(selected.getStatus())) {
            AlertGenerator.showAlert("Already Cancelled", "This order has already been cancelled"); return;
        }
        selected.setStatus("Cancelled");
        selected.setOrderAcceptOrRejectBy(String.valueOf(loggedInUser == null ? "Customer Support" : loggedInUser.getEmployeeId()));
        if (BinaryFileUtility.overwriteObjects(ORDER_FILE, orders)) {
            loadOrders(); summaryOrderidLabel.setText(String.valueOf(id)); orderidTextField.clear();
            AlertGenerator.showAlert("Success", "Order cancelled successfully");
        } else AlertGenerator.showAlert("Error", "Order update could not be saved");
    }


    private void switchTo(ActionEvent actionEvent, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, view, loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/dashboardView.fxml",
                loggedInUser);
    }


    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/RegisterComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/TrackComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/ResolveComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarNewAirlineRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/NewAirlineRequestView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarNewFlightEntryButtonOnAction(ActionEvent actionEvent)throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/NewFlightEntryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarCancellationAndDelayButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/CancellationAndDelayView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/ServiceUpdatesView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/GenerateReportsView.fxml",
                loggedInUser);
    }
}
