package main.airport_catering_service.controller.truck_operator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import user.Truckoperator;
import user.User;

import java.io.IOException;

public class TruckOperatorDashboardController {
    @javafx.fxml.FXML
    private Button collectShipmentButton;
    @javafx.fxml.FXML
    private Button deliveryPerformanceReportButton;
    @javafx.fxml.FXML
    private Button acceptAssignmentButton;
    @javafx.fxml.FXML
    private Button viewAssignedDeliveriesButton;
    @javafx.fxml.FXML
    private Button reportDeliveryIssueButton;
    @javafx.fxml.FXML
    private Button updateDepartureStatusButton;
    @javafx.fxml.FXML
    private Button logoutButton;
    @javafx.fxml.FXML
    private Button updateTransitStatusButton;
    @javafx.fxml.FXML
    private Button confirmDeliveryButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void collectShipment(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderCollectPackagedCateringOrdersView(actionEvent);
    }

    @javafx.fxml.FXML
    public void updateTransitStatus(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDisplayDepartureConfirmationView(actionEvent);
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void updateDepartureStatus(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderStartDeliveryView(actionEvent);
    }

    @javafx.fxml.FXML
    public void viewAssignedDeliveries(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderAssignmentDeliveryTasksView(actionEvent);
    }

    @javafx.fxml.FXML
    public void deliveryPerformanceReport(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDeliveryHistoryView(actionEvent);
    }

    @javafx.fxml.FXML
    public void confirmDelivery(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderConfirmAircraftDeliveryView(actionEvent);
    }

    @javafx.fxml.FXML
    public void acceptAssignment(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderAcceptDeliveryAssignmentView(actionEvent);
    }

    @javafx.fxml.FXML
    public void reportDeliveryIssue(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderReportDeliveryProblemsView(actionEvent);
    }
    @Deprecated
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        Truckoperator.renderDashboardView(actionEvent);
    }
}