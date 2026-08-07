package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.CateringOrder;
import nonuser.Invoice;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class orderHistoryViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableColOrderStatus;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, Integer> tableColOrderId;
    @javafx.fxml.FXML
    private TableView<CateringOrder> fxidTableViewOrderHistory;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableColFlightNumber;
    @javafx.fxml.FXML
    private DatePicker fxidDateToDatePicker;
    @javafx.fxml.FXML
    private DatePicker fxidDateFromDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableColOrderDate;

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
        tableColOrderId.setCellValueFactory(new PropertyValueFactory<CateringOrder, Integer>("orderId"));
        tableColFlightNumber.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("FlightId"));
        tableColOrderDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("OrderDate"));
        tableColOrderStatus.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("Status"));

    }

    @javafx.fxml.FXML
    public void filterAndLoadDataInTableButton(ActionEvent actionEvent) {
        if(fxidDateFromDatePicker.getValue() == null || fxidDateToDatePicker.getValue() == null) {
            AlertGenerator.showAlert("Error", "Please select a date from the table.");
            return;
        }
        if(fxidDateFromDatePicker.getValue().isAfter(fxidDateToDatePicker.getValue())) {
            AlertGenerator.showAlert("Error", "from date will be before from to date.");
            return;
        }
        ArrayList<CateringOrder> orderList = loggedInUser.viewOrderHistory(fxidDateFromDatePicker.getValue(), fxidDateToDatePicker.getValue());
        if (orderList.isEmpty()) {
            AlertGenerator.showAlert("Error", "No catering orders found.");
            return;
        }
        for (CateringOrder cateringOrder : orderList) {
            fxidTableViewOrderHistory.getItems().add(cateringOrder);
        }
    }



    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/truckOrderView.fxml",
                loggedInUser
        );
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