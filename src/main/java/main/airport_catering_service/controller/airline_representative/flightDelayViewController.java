package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class flightDelayViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDelayDeliveryTimeMinuteComboBox;
    @javafx.fxml.FXML
    private Label fxidOrderedDeliveryTimeLabel;
    @javafx.fxml.FXML
    private Label fxidOrderedFlightNumberLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDelayDeliveryTimeHourComboBox;
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;

    private AirlineRepresentative loggedInUser;
    private ArrayList<Object> selectedCateringOrder;
    private LocalDate OldDeliveryTime;
    int selectedCateringOrderId = 0;

    @FXML
    private Label fxidOrderedDetailsOrderIdLabel;
    @FXML
    private Label fxidOrderedDeliveryDateLabel;
    @FXML
    private DatePicker fxidDelayDeliveryDateDatePicker;

    @Override
    public void setLoggedInUser(User user){
        if (user instanceof AirlineRepresentative airlineRepresentative){
            this.loggedInUser = airlineRepresentative;
        }else{
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }


    @javafx.fxml.FXML
    public void initialize() {
        fxidHiddenAnchorPane.setVisible(false);

        fxidDelayDeliveryTimeHourComboBox.getItems().clear();

        for (int hour = 0; hour < 24; hour++) {
            fxidDelayDeliveryTimeHourComboBox.getItems().add(hour);
        }

        fxidDelayDeliveryTimeMinuteComboBox.getItems().clear();

        for (int minute = 0; minute < 60; minute++) {
            fxidDelayDeliveryTimeMinuteComboBox.getItems().add(minute);
        }
    }


    @javafx.fxml.FXML
    public void loadOrderedData(ActionEvent actionEvent) {
        try{
            selectedCateringOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID");
        }

        selectedCateringOrder = new ArrayList<>();
        selectedCateringOrder = BinaryFileUtility.readObjects("CateringOrder.bin");

        for(Object o : selectedCateringOrder){
            if (o instanceof CateringOrder cateringOrder){
                if(cateringOrder.getOrderId() == selectedCateringOrderId){
                    if (cateringOrder.getStatus().equals("delivered")){
                        AlertGenerator.showAlert("Error", "Order has been delivered");
                        return;
                    }
                    if (! cateringOrder.getAirlineId().equals(loggedInUser.getAirlineId())) {
                        AlertGenerator.showAlert("Error", "order does not belong to your airline.");
                        fxidHiddenAnchorPane.setVisible(false);
                        return;
                    }
                    fxidOrderedDetailsOrderIdLabel.setText("Order ID: " + cateringOrder.getOrderId());
                    fxidOrderedFlightNumberLabel.setText("Flight Number: " + cateringOrder.getFlightId());
                    OldDeliveryTime = cateringOrder.getDeliveryDate();
                    fxidOrderedDeliveryDateLabel.setText("Delivery Date: " + cateringOrder.getDeliveryDate().toString());
                    fxidOrderedDeliveryTimeLabel.setText("Delivery Time: " + cateringOrder.getDeliveryTime().toString());
                    fxidHiddenAnchorPane.setVisible(true);
                    return;

                }
            }
        }
    }

    @javafx.fxml.FXML
    public void submitDelayRequestButton(ActionEvent actionEvent) {
        if (fxidDelayDeliveryTimeMinuteComboBox.getValue() == null || fxidDelayDeliveryTimeHourComboBox.getValue() == null ||
                fxidDelayDeliveryDateDatePicker.getValue() == null
        ) {
            AlertGenerator.showAlert("Error", "Please fill all the fields");
            return;
        }
        if(fxidDelayDeliveryDateDatePicker.getValue().isBefore(LocalDate.now()) || fxidDelayDeliveryDateDatePicker.getValue().isBefore(OldDeliveryTime)){
            AlertGenerator.showAlert("Error", "Delay Delivery Time Can't be past Time or before Old Delivery Time");
            return;
        }
        LocalTime selectedNewTime = LocalTime.of(fxidDelayDeliveryTimeHourComboBox.getValue(), fxidDelayDeliveryTimeMinuteComboBox.getValue());
        for(Object o : selectedCateringOrder) {
            if (o instanceof CateringOrder cateringOrder) {
                if (cateringOrder.getOrderId() == selectedCateringOrderId) {
                    cateringOrder.setDeliveryDate(fxidDelayDeliveryDateDatePicker.getValue());
                    cateringOrder.setDeliveryTime(selectedNewTime);
                    cateringOrder.setDelay(true);
                    loggedInUser.submitFlightDelayRequest(selectedCateringOrder);

                    AlertGenerator.showAlert("Success", "Delay Order has been submitted");
                    fxidHiddenAnchorPane.setVisible(false);
                    fxidOrderIdTextField.clear();
                    return;
                }
            }
        }
    }



    //sideBar Buttons
    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/airline_representative/trackOrderView.fxml", loggedInUser);
    }


    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/createCateringOrderView.fxml",
                loggedInUser
        );
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
                "/airline_representative/payBillView.fxml",
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