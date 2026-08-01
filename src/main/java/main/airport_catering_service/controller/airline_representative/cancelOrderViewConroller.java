package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import nonuser.CateringOrder;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class cancelOrderViewConroller implements UserReceiver {
    @javafx.fxml.FXML
    private Text fxidDeliveryTime;
    @javafx.fxml.FXML
    private Text fxidFlightDate;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnochorPanel;
    @javafx.fxml.FXML
    private Text fxidDepartureTime;
    @javafx.fxml.FXML
    private Text fxidFlightNumber;
    @javafx.fxml.FXML
    private Text fxidDeliveryLocation;
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;

    private AirlineRepresentative loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof AirlineRepresentative airlineRepresentative) {
            this.loggedInUser = airlineRepresentative;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    private CateringOrder selectedCateringOrder;

    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void checkOrderButton(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert(
                    "error",
                    "No logged-in airline representative found."
            );
            return;
        }

        String orderIdText = fxidOrderIdTextField.getText().trim();

        if (orderIdText.isEmpty()) {
            AlertGenerator.showAlert(
                    "error",
                    "Please enter order ID."
            );
            return;
        }

        int orderId;

        try {
            orderId = Integer.parseInt(orderIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert(
                    "error",
                    "Order ID must be a number."
            );
            return;
        }

        ArrayList<Object> orderObjects =
                BinaryFileUtility.readObjects("CateringOrder.bin");

        if (orderObjects == null || orderObjects.isEmpty()) {
            AlertGenerator.showAlert(
                    "error",
                    "No catering order exists."
            );
            return;
        }

        selectedCateringOrder = null;

        for (Object object : orderObjects) {

            if (object instanceof CateringOrder cateringOrder
                    && cateringOrder.getOrderId() == orderId) {

                // The order exists, but it belongs to another user
                if (cateringOrder.getAirlineRepresentativeId()
                        != loggedInUser.getUserId()) {

                    AlertGenerator.showAlert(
                            "error",
                            "This order was not created by you."
                    );

                    fxidHiddenAnochorPanel.setVisible(false);
                    return;
                }

                selectedCateringOrder = cateringOrder;
                break;
            }
        }

        if (selectedCateringOrder == null) {
            AlertGenerator.showAlert(
                    "error",
                    "Order ID does not exist."
            );

            fxidHiddenAnochorPanel.setVisible(false);
            return;
        }

        // Load order information into the Label
        fxidFlightNumber.setText(selectedCateringOrder.getFlightId());
        fxidFlightDate.setText(selectedCateringOrder.getDeliveryDate().toString());
        fxidDeliveryTime.setText(selectedCateringOrder.getDeliveryTime().toString());
        fxidDeliveryLocation.setText(selectedCateringOrder.getDeliveryLocation());
        fxidDepartureTime.setText("Not available");
        fxidHiddenAnochorPanel.setVisible(true);

    }



    @javafx.fxml.FXML
    public void cancleTheOrderButton(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert(
                    "error",
                    "No logged-in airline representative found."
            );
            return;
        }

        if (selectedCateringOrder == null) {
            AlertGenerator.showAlert(
                    "error",
                    "Please check an order first."
            );
            return;
        }

        boolean isCancelled =
                loggedInUser.cancelCateringOrder(
                        selectedCateringOrder.getOrderId()
                );

        if (isCancelled) {
            fxidHiddenAnochorPanel.setVisible(false);
            fxidOrderIdTextField.clear();
            selectedCateringOrder = null;
        }
    }




    //sidebar buttons
    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/trackOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/createCateringOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/dashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarPayInvoiceButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/payBillView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/confirmDeliveryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/flightDelayView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/orderHistoryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/AirlineRepresentative/modifyOrderView.fxml",
                loggedInUser
        );
    }
}