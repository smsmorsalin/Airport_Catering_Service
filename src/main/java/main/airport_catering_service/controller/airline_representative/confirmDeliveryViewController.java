package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.CateringOrder;
import user.AirlineRepresentative;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class confirmDeliveryViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidOrderIdTextField;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableCol_flightId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, Integer> tableCol_orderId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableCol_deliveryDate;
    @javafx.fxml.FXML
    private TableView<CateringOrder> tableView;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableCol_OrderDate;

    private AirlineRepresentative loggedInUser;
    ArrayList<Object> orderList;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof AirlineRepresentative airlineRepresentative) {
            this.loggedInUser = airlineRepresentative;
            loadTableView();
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    public void loadTableView()
    {
        orderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        if(orderList.isEmpty()){
            AlertGenerator.showAlert("Error", "No catering orders found.");
            return;
        }
        for(Object obj : orderList){
            if(obj instanceof CateringOrder c){
                if(c.getAirlineId().equals(loggedInUser.getAirlineId()) &&
                        (c.getStatus().equals("Approved") || c.getStatus().equals("Dispatch") || c
                                .getStatus().equals("Production") || c.getStatus().equals("Quality Inspection") )
                ){
                    tableView.getItems().add(c);
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        tableCol_deliveryDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("deliveryDate"));
        tableCol_flightId.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("FlightId"));
        tableCol_OrderDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("orderId"));
        tableCol_orderId.setCellValueFactory(new PropertyValueFactory<CateringOrder, Integer>("orderId"));
    }

    @javafx.fxml.FXML
    public void ConfirmDeliveryOrderButton(ActionEvent actionEvent) {
        try{
            Integer.parseInt(fxidOrderIdTextField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Invalid order ID.");
            return;
        }
        CateringOrder checkOrder = CateringOrder.findById(Integer.parseInt(fxidOrderIdTextField.getText()));
        if(checkOrder == null){
            AlertGenerator.showAlert("Error", "No order has been found.");
            return;
        }
        if(checkOrder.getStatus().equals("Dispatch")){
            checkOrder.setStatus("Delivered");
            CateringOrder remCat = loggedInUser.confirmCateringDelivery(checkOrder);
            if(remCat != null){
                tableView.getItems().remove(remCat);
                AlertGenerator.showAlert("Success", "Order status set to delivered.");
                return;
            }

        }
        else {
            AlertGenerator.showAlert("Error", "The Order is not Ready for delivery yet.");
            return;
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