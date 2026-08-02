package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.OrderItem;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

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

        TableColOrderedMealItemNumber.setCellValueFactory( new PropertyValueFactory<>("itemId") );
        TableColOrderedMealMealName.setCellValueFactory( new PropertyValueFactory<>("mealName") );
        TableColOrderedMealQuantity.setCellValueFactory( new PropertyValueFactory<>("quantity") );
    }

    @javafx.fxml.FXML
    public void loadOrderedDataToTable(ActionEvent actionEvent) {
        try{
            selectedOrderId = Integer.parseInt(fxidOrderIdTextField.getText());
        }catch(NumberFormatException e){
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
        }
        //if the order exist and the object is pending the enable fxidHiddenMainAnchorPane and load iteam number, meal name, quantity in table
        //if don't can't find give generate alert with specific message


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