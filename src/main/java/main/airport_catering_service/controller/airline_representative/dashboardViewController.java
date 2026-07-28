package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import user.User;

import java.io.IOException;

public class dashboardViewController
{
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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarPayInvoiceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarLogoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCancelOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) {
    }
}