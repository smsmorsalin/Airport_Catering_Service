package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import user.CateringOperationsManager;
import user.User;

import java.io.IOException;

public class businessDashboardViewController
{
    @javafx.fxml.FXML
    private Label fxidTodayRevenueCountLabel;
    @javafx.fxml.FXML
    private Label fxidPendingOrdersCountLabel;
    @javafx.fxml.FXML
    private Label fxidPendingDeliverysCountLabel;
    @javafx.fxml.FXML
    private Label welcomeMessageFxid;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void seePendingDeliverysButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlEmergencyIssue(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlReviewOrder(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarApproveOrRejectOrdersButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlApproveOrRejectOrder(actionEvent);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlBusinessDashboardView(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlOperationalReport(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarLogoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent)  throws IOException {
        CateringOperationsManager.renderFxmlMonitorProduction(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlDeliveryMonitoring(actionEvent);
    }

    @javafx.fxml.FXML
    public void seePendingOrdersButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) throws IOException {
        CateringOperationsManager.renderFxmlInventoryStatus(actionEvent);
    }
}