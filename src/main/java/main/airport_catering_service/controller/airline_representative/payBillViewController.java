package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import nonuser.Invoice;
import nonuser.Payment;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

public class payBillViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenSubAnchorPane;
    @javafx.fxml.FXML
    private Label fxidPayableAmountLabel;
    @javafx.fxml.FXML
    private ComboBox<String> fxidPaymentMethodComboBox;
    @javafx.fxml.FXML
    private TextField fxidTransactionIdTextField;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenMainAnchorPane;
    @javafx.fxml.FXML
    private Label fxidInvoiceIdLabel;
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;

    private AirlineRepresentative loggedInUser;
    private int selectedOrderId;
    private Invoice selectedInvoice;

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
        fxidHiddenMainAnchorPane.setVisible(false);
        fxidHiddenSubAnchorPane.setVisible(false);
        fxidPaymentMethodComboBox.getItems().addAll("Bank", "Bkash", "Nagad", "Rocket", "Upay");


    }

    @javafx.fxml.FXML
    public void checkBillButton(ActionEvent actionEvent) {
        try {
            selectedOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Invalid order id.");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
        CateringOrder selectedCateringOrder = CateringOrder.findById(selectedOrderId);
        if(selectedCateringOrder == null) {
            AlertGenerator.showAlert("Error", "No order exists with that id.");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
        selectedInvoice = Invoice.searchInvoiceByOrderId(selectedOrderId);
        if(selectedInvoice == null) {
            AlertGenerator.showAlert("Error", "No Invoice generated with that id.\n try sometime later");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
        Payment payment = Payment.searchPaymentByOrderId(selectedOrderId);
        if(payment != null) {
            AlertGenerator.showAlert("message", "Already bill paid");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
        fxidHiddenMainAnchorPane.setVisible(true);
        fxidHiddenSubAnchorPane.setVisible(false);
        fxidInvoiceIdLabel.setText("Invoice ID: "+selectedInvoice.getInvoiceId());
        fxidPayableAmountLabel.setText(String.valueOf(selectedInvoice.getTotalAmount()));
    }

    @javafx.fxml.FXML
    public void goForPaymentButton(ActionEvent actionEvent) {
        fxidHiddenSubAnchorPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void payBillButton(ActionEvent actionEvent) {
        if (fxidPaymentMethodComboBox.getValue().isEmpty() || fxidTransactionIdTextField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Select a payment method and Enter transaction id.");
            return;
        }

        boolean check = loggedInUser.payCateringBill(selectedInvoice.getOrderId(),selectedInvoice.getInvoiceId(), fxidPaymentMethodComboBox.getValue(), fxidTransactionIdTextField.getText());
        if (check){
            AlertGenerator.showAlert("message", "Payment successful.");
            fxidHiddenMainAnchorPane.setVisible(false);
            fxidHiddenSubAnchorPane.setVisible(false);
        }
    }



    //side Bar Buttons
    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/truckOrderView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCreateCateringOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/createCateringOrderView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/confirmDeliveryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/flightDelayView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCancelOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/cancelOrderView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/orderHistoryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/modifyOrderView.fxml",
                loggedInUser);
    }
}