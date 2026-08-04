package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.DispatchCoordinator;

import java.io.IOException;

public class manageDeliveryDelayController
{
    @javafx.fxml.FXML
    private Label revisedDeliveryTimeLabel;
    @javafx.fxml.FXML
    private TextField deliveryIdTextfield;
    @javafx.fxml.FXML
    private Label delayReasonLabel;
    @javafx.fxml.FXML
    private TextField delayReasonTextfield;
    @javafx.fxml.FXML
    private Text revisedDeliveryTimeText;
    @javafx.fxml.FXML
    private Label deliveryIdLabel;
    @javafx.fxml.FXML
    private Text deliveryIdText;
    @javafx.fxml.FXML
    private Text delayReasonText;
    @javafx.fxml.FXML
    private TextField revisedDeliveryTimeTextfield;

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

    @javafx.fxml.FXML
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent)throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {
    }
}