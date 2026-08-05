package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Ingredient;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.util.ArrayList;

public class CalculateIngredientRequirementsController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField mealRecipeTextField;
    @javafx.fxml.FXML
    private TextField numOfMealTextField;
    @javafx.fxml.FXML
    private TableColumn<Ingredient,Integer> quantityRequiredTableView;
    @javafx.fxml.FXML
    private TableColumn<Ingredient,String> ingredientNameTableView;
    @javafx.fxml.FXML
    private TableColumn<Ingredient,Ingredient> unitTableView;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Ingredient,Integer> estimatedCostTableView1;
    @javafx.fxml.FXML
    private TableView<Ingredient> mainTableView;

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
        estimatedCostTableView1.setCellValueFactory(new PropertyValueFactory<>("estimatedCost"));
        quantityRequiredTableView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitTableView.setCellValueFactory(new PropertyValueFactory<>("unit"));
        ingredientNameTableView.setCellValueFactory(new PropertyValueFactory<>("ingredientName"));
    }

    @javafx.fxml.FXML
    public void calculateOnAction(ActionEvent actionEvent) {
        mainTableView.getItems().clear();

        if (productionOrderIDTextField.getText() == null || productionOrderIDTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Missing Information", "Production Order ID must be filled");
            return;
        }
        int productionOrderId;
        try {
            productionOrderId = Integer.parseInt(productionOrderIDTextField.getText().trim());
        } catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Production Order ID must be an integer");
            return;
        }
        if (productionOrderId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Production Order ID must be greater than 0");
            return;
        }

        if (mealRecipeTextField.getText() == null || mealRecipeTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Missing Information", "Meal recipe must be filled");
            return;
        }
        String mealRecipe = mealRecipeTextField.getText().trim();

        if (numOfMealTextField.getText() == null || numOfMealTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Missing Information", "Number of meals must be filled");
            return;
        }

        int numberOfMeals;
        try {
            numberOfMeals = Integer.parseInt(numOfMealTextField.getText().trim());
        }
        catch (Exception e) {
            AlertGenerator.showAlert("Invalid Input", "Number of meals must be an integer");
            return;
        }
        if (numberOfMeals <= 0) {
            AlertGenerator.showAlert("Invalid Input", "Number of meals must be greater than 0");
            return;
        }
        AlertGenerator.showAlert("Successful", "All entered information is valid");

        ArrayList<Object> ingredientList = BinaryFileUtility.readObjects("Ingredient.bin");

        mainTableView.getItems().clear();

        for (Object obj : ingredientList) {
            if (obj instanceof Ingredient ingredient) {
                ingredient.setQuantity(ingredient.getQuantity() * numberOfMeals
                );


                ingredient.setEstimatedCost((int) (ingredient.getQuantity() * ingredient.getPricePerUnit()));
                mainTableView.getItems().add(ingredient);
            }
        }
    }



    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
        KitchenProductionManager.reverseDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent)  {

        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent,loggedInUser);

    }

    @javafx.fxml.FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent)  {

        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent)  {
        KitchenProductionManager.viewCreateMenuList(actionEvent,loggedInUser);
    }
    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOnAction(ActionEvent actionEvent)  {
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent,loggedInUser);
    }
}
