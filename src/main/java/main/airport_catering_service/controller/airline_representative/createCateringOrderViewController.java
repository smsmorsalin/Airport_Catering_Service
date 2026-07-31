package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;

import java.io.IOException;
import java.util.ArrayList;

public class createCateringOrderViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> fxidDeliveryTimeHourComboBox;
    @javafx.fxml.FXML
    private DatePicker fxidFlightDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Meal> TableViewMeal;
    @javafx.fxml.FXML
    private TextField fxidDeliveryLocationTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fxidDeliveryTimeMinuteComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> fxidDepartureTimeHourComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> fxidDepartureTimeMinuteComboBox;
    @javafx.fxml.FXML
    private TextField mealQuantityTextField;
    @javafx.fxml.FXML
    private TextField fxidFlightNumberTextField;
    @javafx.fxml.FXML
    private ComboBox<String> mealListComboBox;
    @javafx.fxml.FXML
    private TableColumn<Meal, String> tableColMealName;
    @javafx.fxml.FXML
    private TableColumn<Meal, Integer> tableColMealQuantity;

    ArrayList<Meal> tempMealList;
    ArrayList<OrderItem> tempOrderItemList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addMealButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void placeCateringOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlTruckOrder(actionEvent);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarPayInvoiceButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlPayBill(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarConfirmDeliveryButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlConfirmDelivery(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFlightDelayButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlFlightDelay(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarCancelOrderButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlCancelOrder(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOrderHistoryButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlOrderHistory(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) throws IOException {
        AirlineRepresentative.renderFxmlModifyOrder(actionEvent);
    }
}