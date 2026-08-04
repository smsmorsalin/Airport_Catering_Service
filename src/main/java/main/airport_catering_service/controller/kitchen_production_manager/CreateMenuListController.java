package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Meal;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.util.ArrayList;

public class CreateMenuListController implements UserReceiver
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

    ArrayList<Object>  mealArrayList;

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
        mealPriceTV.setCellValueFactory(new PropertyValueFactory<>("mealPrice"));
        mealIDTV.setCellValueFactory(new PropertyValueFactory<>("mealId"));
        mealNameTV.setCellValueFactory(new PropertyValueFactory<>("mealName"));

        mealArrayList = BinaryFileUtility.readObjects("Meal.bin");
        for (Object obj : mealArrayList){
            if (obj instanceof Meal meal){
                mainTableView.getItems().add(meal);
            }
        }
    }

    @javafx.fxml.FXML
    public void CreateListOnAction(ActionEvent actionEvent) {
        if (mealNameTF.getText()==null || mealNameTF.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Meal Name TextFiled Should be Filled with Characters");
            return;
        }
        if (mealPriceTF.getText() == null || mealPriceTF.getText().trim().isEmpty() ){
            AlertGenerator.showAlert("Invalid Input","Meal price should be filled");
            return;
        }
        float mealPrice;
        try {
            mealPrice = Float.parseFloat(mealPriceTF.getText().trim());
        }
        catch (Exception e ){
            AlertGenerator.showAlert("Invalid Input","Meal Price Should be in Integer");
            return;
        }
        if(mealPrice<= 0){
            AlertGenerator.showAlert("Invalid Input","Meal Price Should be Positive Number");
            return;
        }

        for (Object obj: mealArrayList){
            if(obj instanceof Meal meal){
                if(meal.getMealName().equals(mealNameTF.getText())){
                    AlertGenerator.showAlert("Error", "Duplicate Meal is not allowed");
                    return;
                }
            }
        }

        Meal savedMeal = loggedInUser.createNewMenu(mealNameTF.getText(), mealPrice);
        if(savedMeal != null){
            mainTableView.getItems().add(savedMeal);
            mealArrayList.add(savedMeal);
            return;
            //k
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