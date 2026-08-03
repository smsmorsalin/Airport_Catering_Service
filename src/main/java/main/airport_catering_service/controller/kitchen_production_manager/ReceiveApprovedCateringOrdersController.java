package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import user.KitchenProductionManager;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class ReceiveApprovedCateringOrdersController
{
    @javafx.fxml.FXML
    private TableColumn<CateringOrder,Integer> productionOrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> mealTypesTableView;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder,String> airlineNameTableView;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> deliveryDeadlineTableView;
    @javafx.fxml.FXML
    private TableView<CateringOrder> mainTableView;
    @FXML
    private TextField productionTaskIDTextField;
    @FXML
    private TableColumn<CateringOrder,Integer> mealQuantityTableView;
    @FXML
    private TextField orderIDTextField1;

    @javafx.fxml.FXML
    public void initialize() {
        productionOrderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        airlineNameTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        mealTypesTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        mealQuantityTableView.setCellValueFactory(new PropertyValueFactory<>(""));
        deliveryDeadlineTableView.setCellValueFactory(new PropertyValueFactory<>(""));
    }

    @FXML
    public void confirmOnAction(ActionEvent actionEvent) {
        mainTableView.getItems().clear();
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




        // ================= FILE READ =================

        ArrayList<Object> cateringOrderObjects =
                BinaryFileUtility.readObjects("CateringOrder.bin");

        CateringOrder selectedOrder = null;

        int orderId=0;
        for (Object object : cateringOrderObjects) {

            if (object instanceof CateringOrder cateringOrder) {

                if (cateringOrder.getOrderId() == orderId) {
                    selectedOrder = cateringOrder;
                    break;
                }
            }
        }

        if (selectedOrder == null) {
            AlertGenerator.showAlert(
                    "Not Found",
                    "Catering order not found"
            );
            return;
        }

        if (!selectedOrder.getStatus().equalsIgnoreCase("Approved")) {
            AlertGenerator.showAlert(
                    "Not Approved",
                    "This catering order is not approved"
            );
            return;
        }


        // Prevent duplicate receiving

        ArrayList<Object> receivedOrderObjects =
                BinaryFileUtility.readObjects(
                        "ReceivedApprovedCateringOrder.bin"
                );

        for (Object object : receivedOrderObjects) {

            if (object instanceof CateringOrder cateringOrder) {

                if (cateringOrder.getOrderId() == orderId) {
                    AlertGenerator.showAlert(
                            "Already Received",
                            "This catering order has already been received"
                    );
                    return;
                }
            }
        }


        // ================= FILE WRITE =================

        boolean saved = BinaryFileUtility.writeObjects(
                "ReceivedApprovedCateringOrder.bin",
                selectedOrder
        );

        if (!saved) {
            AlertGenerator.showAlert(
                    "Error",
                    "Approved catering order could not be saved"
            );
            return;
        }


        // ================= SHOW =================

        loadReceivedOrders();

        int productionTaskId=0;
        AlertGenerator.showAlert(
                "Successful",
                "Approved catering order received successfully.\n" +
                        "Production Task ID: " + productionTaskId + "\n" +
                        "Order ID: " + orderId
        );

        productionTaskIDTextField.clear();
        orderIDTextField1.clear();
    }

    private void loadReceivedOrders() {

        mainTableView.getItems().clear();

        ArrayList<Object> receivedOrderObjects =
                BinaryFileUtility.readObjects(
                        "ReceivedApprovedCateringOrder.bin"
                );

        for (Object object : receivedOrderObjects) {

            if (object instanceof CateringOrder cateringOrder) {
                mainTableView.getItems().add(cateringOrder);
            }
        }
}


    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent)throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }



    @FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}