package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import nonuser.Meal;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.util.ArrayList;

public class modifyOrderViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidQuantity;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenMainAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenSubAnchorpanel;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, String> TableColOrderedMealMealName;
    @javafx.fxml.FXML
    private ComboBox<String> selectedMealComboBox;
    @javafx.fxml.FXML
    private TableView<OrderItem> orderedMealTableviewFxid;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Integer> TableColOrderedMealQuantity;
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;

    private AirlineRepresentative loggedInUser;
    private ArrayList<String> selectedOrderedItemIdList;
    private ArrayList<Object> readOrderedItemList;
    private CateringOrder selectedCateringOrder;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, String> TableColOrderedItemIdNumber;
    @javafx.fxml.FXML
    private TextField fxidItemIdFromTable;
    private ArrayList<Object> mealList;

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
        fxidHiddenSubAnchorpanel.setVisible(false);
        selectedMealComboBox.getItems().clear();

        TableColOrderedItemIdNumber.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("itemId") );
        TableColOrderedMealMealName.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("mealName") );
        TableColOrderedMealQuantity.setCellValueFactory( new PropertyValueFactory<OrderItem, Integer>("quantity") );

        mealList = BinaryFileUtility.readObjects("Meal.bin");
        for(Object obj : mealList){
            if (obj instanceof Meal meal){
                selectedMealComboBox.getItems().add(meal.getMealName());
            }
        }
    }

    @javafx.fxml.FXML
    public void loadOrderedDataOnAction(ActionEvent actionEvent) {
        orderedMealTableviewFxid.getItems().clear();
        selectedMealComboBox.getSelectionModel().clearSelection();
        selectedMealComboBox.setValue(null);
        selectedMealComboBox.setPromptText("Selected meal");

        int selectedOrderId = 0;
        orderedMealTableviewFxid.getItems().clear();
        try{
            selectedOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
            fxidHiddenMainAnchorPane.setVisible(false);
        }
        selectedCateringOrder = CateringOrder.findById(selectedOrderId);
        if (selectedCateringOrder == null) {
            AlertGenerator.showAlert("Error", "No catering orders Exist.");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }

        if (selectedCateringOrder.getOrderId() == selectedOrderId) {
            if(selectedCateringOrder.getAirlineId().equals(loggedInUser.getAirlineId())) {
                if (!selectedCateringOrder.getStatus().equals("Pending")) {
                    AlertGenerator.showAlert("Error", "Order is processing can't modify");
                    fxidHiddenMainAnchorPane.setVisible(false);
                    return;
                }
                selectedOrderedItemIdList = selectedCateringOrder.getOrderItemIds();

                readOrderedItemList = BinaryFileUtility.readObjects("OrderItem.bin");
                for(Object obj : readOrderedItemList) {
                    if(obj instanceof OrderItem orderItem) {
                        if (selectedOrderedItemIdList.contains(orderItem.getItemId())) {
                            orderedMealTableviewFxid.getItems().add(orderItem);
                        }
                    }
                }
                fxidHiddenMainAnchorPane.setVisible(true);
                return;
            }
            AlertGenerator.showAlert("error", "order doesn't belong to your airline");
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
        AlertGenerator.showAlert("error", "Order doesn't exist.");
        fxidHiddenMainAnchorPane.setVisible(false);
    }


    @javafx.fxml.FXML
    public void editItemButtonOnAction(ActionEvent actionEvent) {
        String selectedItemId = fxidItemIdFromTable.getText().trim();
        if(selectedItemId.isEmpty()){
            fxidHiddenSubAnchorpanel.setVisible(true);
            selectedMealComboBox.getSelectionModel().clearSelection();
            selectedMealComboBox.setValue(null);
            selectedMealComboBox.setPromptText("Selected meal");
            fxidQuantity.clear();

            return;
        }
        for(OrderItem orderItem : orderedMealTableviewFxid.getItems()) {
            if (orderItem.getItemId().equals(selectedItemId)) {
                fxidHiddenSubAnchorpanel.setVisible(true);
                selectedMealComboBox.setValue(orderItem.getMealName());
                fxidQuantity.setText(String.valueOf(orderItem.getQuantity()));
                return;
            }
        }
        AlertGenerator.showAlert("error", "Item doesn't exist.");
        fxidHiddenSubAnchorpanel.setVisible(false);



    }

    @javafx.fxml.FXML
    public void SaveIndividualMealChangeButton(ActionEvent actionEvent) {
        Meal newMeal = null, modifyMeal = null;
        try{
            Integer.parseInt(fxidQuantity.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("error", "Enter Integer Value in Quantity field.");
            return;
        }
        if(fxidItemIdFromTable.getText().isEmpty()){

            for(Object obj : mealList){
                if(obj instanceof Meal meal){
                    if(meal.getMealName().equals(selectedMealComboBox.getValue())){
                        newMeal = meal;
                        break;
                    }
                }
            }
            for(OrderItem orderItem2 : orderedMealTableviewFxid.getItems()) {
                if (orderItem2.getMealName().equals(selectedMealComboBox.getValue())) {
                    AlertGenerator.showAlert("Error", "Order Item Already Exist in table choose the Item Id to modify.");
                    return;
                }
            }
            OrderItem newOrderItem = new OrderItem(newMeal,Integer.parseInt(fxidQuantity.getText()));
            orderedMealTableviewFxid.getItems().add(newOrderItem);
            AlertGenerator.showAlert("success", "new Order Item has been saved.");
            return;

        }

        for(OrderItem orderItem : orderedMealTableviewFxid.getItems()) {
            if (orderItem.getItemId().equals(fxidItemIdFromTable.getText())) {
                if(Integer.parseInt(fxidQuantity.getText()) == 0){
                    orderedMealTableviewFxid.getItems().remove(orderItem);
                    AlertGenerator.showAlert("Success","Item deleted successfully.");
                    return;
                }

                for(Object obj : mealList){
                    if(obj instanceof Meal meal){
                        if(meal.getMealName().equals(selectedMealComboBox.getValue())){
                            modifyMeal = meal;
                            break;
                        }
                    }
                }
                orderedMealTableviewFxid.getItems().remove(orderItem);
                orderItem.setQuantity(Integer.parseInt(fxidQuantity.getText()));
                orderItem.setMeal(modifyMeal);
                orderedMealTableviewFxid.getItems().add(orderItem);
                AlertGenerator.showAlert("success", "new Order Item has been modified.");
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void modifyOrderButton(ActionEvent actionEvent) {
        ArrayList<OrderItem> writableOrderItems = new ArrayList<>();
        ArrayList<String> writableItemIds = new ArrayList<>();

        for (OrderItem orderItem : orderedMealTableviewFxid.getItems()) {
            writableOrderItems.add(orderItem);
            writableItemIds.add(orderItem.getItemId());
        }
        selectedCateringOrder.setOrderItemIds(writableItemIds);
        boolean isSaved = loggedInUser.modifyCateringOrder(selectedCateringOrder, writableOrderItems);
        if(isSaved){
            fxidHiddenMainAnchorPane.setVisible(false);
            return;
        }
    }




    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/airline_representative/truckOrderView.fxml",
                loggedInUser);
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

}