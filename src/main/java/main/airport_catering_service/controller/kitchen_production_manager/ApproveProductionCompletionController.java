package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.FoodQualityControlOfficer;
import user.KitchenProductionManager;

import javafx.scene.control.TextArea;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;


public class ApproveProductionCompletionController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;



    private KitchenProductionManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof KitchenProductionManager kitchenProductionManager){
            loggedInUser = kitchenProductionManager;
            System.out.println(kitchenProductionManager);
        }else{
            AlertGenerator.showAlert("error", "error Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
        return;
    }

    @javafx.fxml.FXML
    public void ApproveCompletionOnAction(ActionEvent actionEvent) {

        if (productionOrderIDTextField.getText() == null || productionOrderIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Plan ID should be filled");
            return;
        }

        int productionId;
        try {
            productionId = Integer.parseInt(productionOrderIDTextField.getText().trim());
        } catch (Exception e) {
            showAlert("Production Plan ID must be an integer");
            return;
        }
        if (productionId <= 0) {
            showAlert("Production Plan ID must be greater than 0");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnA(ActionEvent actionEvent){
        KitchenProductionManager.reverseDashboard(actionEvent,loggedInUser);


    }
    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarProductionReportsOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarMenuListOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewCreateMenuList(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarProductionPlanOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionOnAction(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarProductionScheduleOnA(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent,loggedInUser);

    }
}