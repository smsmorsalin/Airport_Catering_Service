package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.ProductionActivities;
import user.KitchenProductionManager;
import utility.AlertGenerator;

public class MonitorProductionActivitiesController
{
    @javafx.fxml.FXML
    private Label fxidDisplayCompletedQuantityLabel;
    @javafx.fxml.FXML
    private TableColumn<ProductionActivities,String> ProductionStatusTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionActivities,Float> completionPercentageTableView;
    @javafx.fxml.FXML
    private Label productionOrderIDTextField1;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalQuantityLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayAssignedChefLabel;
    @javafx.fxml.FXML
    private TableColumn<ProductionActivities,String> delayAlertTableView1;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayAirlineNameLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayRemainingQuantityLabel;
    @javafx.fxml.FXML
    private TableView<ProductionActivities> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionActivities,Integer> productionOrderIDTableView;

    @javafx.fxml.FXML
    public void initialize() {
        productionOrderIDTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        ProductionStatusTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        completionPercentageTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        delayAlertTableView1.setCellValueFactory(new PropertyValueFactory<>(""));
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        if(productionOrderIDTextField.getText() == null || productionOrderIDTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","ID should be filled");
            return;
        }
        int productionID;
        try {
           productionID = Integer.parseInt(productionOrderIDTextField.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Input","Id should be filled with Integer");
            return;
        }
        if(productionID <= 0){
            AlertGenerator.showAlert("Invalid Input","Id should be grater than 0");
            return;
        }

    }
    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void SideBarProductionPlanOA(ActionEvent actionEvent)throws IOException{
        KitchenProductionManager.viewCreateProductionPlan(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent);
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
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent);

    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCreateMenuList(actionEvent);
    }
}