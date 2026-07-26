package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class operationalReportViewController
{
    @javafx.fxml.FXML
    private TextField fxidDescritionTextField;
    @javafx.fxml.FXML
    private ComboBox fxidIssueTypeComboBox;
    @javafx.fxml.FXML
    private TableView issueTableView;
    @javafx.fxml.FXML
    private TableColumn tableCol_assignedUserId;
    @javafx.fxml.FXML
    private TableColumn tableCol_issueType;
    @javafx.fxml.FXML
    private TextField fxidAssignUserIdTextField;
    @javafx.fxml.FXML
    private TableColumn tableCol_description;
    @javafx.fxml.FXML
    private TableColumn tableCol_TicketId;
    @javafx.fxml.FXML
    private TableColumn tableCol_staus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MonitorProductionDetailsButton(Event event) {
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void assignIssueButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
    }
}