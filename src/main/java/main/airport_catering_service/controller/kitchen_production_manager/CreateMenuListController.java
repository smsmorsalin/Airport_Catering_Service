package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Meal;
import user.KitchenProductionManager;
import utility.AlertGenerator;

import java.io.IOException;

public class CreateMenuListController
{
    @javafx.fxml.FXML
    private TextField mealNameTF;
    @javafx.fxml.FXML
    private TableView<Meal> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<Meal,String> mealNameTV;
    @javafx.fxml.FXML
    private TextField mealPriceTF;
    @javafx.fxml.FXML
    private TableColumn<Meal,Integer> mealIDTV;
    @javafx.fxml.FXML
    private TableColumn<Meal,Integer> mealPriceTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CreateListOnAction(ActionEvent actionEvent) {
        mainTableView.getItems().clear();
        if (mealNameTF.getText()==null || mealNameTF.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Meal Name TextFiled Should be Filled with Characters");
            return;
        }
        if (mealPriceTF.getText() == null || mealPriceTF.getText().trim().isEmpty() ){
            AlertGenerator.showAlert("Invalid Input","Meal price should be filled");
            return;
        }
        int  mealPrice;
        try {
            mealPrice = Integer.parseInt(mealPriceTF.getText().trim());
        }
        catch (Exception e ){
            AlertGenerator.showAlert("Invalid Input","Meal Price Should be in Integer");
            return;
        }
        if(mealPrice<= 0){
            AlertGenerator.showAlert("Invalid Input","Meal Price Should be Positive Number");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.reverseDashboard(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewGenerateProductionReports(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCreateProductionPlan(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideReceiveOrdersOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent);
    }
    @javafx.fxml.FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent);
    }

}