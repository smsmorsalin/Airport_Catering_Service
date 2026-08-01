package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Flight;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class createCateringOrderViewController implements UserReceiver
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

    private AirlineRepresentative loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof AirlineRepresentative airlineRepresentative) {
            this.loggedInUser = airlineRepresentative;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    ArrayList<Object> readMealList;

    @javafx.fxml.FXML
    public void initialize() {

        readMealList = BinaryFileUtility.readObjects("Meal.bin");

        if (readMealList == null) {
            readMealList = new ArrayList<>();
        }

        mealListComboBox.getItems().clear();

        for (Object mealObject : readMealList) {
            if (mealObject instanceof Meal meal) {
                mealListComboBox.getItems().add(meal.getMealName());
            }
        }

        fxidDeliveryTimeHourComboBox.getItems().clear();
        fxidDepartureTimeHourComboBox.getItems().clear();

        for (int hour = 0; hour < 24; hour++) {
            fxidDeliveryTimeHourComboBox.getItems().add(hour);
            fxidDepartureTimeHourComboBox.getItems().add(hour);
        }

        fxidDeliveryTimeMinuteComboBox.getItems().clear();
        fxidDepartureTimeMinuteComboBox.getItems().clear();

        for (int minute = 0; minute < 60; minute++) {
            fxidDeliveryTimeMinuteComboBox.getItems().add(minute);
            fxidDepartureTimeMinuteComboBox.getItems().add(minute);
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

        String selectedMealName = mealListComboBox.getValue();

        if (selectedMealName == null) {
            AlertGenerator.showAlert("Warning", "Please select a meal.");
            return;
        }

        String quantityText = mealQuantityTextField.getText().trim();

        if (quantityText.isEmpty()) {
            AlertGenerator.showAlert("Warning", "Please enter the meal quantity.");
            return;
        }

        int quantity;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Warning", "Meal quantity must be a valid number.");
            return;
        }

        if (quantity <= 0) {
            AlertGenerator.showAlert("Warning", "Meal quantity must be greater than zero.");
            return;
        }

        Meal selectedMeal = null;

        for (Object object : readMealList) {
            if (object instanceof Meal meal
                    && meal.getMealName().equals(selectedMealName)) {

                selectedMeal = meal;
                break;
            }
        }

        if (selectedMeal == null) {
            AlertGenerator.showAlert("Error", "The selected meal was not found.");
            return;
        }

        // Prevent duplicate meals
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getMealName().equals(selectedMealName)) {
                AlertGenerator.showAlert("Warning", "This meal has already been added.");
                return;
            }
        }

        String itemId = databaseAccessor.generateNewUniqueId(
                "OrderItem.bin",
                "itemId",
                "S"
        );

        OrderItem newOrderItem = new OrderItem(itemId, selectedMeal, quantity);

        orderItemList.add(newOrderItem);

        TableViewMeal.getItems().setAll(orderItemList);

        mealQuantityTextField.clear();
        mealListComboBox.setValue(null);

    }

    @javafx.fxml.FXML
    public void placeCateringOrderButton(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "No logged-in airline representative was found.");
            return;
        }

        String flightId = fxidFlightNumberTextField.getText().trim();
        String deliveryLocation = fxidDeliveryLocationTextField.getText().trim();
        LocalDate flightDate = fxidFlightDateDatePicker.getValue();
        Integer departureHour = fxidDepartureTimeHourComboBox.getValue();
        Integer departureMinute = fxidDepartureTimeMinuteComboBox.getValue();
        Integer deliveryHour = fxidDeliveryTimeHourComboBox.getValue();
        Integer deliveryMinute = fxidDeliveryTimeMinuteComboBox.getValue();

        if (flightId.isEmpty() || deliveryLocation.isEmpty() || flightDate == null || departureHour == null
                || departureMinute == null || deliveryHour == null || deliveryMinute == null) {
            AlertGenerator.showAlert("Error", "Please fill in all the fields.");
            return;
        }

        if (orderItemList.isEmpty()) {
            AlertGenerator.showAlert("Warning", "Please add at least one meal.");
            return;
        }

        if (flightDate.isBefore(LocalDate.now())) {
            AlertGenerator.showAlert("Warning", "Please enter today or a future date.");
            return;
        }

        boolean flightExists = Flight.checkFlightIdExists(flightId);

        if (!flightExists) {
            AlertGenerator.showAlert("Warning", "The flight number you entered is not valid."
            );
            return;
        }

        LocalTime departureTime = LocalTime.of(departureHour, departureMinute);
        LocalTime deliveryTime = LocalTime.of(deliveryHour, deliveryMinute);

        if (!deliveryTime.isBefore(departureTime)) {
            AlertGenerator.showAlert("Warning", "Delivery time must be before the departure time.");
            return;
        }

        boolean orderCreated =
                loggedInUser.createCateringOrder(
                        flightId,
                        deliveryLocation,
                        flightDate,
                        deliveryTime
                );

        if (orderCreated) {
            AlertGenerator.showAlert(
                    "Success",
                    "Catering order placed successfully."
            );

            fxidFlightNumberTextField.clear();
            fxidDeliveryLocationTextField.clear();
            fxidFlightDateDatePicker.setValue(null);

            fxidDepartureTimeHourComboBox.setValue(null);
            fxidDepartureTimeMinuteComboBox.setValue(null);

            fxidDeliveryTimeHourComboBox.setValue(null);
            fxidDeliveryTimeMinuteComboBox.setValue(null);

            mealListComboBox.setValue(null);
            mealQuantityTextField.clear();

            orderItemList.clear();
            TableViewMeal.getItems().clear();
        }

    }


    //sideBar buttons
    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/airline_representative/trackOrderView.fxml",
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