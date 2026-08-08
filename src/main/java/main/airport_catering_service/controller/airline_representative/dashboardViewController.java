package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class dashboardViewController implements UserReceiver {
    @javafx.fxml.FXML
    private Label totalOrdersCountLabelFxid;
    @javafx.fxml.FXML
    private Label welcomeMessageFxid;

    private AirlineRepresentative loggedInUser;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableCol_orderDate;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableCol_deliveryDate;
    @javafx.fxml.FXML
    private TableView<CateringOrder> tableView;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableCol_flightId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, Integer> tableCol_orderId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableCol_status;
    @javafx.fxml.FXML
    private Label pendingOrderCountLabelFxid;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof AirlineRepresentative airlineRepresentative) {
            this.loggedInUser = airlineRepresentative;
            welcomeMessageFxid.setText("Welcome "+ loggedInUser.getFullName());
            loadDashboardData();
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    public void loadDashboardData(){
        int totalOrderCount = 0;
        int pendingOrderCount = 0;

        tableView.getItems().clear();
        tableCol_deliveryDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("deliveryDate"));
        tableCol_flightId.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("FlightId"));
        tableCol_orderId.setCellValueFactory(new PropertyValueFactory<CateringOrder, Integer>("orderId"));
        tableCol_status.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("Status"));
        tableCol_orderDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("orderDate"));

        ArrayList<Object> cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for (Object cateringOrder : cateringOrderList) {
            if (cateringOrder instanceof CateringOrder c) {
                if(c.getAirlineId().equals(loggedInUser.getAirlineId())){
                    tableView.getItems().add(c);
                    totalOrderCount++;
                    if(c.getStatus().equals("Pending")){
                        pendingOrderCount++;
                    }
                }
            }
        }
        totalOrdersCountLabelFxid.setText(Integer.toString(totalOrderCount));
        pendingOrderCountLabelFxid.setText(Integer.toString(pendingOrderCount));
    }

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void sideBarTrackOrderButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/airline_representative/truckOrderView.fxml",
                loggedInUser);
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
    public void sideBarLogoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
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