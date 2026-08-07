package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.ProductionActivities;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.util.ArrayList;

public class monitorProductionViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidViewDetailsOrderIdTextField;
    @javafx.fxml.FXML
    private Label fxidShowOrderIdLabel;
    @javafx.fxml.FXML
    private Label fxidCompletionPercentLabel;
    @javafx.fxml.FXML
    private Label fxidShowAirlineNamelabel112;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;
    @javafx.fxml.FXML
    private Label fxidTotalQuantityLabel;
    @javafx.fxml.FXML
    private Label fxidRemainingQuantityLabel;
    @javafx.fxml.FXML
    private Label fxidAssignedChefLabel;
    @javafx.fxml.FXML
    private Label fxidProductionStatusLabel;

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
    }

    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        int productionOrderId = 0;
        if(fxidViewDetailsOrderIdTextField.getText().isEmpty())
        {
            AlertGenerator.showAlert("Error", "Please enter productionOrderId.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        try{
            productionOrderId = Integer.parseInt(fxidViewDetailsOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter productionOrderId.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        ProductionActivities selectedProdcutionAct =  loggedInUser.monitorProductionProgress(productionOrderId);
        if (selectedProdcutionAct == null) {
            return;
        }
        fxidShowOrderIdLabel.setText("Order ID: " + selectedProdcutionAct.getProductionOrderId());
        fxidAssignedChefLabel.setText("Assigned Chef: " + selectedProdcutionAct.getAssignedChef());
        fxidTotalQuantityLabel.setText("Total Quantity: " + selectedProdcutionAct.getTotalQuantity());
        fxidRemainingQuantityLabel.setText("Remaining quantity: " + selectedProdcutionAct.getRemainingQuantity());
        fxidCompletionPercentLabel.setText(String.valueOf(selectedProdcutionAct.getCompletionPercentage()));
    }


    //side Bar buttons
    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/emergencyIssueView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewAllCateringOrdersView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void SideBarBusinessDashboardButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/operationalReportsView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/deliveryMonitoringView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void MonitorProductionDetailsButton(Event event) {
        SceneSwitchingHelper.switchSceneWithData((ActionEvent) event, "/catering_operations_manager/monitorProductionDetailsView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/inventoryStatusView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveRejectOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/approveOrRejectOrderView.fxml", loggedInUser);
    }
}