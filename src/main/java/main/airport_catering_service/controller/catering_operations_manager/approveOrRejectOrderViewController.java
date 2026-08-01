package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class approveOrRejectOrderViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidViewDetailsOrderIdTextField;
    @javafx.fxml.FXML
    private Label fxidShowOrderStatusLabel;
    @javafx.fxml.FXML
    private Label fxidShowOrderIdLabel;
    @javafx.fxml.FXML
    private Label fxidShowFlightNumberLabel;
    @javafx.fxml.FXML
    private Label fxidShowAirlineNamelabel;
    @javafx.fxml.FXML
    private Label fxidShowTotalQuantityLabel;
    @javafx.fxml.FXML
    private Label fxidShowMealListLabel;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;
    @javafx.fxml.FXML
    private Label fxidShowDepartureDateLabel;

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
    public void acceptOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectOrderButton(ActionEvent actionEvent) {
    }





    //side Bar Buttons
    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/emergencyIssueView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/operationalReportView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent)  throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/monitorProductionView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/deliveryMonitoringView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/inventoryStatusView.fxml", loggedInUser);
    }
}