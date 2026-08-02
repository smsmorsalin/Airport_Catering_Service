package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

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
    @javafx.fxml.FXML
    private TableColumn<OrderItem, String> TableColOrderedMealItemNumber;

    private AirlineRepresentative loggedInUser;
    private int selectedOrderId;
    private ArrayList<Object> cateringOrderList;
    private ArrayList<String> selectedOrderedItemIdList;
    private ArrayList<Object> readOrderedItemList;
    private CateringOrder selectedCateringOrder;
    @javafx.fxml.FXML
    private TextField fxidItemNumberFromTable;

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

        TableColOrderedMealItemNumber.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("itemId") );
        TableColOrderedMealMealName.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("mealName") );
        TableColOrderedMealQuantity.setCellValueFactory( new PropertyValueFactory<OrderItem, Integer>("quantity") );
    }

    @javafx.fxml.FXML
    public void loadOrderedDataToTable(ActionEvent actionEvent) {
        orderedMealTableviewFxid.getItems().clear();
        try{
            selectedOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
        }

        cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        if (cateringOrderList.isEmpty()) {
            AlertGenerator.showAlert("Error", "No catering orders Exist.");
            return;
        }

        for (Object obj : cateringOrderList) {
            if  (obj instanceof CateringOrder cateringOrder) {
                if (cateringOrder.getOrderId() == selectedOrderId) {
                    if(cateringOrder.getAirlineId().equals(loggedInUser.getAirlineId())) {
                        if (!cateringOrder.getStatus().equals("Pending")) {
                            AlertGenerator.showAlert("Error", "Order is processing can't modify");
                            fxidHiddenMainAnchorPane.setVisible(false);
                            return;
                        }
                        selectedCateringOrder = cateringOrder;
                        selectedOrderedItemIdList = cateringOrder.getOrderItemIds();
                        readOrderedItemList = BinaryFileUtility.readObjects("OrderItem.bin");
                        for(Object obj2 : readOrderedItemList) {
                            if(obj2 instanceof OrderItem orderItem) {
                                if (selectedOrderedItemIdList.contains(orderItem.getItemId())) {
                                    orderedMealTableviewFxid.getItems().add(orderItem);
                                }
                            }
                        }
                        fxidHiddenMainAnchorPane.setVisible(true);
                        return;
                    }
                    AlertGenerator.showAlert("error", "order doesn't belong to your airline");
                }
            }
        }
        AlertGenerator.showAlert("error", "Order doesn't exist.");
        fxidHiddenMainAnchorPane.setVisible(false);

    }

    @javafx.fxml.FXML
    public void editMealButton(ActionEvent actionEvent) {
        //if type and select any item number fxidItemNumberFromTable if exist in table then sent to combobox and allow to select the quantity
        //if quantity select 0 then iteam will be deleted
    }

    @javafx.fxml.FXML
    public void SaveIndividualMealChangeButton(ActionEvent actionEvent) {
        //save edited meal into OrderItem.bin file and and in table updated version
    }

    @javafx.fxml.FXML
    public void modifyOrderButton(ActionEvent actionEvent) {
        //call loggedInUser.modifyCateringOrder(int orderId, ArrayList<String> orderItemIds) to save the changes.
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