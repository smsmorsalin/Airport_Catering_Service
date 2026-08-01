package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class dashboardViewController implements UserReceiver {
    @javafx.fxml.FXML
    private Button seePendingDeliverysButton;
    @javafx.fxml.FXML
    private Label totalOrdersCountLabelFxid;
    @javafx.fxml.FXML
    private Label pendingDeliverysCountLabelFxid;
    @javafx.fxml.FXML
    private Label welcomeMessageFxid;
    @javafx.fxml.FXML
    private Button seePendingPaymentsButton;
    @javafx.fxml.FXML
    private Label pendingPaymentCountLabelFxid;
    @javafx.fxml.FXML
    private Button seeTotalOrderHistory;

    private AirlineRepresentative loggedInUser;

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

    }

    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/airline_representative/trackOrderView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/createCateringOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/dashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarPayInvoiceButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/payBillView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarLogoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/confirmDeliveryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/flightDelayView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarCancelOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/cancelOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/orderHistoryView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/modifyOrderView.fxml",
                loggedInUser
        );
    }
}