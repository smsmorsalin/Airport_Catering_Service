package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.DispatchCoordinator;

import java.io.IOException;


public class assignTruckController
{
    @javafx.fxml.FXML
    private TableColumn driverIdTableviewColumn;
    @javafx.fxml.FXML
    private Text driverSelectionText;
    @javafx.fxml.FXML
    private Label assignmentIdLabel;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private Label flightNumberLabel;
    @javafx.fxml.FXML
    private TextField driverSelectionTextfield;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private Text truckSelectionText;
    @javafx.fxml.FXML
    private Label driverNameLabel;
    @javafx.fxml.FXML
    private TableColumn truckIdTableviewColumn;
    @javafx.fxml.FXML
    private Label deliveryscheduleLabel;
    @javafx.fxml.FXML
    private TextField truckSelectionTextfield;
    @javafx.fxml.FXML
    private TableColumn driverNameTableviewColumn;
    @javafx.fxml.FXML
    private Label truckIdLabel;
    @javafx.fxml.FXML
    private TableColumn truckNumberTableviewColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monitorDeliveryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleDeliveryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void assignTruckButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void packageOrderButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void receiveDispatchRequestButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageDeliveryDelayButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateDispatchReportButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void emergencyDeliveryButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {
    }
}