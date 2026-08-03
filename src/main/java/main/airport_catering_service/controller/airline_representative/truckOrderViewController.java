package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.util.ArrayList;

public class truckOrderViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label fxidDispatchStatusLabel;
    @javafx.fxml.FXML
    private Label fxidQualityCheckStatusLabel;
    @javafx.fxml.FXML
    private Label fxidApprovalStatusLabel;
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;
    @javafx.fxml.FXML
    private Label fxidProductionStatusLabel;
    @javafx.fxml.FXML
    private Label fxidDeliveryStatusLabel;

    private AirlineRepresentative loggedInUser;
    int orderId=0;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof AirlineRepresentative airlineRepresentative) {
            this.loggedInUser = airlineRepresentative;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        fxidHiddenAnchorPane.setVisible(false);
    }

    @javafx.fxml.FXML
    public void TruckOrderButton(ActionEvent actionEvent) {
        ArrayList<String> truckOrderList;

        try{
            orderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }

        truckOrderList = loggedInUser.trackCateringOrderStatus(orderId);
        if(truckOrderList == null){
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        fxidHiddenAnchorPane.setVisible(true);

        if(truckOrderList.contains("Approved")){
            fxidApprovalStatusLabel.setText("Approval Status: ✔");
        }
        if(truckOrderList.contains("Production")){
            fxidProductionStatusLabel.setText("Production Status: ✔");
        }
        if (truckOrderList.contains("Delivered")){
            fxidDeliveryStatusLabel.setText("Delivery Status: ✔");
        }
        if (truckOrderList.contains("Quality Inspection")){
            fxidQualityCheckStatusLabel.setText("Quality Inspection Status: ✔");
        }
        if (truckOrderList.contains("Dispatch")){
            fxidDispatchStatusLabel.setText("Dispatch Status: ✔");
        }

    }

    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/airline_representative/createCateringOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/dashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarPayInvoiceButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/payInvoiceView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/confirmDeliveryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/flightDelayView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarCancelOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/cancelOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/orderHistoryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/modifyOrderView.fxml",
                loggedInUser
        );
    }
}