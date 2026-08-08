package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.EmergencyIssue;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.util.ArrayList;

public class emergencyIssueViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidDescritionTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fxidIssueTypeComboBox;
    @javafx.fxml.FXML
    private TableView<EmergencyIssue> issueTableView;
    @javafx.fxml.FXML
    private TableColumn<EmergencyIssue, Integer> tableCol_assignedUserId;
    @javafx.fxml.FXML
    private TableColumn<EmergencyIssue, String> tableCol_issueType;
    @javafx.fxml.FXML
    private TextField fxidAssignUserIdTextField;
    @javafx.fxml.FXML
    private TableColumn<EmergencyIssue, String> tableCol_description;
    @javafx.fxml.FXML
    private TableColumn<EmergencyIssue, Integer> tableCol_TicketId;
    @javafx.fxml.FXML
    private TableColumn<EmergencyIssue, String> tableCol_staus;

    private CateringOperationsManager loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    private void loadTableView() {
        ArrayList<Object> emergencyIssuesList = BinaryFileUtility.readObjects("EmergencyIssue.bin");
        if (emergencyIssuesList.isEmpty()) {
            return;
        }

    }

    @javafx.fxml.FXML
    public void initialize() {
        fxidIssueTypeComboBox.getItems().addAll(
                "Flight Delay",
                "Flight Cancellation",
                "Meal Quantity Change",
                "Last-Minute Meal Change",
                "Delivery Time Change",
                "Food Quality Issue",
                "Equipment Failure",
                "Staff Shortage",
                "Other");

        tableCol_TicketId.setCellValueFactory(new PropertyValueFactory<EmergencyIssue, Integer>("ticketId"));
        tableCol_assignedUserId.setCellValueFactory(new PropertyValueFactory<EmergencyIssue, Integer>("assignedUserId"));
        tableCol_description.setCellValueFactory(new PropertyValueFactory<EmergencyIssue, String>("description"));
        tableCol_issueType.setCellValueFactory(new PropertyValueFactory<EmergencyIssue, String>("issueType"));
        tableCol_staus.setCellValueFactory(new PropertyValueFactory<EmergencyIssue, String>("staus"));

    }

    @javafx.fxml.FXML
    public void assignIssueButton(ActionEvent actionEvent) {
        if(fxidIssueTypeComboBox.getValue().isEmpty() || fxidAssignUserIdTextField.getText().isEmpty() || fxidDescritionTextField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please fill all the required fields.");
            return;
        }

        //call model class method and check user verified or not then write to the file
    }


    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/emergencyIssueView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/reviewAllCateringOrdersView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/businessDashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/businessDashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/operationalReportsView.fxml",
                loggedInUser
        );
    }

    @Deprecated
    public void sideBarMonitorProductionButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/monitorProductionView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/deliveryMonitoringView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/inventoryStatusView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/approveOrRejectOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButtonOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/monitorProductionView.fxml", loggedInUser);
    }
}