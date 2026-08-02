package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class approveOrRejectOrderViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidViewDetailsOrderIdTextField;
    @javafx.fxml.FXML
    private Label fxidShowOrderStatusLabel;
    @javafx.fxml.FXML
    private Label fxidShowOrderIdLabel;
    @javafx.fxml.FXML
    private Label fxidShowFlightNumberLabel;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, String> tableColOrderedMealName;
    @javafx.fxml.FXML
    private Label fxidShowDeliveryDateLabel;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Integer> tableColQuanity;
    @javafx.fxml.FXML
    private TableView<OrderItem> fxidTableViewMealList;


    private ArrayList<Object> cateringOrderList;
    private ArrayList<Object> orderedItemList;
    int selectedId = 0;
    private CateringOperationsManager loggedInUser;


    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }

    }

    @javafx.fxml.FXML
    public void initialize() {
        fxidHiddenAnchorPane.setVisible(false);

        tableColQuanity.setCellValueFactory(new PropertyValueFactory<OrderItem, Integer>("quantity"));
        tableColOrderedMealName.setCellValueFactory(new PropertyValueFactory<OrderItem, String>("mealName"));
    }

    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        try{
            selectedId = Integer.parseInt(fxidViewDetailsOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("error", "Please enter a valid ID");
            fxidHiddenAnchorPane.setVisible(false);
        }
        cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for (Object o : cateringOrderList) {
            if (o instanceof CateringOrder cateringOrder) {
                if (cateringOrder.getOrderId() == selectedId) {
                    if (cateringOrder.getStatus().equals("Pending")) {
                        orderedItemList = BinaryFileUtility.readObjects("OrderItem.bin");
                        for  (Object o2 : orderedItemList) {
                            if (o2 instanceof OrderItem orderItem) {
                                if (cateringOrder.getOrderItemIds().contains(orderItem.getItemId())) {
                                    fxidTableViewMealList.getItems().add(orderItem);
                                }
                            }
                        }
                        fxidShowOrderIdLabel.setText("Order ID: " + cateringOrder.getOrderId());
                        fxidShowOrderStatusLabel.setText("Order Status: " + cateringOrder.getStatus());
                        fxidShowDeliveryDateLabel.setText("Delivery Date: " + cateringOrder.getDeliveryDate());
                        fxidShowFlightNumberLabel.setText("Flight Number: "+ cateringOrder.getFlightId());
                        fxidHiddenAnchorPane.setVisible(true);
                        return;
                    }
                    if  (cateringOrder.getStatus().equals("Rejected")) {
                        AlertGenerator.showAlert("error", "Order already Rejected");
                        fxidHiddenAnchorPane.setVisible(false);
                        return;
                    }
                    if  (cateringOrder.getStatus().equals("Approved")) {
                        AlertGenerator.showAlert("error", "Order already Approved");
                        fxidHiddenAnchorPane.setVisible(false);
                        return;
                    }

                }
            }
        }
        AlertGenerator.showAlert("error", "order doesn't exist");
        fxidHiddenAnchorPane.setVisible(false);


    }


    @javafx.fxml.FXML
    public void acceptOrderButton(ActionEvent actionEvent) {
        for(Object o : cateringOrderList) {
            if (o instanceof CateringOrder cateringOrder) {
                if (selectedId == cateringOrder.getOrderId()) {
                    cateringOrder.setStatus("Approved");
                    cateringOrder.setOrderAcceptOrRejectBy(loggedInUser.getFullName());
                    break;
                }
            }
        }
        loggedInUser.approveOrRejectOrder(cateringOrderList);
        AlertGenerator.showAlert("success", "Order has been approved");
        fxidHiddenAnchorPane.setVisible(false);
        fxidViewDetailsOrderIdTextField.clear();
    }


    @javafx.fxml.FXML
    public void rejectOrderButton(ActionEvent actionEvent) {
        for(Object o : cateringOrderList) {
            if (o instanceof CateringOrder cateringOrder) {
                if (selectedId == cateringOrder.getOrderId()) {
                    cateringOrder.setStatus("Rejected");
                    cateringOrder.setOrderAcceptOrRejectBy(loggedInUser.getFullName());
                    break;
                }
            }
        }
        loggedInUser.approveOrRejectOrder(cateringOrderList);
        AlertGenerator.showAlert("success", "Order has been Rejected");
        fxidHiddenAnchorPane.setVisible(false);
        fxidViewDetailsOrderIdTextField.clear();


    }





    //side Bar Buttons
    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/emergencyIssueView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/operationalReportView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent)  throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/monitorProductionView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/deliveryMonitoringView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/inventoryStatusView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
    }
}