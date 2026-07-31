package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class createCateringOrderViewController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDeliveryTimeHourComboBox;
    @javafx.fxml.FXML
    private DatePicker fxidFlightDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Meal> TableViewMeal;
    @javafx.fxml.FXML
    private TextField fxidDeliveryLocationTextField;
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDeliveryTimeMinuteComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDepartureTimeHourComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> fxidDepartureTimeMinuteComboBox;
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
        ArrayList<Object> readMealList;
        readMealList = BinaryFileUtility.readObjects("Meal.bin");

        for (Object mealObject : readMealList) {
            mealListComboBox.getItems().add(((Meal) mealObject).getMealName());
        }

        for (int i = 0; i < 24; i++){
            fxidDeliveryTimeHourComboBox.getItems().add(i);
            fxidDepartureTimeHourComboBox.getItems().add(i);
        }
        for (int i = 0; i < 60; i++){
            fxidDeliveryTimeMinuteComboBox.getItems().add(i);
            fxidDepartureTimeMinuteComboBox.getItems().add(i);
        }
    }

    @javafx.fxml.FXML
    public void addMealButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (fxidFlightDateDatePicker.getValue().isBefore(LocalDate.now())){
            alert.setTitle("Warning");
            alert.setContentText("Please select a future date");
            alert.showAndWait();
            return;
        }

        //if flightId not exist in flight.bin file generate an eror


    }

    @javafx.fxml.FXML
    public void placeCateringOrderButton(ActionEvent actionEvent) {
    }


    //sideBar buttons
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