package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.DeliveryStatus;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class deliveryMonitoringViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn<DeliveryStatus, LocalDate> tableCol_DeliveryTime;
    @javafx.fxml.FXML
    private DatePicker fxidFromDatePicker;
    @javafx.fxml.FXML
    private DatePicker fxidToDatePicker;
    @javafx.fxml.FXML
    private TableView<DeliveryStatus> deliveryStatusTableView;

    private CateringOperationsManager loggedInUser;
    @javafx.fxml.FXML
    private TableColumn<DeliveryStatus, Integer> tableCol_driverUserId;
    @javafx.fxml.FXML
    private TableColumn<DeliveryStatus, String> tableCol_reciverName;

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
        tableCol_DeliveryTime.setCellValueFactory(new PropertyValueFactory<DeliveryStatus, LocalDate>("deliveryDate"));
        tableCol_driverUserId.setCellValueFactory(new PropertyValueFactory<DeliveryStatus, Integer>("deliverBy"));
        tableCol_reciverName.setCellValueFactory(new PropertyValueFactory<DeliveryStatus, String>("receiverName"));

    }

    @javafx.fxml.FXML
    public void loadDeliveryStatusButton(ActionEvent actionEvent) {
        if (fxidFromDatePicker.getValue() == null || fxidToDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please select From and To both date to load delivery data.");
            return;
        }
        if(fxidFromDatePicker.getValue().isAfter(fxidToDatePicker.getValue())) {
            AlertGenerator.showAlert("Error", "From date must be before to date.");
            return;
        }
        ArrayList<DeliveryStatus> deliveryStatusArrayList;

        deliveryStatusArrayList = loggedInUser.monitorDeliveryStatus(fxidFromDatePicker.getValue(), fxidToDatePicker.getValue());
        if(deliveryStatusArrayList.isEmpty()){
            return;
        }

        for (DeliveryStatus d : deliveryStatusArrayList) {
            deliveryStatusTableView.getItems().add(d);
        }
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