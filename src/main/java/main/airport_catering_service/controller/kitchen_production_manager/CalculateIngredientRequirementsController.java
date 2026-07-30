package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import user.AirlineRepresentative;
import user.KitchenProductionManager;

import java.io.IOException;

public class CalculateIngredientRequirementsController
{
    @javafx.fxml.FXML
    private TextField mealRecipeTextField;
    @javafx.fxml.FXML
    private TextField numOfMealTextField;
    @javafx.fxml.FXML
    private TableColumn quantityRequiredTableView;
    @javafx.fxml.FXML
    private TableColumn ingredientNameTableView;
    @javafx.fxml.FXML
    private TableColumn unitTableView;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private TableColumn estimatedCostTableView1;
    @javafx.fxml.FXML
    private TableView mainTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}