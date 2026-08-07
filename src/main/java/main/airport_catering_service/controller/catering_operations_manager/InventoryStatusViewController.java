package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.InventoryStock;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.util.ArrayList;

public class InventoryStatusViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableView<InventoryStock> IngredientTableView;
    @javafx.fxml.FXML
    private TextField fxidIngredientNameField;
    @javafx.fxml.FXML
    private TableColumn<InventoryStock, Integer> tableCol_currentStock;
    @javafx.fxml.FXML
    private TableColumn<InventoryStock, String> tableCol_ingredientName;

    private CateringOperationsManager loggedInUser;
    private ArrayList<Object> inventoryStatusList;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
            loadTableView();
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    private void loadTableView()
    {
        IngredientTableView.getItems().clear();
        inventoryStatusList = loggedInUser.inventoryStatus();
        if (inventoryStatusList.isEmpty()) {
            AlertGenerator.showAlert("Error", "No inventory available");
            return;
        }
        for (Object obj :  inventoryStatusList) {
            if (obj instanceof InventoryStock i) {
                IngredientTableView.getItems().add(i);
            }
        }
    }

    @javafx.fxml.FXML
    public void initialize() {

    }
    @javafx.fxml.FXML
    public void searchIngredientButton(ActionEvent actionEvent) {
        IngredientTableView.getItems().clear();
        if (fxidIngredientNameField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Empty ingredient name");
            return;
        }
        for(InventoryStock i : IngredientTableView.getItems()){
            if(i.getProductName().equals(fxidIngredientNameField.getText())){
                IngredientTableView.getItems().add(i);
                return;
            }
        }
        AlertGenerator.showAlert("Error", "Invalid ingredient name");
        initialize();
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

    @javafx.fxml.FXML
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
    public void MonitorProductionDetailsButton(Event event) {
        SceneSwitchingHelper.switchSceneWithData(
                (ActionEvent) event,
                "/catering_operations_manager/monitorProductionDetailsView.fxml",
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
}