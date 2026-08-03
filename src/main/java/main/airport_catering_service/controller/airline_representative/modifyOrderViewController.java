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

        TableColOrderedItemIdNumber.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("itemId") );
        TableColOrderedMealMealName.setCellValueFactory( new PropertyValueFactory<OrderItem, String>("mealName") );
        TableColOrderedMealQuantity.setCellValueFactory( new PropertyValueFactory<OrderItem, Integer>("quantity") );
    }

    @javafx.fxml.FXML
    public void loadOrderedDataOnAction(ActionEvent actionEvent) {
        int selectedOrderId = 0;
        orderedMealTableviewFxid.getItems().clear();
        try{
            selectedOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
        }
        selectedCateringOrder = CateringOrder.findById(selectedOrderId);
        if (selectedCateringOrder == null) {
            AlertGenerator.showAlert("Error", "No catering orders Exist.");
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
        }
        AlertGenerator.showAlert("error", "Order doesn't exist.");
        fxidHiddenMainAnchorPane.setVisible(false);
    }


    @javafx.fxml.FXML
    public void editItemButtonOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void SaveIndividualMealChangeButton(ActionEvent actionEvent) {
        //save edited meal into OrderItem.bin file and in table updated version
    }

    @javafx.fxml.FXML
    public void modifyOrderButton(ActionEvent actionEvent) {
        //call loggedInUser.modifyCateringOrder(int orderId, ArrayList<String> orderItemIds) to save the changes.
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