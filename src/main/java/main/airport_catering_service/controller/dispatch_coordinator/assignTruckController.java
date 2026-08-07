package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import nonuser.DriverDetails;
import nonuser.PurchaseRequest;
import user.DispatchCoordinator;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.util.ArrayList;


public class assignTruckController implements UserReceiver
{
    @javafx.fxml.FXML
    private TableColumn <DriverDetails,Integer>driverIdTableviewColumn;
    @javafx.fxml.FXML
    private Text driverSelectionText;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TextField driverSelectionTextfield;
    @javafx.fxml.FXML
    private TableView <DriverDetails> tableView;
    @javafx.fxml.FXML
    private Text truckSelectionText;
    @javafx.fxml.FXML
    private TableColumn <DriverDetails,Integer>truckIdTableviewColumn;
    @javafx.fxml.FXML
    private TextField truckSelectionTextfield;
    @javafx.fxml.FXML
    private TableColumn <DriverDetails,Integer>truckNumberTableviewColumn;

    ArrayList<Object> DriverDetailsList;



    private DispatchCoordinator loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof DispatchCoordinator dispatchCoordinator){
            loggedInUser = dispatchCoordinator;
            return;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
        tableView.getItems().clear();

        //int truckID, int driverID, int truckNumber
//        DriverDetails newD = new DriverDetails(1, 100, 69);
//        DriverDetails newD2 = new DriverDetails(2, 101, 68);
//        DriverDetails newD3 = new DriverDetails(3, 102, 67);
//        DriverDetails newD4 = new DriverDetails(4, 103, 66);
//        BinaryFileUtility.writeObjects("DriverDetails.bin", newD);
//        BinaryFileUtility.writeObjects("DriverDetails.bin", newD2);
//        BinaryFileUtility.writeObjects("DriverDetails.bin", newD3);
//        BinaryFileUtility.writeObjects("DriverDetails.bin", newD4);

        truckIdTableviewColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails,Integer>( "truckID"));
        driverIdTableviewColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails,Integer>("driverID"));
        truckNumberTableviewColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails,Integer>("truckNumber"));

        DriverDetailsList = BinaryFileUtility.readObjects("DriverDetails.bin");

        for (Object obj : DriverDetailsList){
            if (obj instanceof DriverDetails driverDetails){
                    tableView.getItems().add(driverDetails);
                }

        }

    }

    @javafx.fxml.FXML
    public void monitorDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderMonitorDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void scheduleDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderScheduleDelivery(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void assignTruckButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderAssignTruck(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderPackageOrder(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderReceiveDispatchRequest(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderManageDeliveryDelay(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderGenerateDispatchReport(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent) {
        DispatchCoordinator.renderEmergencyDelivery(actionEvent,loggedInUser);
    }


    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {

        if ( orderIdTextfield.getText().trim().isEmpty()
                || driverSelectionTextfield.getText().trim().isEmpty()
                || truckSelectionTextfield.getText().trim().isEmpty()) {

            AlertGenerator.showAlert("Invalid Input", "All text fields must be filled.");
            return;
        }

        int orderId, driverId, truckId;

        try {
            orderId = Integer.parseInt(orderIdTextfield.getText().trim());
            driverId = Integer.parseInt(driverSelectionTextfield.getText().trim());
            truckId = Integer.parseInt(truckSelectionTextfield.getText().trim());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Order ID, Driver ID, and Truck ID must be integers.");
            return;
        }

        if (orderId <= 0 || driverId <= 0 || truckId <= 0) {
            AlertGenerator.showAlert("Invalid Input", "IDs must be greater than 0.");
            return;
        }

        for (DriverDetails d : tableView.getItems()){
            if(d.getTruckID() == truckId && d.getDriverID() == driverId){
                boolean b = loggedInUser.AssignDriverDetails(truckId, driverId, d.getTruckNumber(), orderId);
                AlertGenerator.showAlert("Success", "succesfully Assgin truck deliver boy");
                tableView.getItems().remove(d);
                return;
            }
        }

    }
}