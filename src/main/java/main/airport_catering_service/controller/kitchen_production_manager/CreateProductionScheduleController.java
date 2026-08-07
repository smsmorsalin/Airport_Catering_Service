package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.ProductionPlan;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateProductionScheduleController implements UserReceiver {
    @javafx.fxml.FXML
    private ComboBox<String> workShiftComboBox1;
    @javafx.fxml.FXML
    private ComboBox<String> endsMinutiesTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> startHoursTimeComboBox;
    @javafx.fxml.FXML
    private TextField productionPlanIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> endsHoursTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> startMinitueTimeComboBox;



    private KitchenProductionManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof KitchenProductionManager kitchenProductionManager){
            loggedInUser = kitchenProductionManager;
        }else{
            AlertGenerator.showAlert("error", "error Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        startHoursTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        startMinitueTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");
        endsHoursTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        endsMinutiesTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");
        workShiftComboBox1.getItems().addAll("Day", "Night");





    }
    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
        return;
    }


    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)  {
        KitchenProductionManager.reverseDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent){
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent){
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent,loggedInUser);

    }
    @javafx.fxml.FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent){
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent){
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewCreateMenuList(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void createScheduleOOnAction(ActionEvent actionEvent) {

        if (productionPlanIDTextField.getText() == null || productionPlanIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Plan ID should be filled");
            return;
        }
        int productionId;
        try {
            productionId = Integer.parseInt(productionPlanIDTextField.getText().trim()
            );
        } catch (NumberFormatException e) {
            showAlert("Production Plan ID must be an integer");
            return;
        }
        if (productionId <= 0) {
            showAlert("Production Plan ID must be greater than 0");
            return;
        }
        if (workShiftComboBox1.getValue() == null) {
            showAlert("Please select a Work Shift");
            return;
        }
        if (startHoursTimeComboBox.getValue() == null || startMinitueTimeComboBox.getValue() == null || endsHoursTimeComboBox.getValue() == null || endsMinutiesTimeComboBox.getValue() == null) {
            showAlert("Please select Start Time and End Time");
            return;
        }

        int startHour = Integer.parseInt(startHoursTimeComboBox.getValue());
        int startMinute = Integer.parseInt(startMinitueTimeComboBox.getValue());
        int endHour = Integer.parseInt(endsHoursTimeComboBox.getValue());
        int endMinute = Integer.parseInt(endsMinutiesTimeComboBox.getValue());
        String workShift = workShiftComboBox1.getValue();

        LocalTime startTime = LocalTime.of(startHour,startMinute);
        LocalTime endTime = LocalTime.of(endHour,endMinute);

        if(!endTime.isAfter(startTime)){
            AlertGenerator.showAlert("Error","End time must be after the start time");
            return;
        }

        ProductionPlan savedSchedule =loggedInUser.createProductionSchedule(productionId, startTime, endTime, workShift);
        if (savedSchedule != null) {
            AlertGenerator.showAlert("Error","Production Schedule created successfully");
            return;
        }
        else{
        AlertGenerator.showAlert("Error","Failed to create Production Schedule");
        return;
        }
    }
}