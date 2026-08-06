package main.airport_catering_service.controller.catering_operations_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.CateringOrder;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class reviewOrderController implements UserReceiver
{
    @javafx.fxml.FXML
    private TextField fxidViewDetailsOrderIdTextField;
    @javafx.fxml.FXML
    private Label fxidShowOrderStatusLabel;
    @javafx.fxml.FXML
    private TableView<CateringOrder> fxidTableViewRivewCateringOrders;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, Integer> tableColOrderId;
    @javafx.fxml.FXML
    private Label fxidShowOrderIdLabel;
    @javafx.fxml.FXML
    private Label fxidShowFlightNumberLabel;
    @javafx.fxml.FXML
    private Label fxidShowAirlineNamelabel;
    @javafx.fxml.FXML
    private AnchorPane fxidHiddenAnchorPane;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableColOrderStatus;
    @javafx.fxml.FXML
    private Button fxidGoForApproveOrRejectOrderLabel;
    @javafx.fxml.FXML
    private Label fxidShowDepartureDateLabel;

    private CateringOperationsManager loggedInUser;
    CateringOrder cateringOrder;

    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableColFlighId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, String> tableColAirlineId;
    @javafx.fxml.FXML
    private TableColumn<CateringOrder, LocalDate> tableColDeliveryDate;


    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }

    }

    @javafx.fxml.FXML
    public void initialize() {
        fxidHiddenAnchorPane.setVisible(false);

        tableColAirlineId.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("airlineId"));
        tableColDeliveryDate.setCellValueFactory(new PropertyValueFactory<CateringOrder, LocalDate>("deliveryDate"));
        tableColFlighId.setCellValueFactory(new PropertyValueFactory<CateringOrder, String>("FlightId"));
        tableColOrderId.setCellValueFactory(new PropertyValueFactory<CateringOrder, Integer>("orderId"));

        ArrayList<Object> cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for (Object cateringOrder : cateringOrderList) {
            if (cateringOrder instanceof CateringOrder c) {
                fxidTableViewRivewCateringOrders.getItems().add(c);
            }
        }
    }

    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        if (fxidViewDetailsOrderIdTextField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter the order ID.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        try{
            Integer.parseInt(fxidViewDetailsOrderIdTextField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter Integer Order id.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        cateringOrder = CateringOrder.findById(Integer.parseInt(fxidViewDetailsOrderIdTextField.getText()));
        if (cateringOrder == null) {
            AlertGenerator.showAlert("Error", "Invalid Order ID.");
            fxidHiddenAnchorPane.setVisible(false);
            return;
        }
        fxidShowOrderIdLabel.setText("Order ID: "+ cateringOrder.getOrderId());
        fxidShowFlightNumberLabel.setText("Flight ID: "+ cateringOrder.getFlightId());
        fxidShowAirlineNamelabel.setText("Airline ID: "+ cateringOrder.getAirlineId());
        fxidShowDepartureDateLabel.setText("Delivery Date: "+ cateringOrder.getDeliveryDate());
        fxidShowOrderStatusLabel.setText("Order Status: "+ cateringOrder.getStatus());
        fxidHiddenAnchorPane.setVisible(true);

    }

    @javafx.fxml.FXML
    public void goForApproveOrRejectOrderButton(ActionEvent actionEvent) {
        loggedInUser.reviewCateringOrder(actionEvent, cateringOrder.getOrderId(), loggedInUser);

    }


    //side bar
    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/emergencyIssueView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarApproveOrRejectOrdersButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/approveOrRejectOrderView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/businessDashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/operationalReportView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarBusinessDashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/businessDashboardView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/monitorProductionView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/deliveryMonitoringView.fxml",
                loggedInUser
        );
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent,
                "/catering_operations_manager/inventoryStatusView.fxml",
                loggedInUser
        );
    }
}