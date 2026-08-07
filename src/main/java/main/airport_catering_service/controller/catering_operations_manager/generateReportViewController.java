package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

public class generateReportViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private ComboBox fxidIssueTypeComboBox;

    private CateringOperationsManager loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assignIssueButton(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/emergencyIssueView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewAllCateringOrdersView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/operationalReportsView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/monitorProductionView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/deliveryMonitoringView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void MonitorProductionDetailsButton(Event event) {
        SceneSwitchingHelper.switchSceneWithData((ActionEvent) event, "/catering_operations_manager/monitorProductionDetailsView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/inventoryStatusView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/approveOrRejectOrderView.fxml", loggedInUser);
    }
}