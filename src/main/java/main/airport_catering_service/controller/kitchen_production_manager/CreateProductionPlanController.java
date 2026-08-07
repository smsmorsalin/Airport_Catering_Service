package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.CateringOrder;
import nonuser.ProductionPlan;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateProductionPlanController  implements UserReceiver {
    @javafx.fxml.FXML
    private ComboBox<String> miniutesTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfProductionDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> hourTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> endTimeTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> startTimeTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, String> stageNameTableView;
    @javafx.fxml.FXML
    private TableView<ProductionPlan> mainTableView;

    ArrayList<Object> productionPlanArrayList;

    private KitchenProductionManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof KitchenProductionManager kitchenProductionManager){
            loggedInUser = kitchenProductionManager;
        }else{
            AlertGenerator.showAlert("error", "error Authentication failed");
        }
    }

    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void initialize() {
        mainTableView.getItems().clear();
        hourTargetTimrCOmboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        miniutesTargetTimrCOmboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");

        stageNameTableView.setCellValueFactory(new PropertyValueFactory<>("stage"));
        startTimeTableView.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTimeTableView.setCellValueFactory(new PropertyValueFactory<>("endTime"));


        productionPlanArrayList = BinaryFileUtility.readObjects("Production.bin");

        for(Object obj : productionPlanArrayList){
            if(obj instanceof ProductionPlan productionPlan){
                mainTableView.getItems().add(productionPlan);
            }
        }
    }

    @FXML
    public void createPlanOnAction(ActionEvent actionEvent) {
        if (productionOrderIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Order ID should be filled.");
            return;
        }
        if (Integer.parseInt(productionOrderIDTextField.getText()) <= 0) {
            showAlert("Production Order ID must be greater than 0.");
            return;
        }
        if (dateOfProductionDatePicker.getValue() == null) {
            showAlert("Production Date should be selected.");
            return;
        }
        if (dateOfProductionDatePicker.getValue().isBefore(LocalDate.now())) {
            showAlert("Production Date cannot be before today.");
            return;
        }
        if (hourTargetTimrCOmboBox.getValue() == null || miniutesTargetTimrCOmboBox.getValue() == null) {
            showAlert("Please select the target completion time.");
            return;
        }
        int hour = Integer.parseInt(hourTargetTimrCOmboBox.getValue());
        int minute = Integer.parseInt(miniutesTargetTimrCOmboBox.getValue());
        LocalTime targetTime = LocalTime.of(hour, minute);
        showAlert(
                "Production Plan created successfully.\n" + "Order ID: " + productionOrderIDTextField + "\n" + "Production Date: " + dateOfProductionDatePicker + "\n" +
                        "Target Time:" + targetTime
        );

        if(productionPlanArrayList != null){
            for(Object obj : productionPlanArrayList){
                if(obj instanceof ProductionPlan productionPlan){
                    mainTableView.getItems().add(productionPlan);
                }
            }
        }

        int productionId = Integer.parseInt(productionOrderIDTextField.getText().trim());
        LocalDate productionDate = dateOfProductionDatePicker.getValue();

        ProductionPlan preparation = loggedInUser.createProductionPlan(productionId, productionDate,
                targetTime, targetTime,
                targetTime.plusHours(1), "Preparation");

        ProductionPlan cooking =
                loggedInUser.createProductionPlan(
                        productionId,
                        productionDate,
                        targetTime,
                        targetTime.plusHours(1),
                        targetTime.plusHours(2),
                        "Cooking"
                );

        ProductionPlan packaging =
                loggedInUser.createProductionPlan(
                        productionId,
                        productionDate,
                        targetTime,
                        targetTime.plusHours(2),
                        targetTime.plusHours(3),
                        "Packaging"
                );

        if (preparation != null && cooking != null && packaging != null) {
            mainTableView.getItems().addAll(preparation, cooking, packaging
            );showAlert("Production Plan created successfully.");
        }




    }
    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)  {
        KitchenProductionManager.reverseDashboard(actionEvent,loggedInUser);
    }

    private void loadProductionPlans() {
    }


    @FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) {
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent)   {
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent)   {

        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent)   {
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent)   {
        KitchenProductionManager.viewCreateMenuList(actionEvent,loggedInUser);
    }
}