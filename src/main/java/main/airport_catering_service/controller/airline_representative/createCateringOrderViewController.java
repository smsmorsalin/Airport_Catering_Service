package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Flight;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.databaseAccessor;

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
    private TableView<OrderItem> TableViewMeal;
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
    private TableColumn<OrderItem, String> tableColMealName;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Integer> tableColMealQuantity;

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    ArrayList<Object> readMealList;

    @javafx.fxml.FXML
    public void initialize() {

        readMealList = BinaryFileUtility.readObjects("Meal.bin");

        if (readMealList == null) {
            readMealList = new ArrayList<>();
        }

        for (Object mealObject : readMealList) {
            if (mealObject instanceof Meal meal) {
                mealListComboBox.getItems().add(meal.getMealName());
            }
        }

        for (int i = 0; i < 24; i++) {
            fxidDeliveryTimeHourComboBox.getItems().add(i);
            fxidDepartureTimeHourComboBox.getItems().add(i);
        }

        for (int i = 0; i < 60; i++) {
            fxidDeliveryTimeMinuteComboBox.getItems().add(i);
            fxidDepartureTimeMinuteComboBox.getItems().add(i);
        }

        tableColMealName.setCellValueFactory(
                new PropertyValueFactory<>("mealName")
        );

        tableColMealQuantity.setCellValueFactory(
                new PropertyValueFactory<>("quantity")
        );
    }

    @javafx.fxml.FXML
    public void addMealButton(ActionEvent actionEvent) {

        if (mealListComboBox.getValue() == null) {
            AlertGenerator.showAlert(
                    "Warning",
                    "Please select a meal"
            );
            return;
        }

        String quantityText = mealQuantityTextField.getText().trim();

        if (quantityText.isEmpty()) {
            AlertGenerator.showAlert(
                    "Warning",
                    "Please enter the meal quantity"
            );
            return;
        }

        int quantity;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert(
                    "Warning",
                    "Meal quantity must be a number"
            );
            return;
        }

        if (quantity <= 0) {
            AlertGenerator.showAlert(
                    "Warning",
                    "Meal quantity must be greater than zero"
            );
            return;
        }

        String tempItemId =
                databaseAccessor.generateNewUniqueId(
                        "OrderItem.bin",
                        "itemId", "S"
                );

        Meal tempMeal = null;

        for (Object object : readMealList) {
            if (object instanceof Meal meal
                    && meal.getMealName().equals(mealListComboBox.getValue())) {

                tempMeal = meal;
                break;
            }
        }

        if (tempMeal == null) {
            AlertGenerator.showAlert(
                    "Error",
                    "The selected meal was not found"
            );
            return;
        }

        OrderItem newOrderItem =
                new OrderItem(tempItemId, tempMeal, quantity);

        orderItemList.add(newOrderItem);
        TableViewMeal.getItems().add(newOrderItem);

        mealQuantityTextField.clear();
        mealListComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void placeCateringOrderButton(ActionEvent actionEvent) {
        if (fxidFlightNumberTextField.getText().isEmpty() ||
                fxidDeliveryLocationTextField.getText().isEmpty() ||
                fxidFlightDateDatePicker.getValue() == null ||
                fxidDepartureTimeHourComboBox.getValue() == null ||
                fxidDepartureTimeMinuteComboBox.getValue() == null ||
                fxidDeliveryTimeMinuteComboBox.getValue() == null ||
                fxidDepartureTimeHourComboBox.getValue() == null
        ){
            AlertGenerator.showAlert("Error", "Please fill all the fields");
        }

        if (fxidFlightDateDatePicker.getValue().isBefore(LocalDate.now())) {
            AlertGenerator.showAlert("Warning", "Please enter a future date");
            return;
        }
        boolean checkFlightId = Flight.checkFlightIdExists(fxidFlightNumberTextField.getText());

        if(!checkFlightId){
            AlertGenerator.showAlert("Warning", "The flight number you entered is not valid");
            return;
        }
        //loginUser.CreateCateringOrder(String flightId, String deliveryLocation,
        // ArrayList<OrderItem> orderItems,
        // LocalDate deliveryDate, LocalTime deliveryTime, String status

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