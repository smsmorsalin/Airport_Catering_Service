package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class receiveDispatchRequestController
{
    @javafx.fxml.FXML
    private TableColumn dispatchStatusTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn flightNumberTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdTableviewColumn;
    @javafx.fxml.FXML
    private Text dispatchNoteText;
    @javafx.fxml.FXML
    private TableColumn deliveryTimeTableviewColumn;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn dispatchRequestIdTableviewColumn;
    @javafx.fxml.FXML
    private TextField dispatchNoteTextfield;
    @javafx.fxml.FXML
    private TableColumn deliveryLocationTableviewColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOnACtion(ActionEvent actionEvent) {
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
}