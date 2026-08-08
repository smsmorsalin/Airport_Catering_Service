package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import nonuser.Airline;
import nonuser.CateringOrder;
import user.KitchenProductionManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.util.ArrayList;


public class ReceiveApprovedCateringOrdersController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> mealTypesTableView;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder,String> airlineIdTableView;
    @javafx.fxml.FXML
    private TableView<CateringOrder> mainTableView;
    @FXML
    private TextField productionTaskIDTextField;
    @FXML
    private TableColumn<CateringOrder,Integer> mealQuantityTableView;
    @FXML
    private TextField orderIDTextField1;

    private KitchenProductionManager loggedInUser;
    @FXML
    private TableColumn<CateringOrder,Integer> OrderIDTableColumn;

    ArrayList<Object> cateringOrderList;

    @Override
    public void setLoggedInUser(User user){
        if (user instanceof KitchenProductionManager kitchenProductionManager){
            loggedInUser = kitchenProductionManager;
        }else{
            AlertGenerator.showAlert("error", "error Authentication failed");
        }
    }

    @FXML
    public void initialize() {
        mainTableView.getItems().clear();
        OrderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        airlineIdTableView.setCellValueFactory(new PropertyValueFactory<>("airlineId"));
        mealTypesTableView.setCellValueFactory(new PropertyValueFactory<>("orderItemIds"));

//        ArrayList<String> itemList1 = new ArrayList<>();
//        itemList1.add("Chicken Meal");
//        itemList1.add("Rice");
//
//        ArrayList<String> itemList2 = new ArrayList<>();
//        itemList2.add("Beef Meal");
//        itemList2.add("Polaw");
//
//        CateringOrder new1 = new CateringOrder(101,"Biman",itemList1);
//        CateringOrder new2 = new CateringOrder(102,"US-Bangla",itemList2);
//
//        BinaryFileUtility.writeObjects("CateringOrder.bin",new1);
//        BinaryFileUtility.writeObjects("CateringOrder.bin",new2);

        cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for (Object obj : cateringOrderList) {
            if (obj instanceof CateringOrder cateringOrder) {
                mainTableView.getItems().add(cateringOrder);
            }
        }
    }

    @FXML
    public void confirmOnAction(ActionEvent actionEvent) {
        if( productionTaskIDTextField.getText()  == null || productionTaskIDTextField.getText().trim().isEmpty() ||orderIDTextField1.getText() == null ||orderIDTextField1.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","ID TextField should be filled");
            return;
        }
        int productionOrderID,orderID;
        try{
            productionOrderID = Integer.parseInt(productionTaskIDTextField.getText().trim()) ;
            orderID= Integer.parseInt(orderIDTextField1.getText().trim());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid","Id should be Integer");
            return;
        }
        if( productionOrderID <= 0 || orderID <= 0){
            AlertGenerator.showAlert("Invalid Input","Id Should be grater than 0");
            return;
        }

        for (CateringOrder order : mainTableView.getItems()) {
            if (order.getOrderId() == orderID) {
                AlertGenerator.showAlert("Success", "Successfully Ordered");
                return;
            }
        }
        AlertGenerator.showAlert("Error", "Order ID not found");
    }



    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent){
        KitchenProductionManager.reverseDashboard(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent)    {
//        KitchenProductionManager.viewGenerateProductionReports(actionEvent);
        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent)   {
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent,loggedInUser);
//        KitchenProductionManager.viewApproveProductionCompletion(actionEvent);
    }
    @FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent)   {
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);

//        KitchenProductionManager.viewApproveProductionCompletion(actionEvent);
    }
    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent)   {
//        KitchenProductionManager.viewMonitorProductionActivities(actionEvent);
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);
    }

    @FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent)   {
//        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent);
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent,loggedInUser);
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent)  {
//        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent);
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent,loggedInUser);
    }
    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent)  {
//        KitchenProductionManager.viewCreateMenuList(actionEvent);
        KitchenProductionManager.viewCreateMenuList(actionEvent,loggedInUser);
    }
}