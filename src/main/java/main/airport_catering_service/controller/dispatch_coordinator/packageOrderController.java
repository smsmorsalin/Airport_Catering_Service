package main.airport_catering_service.controller.dispatch_coordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import user.DispatchCoordinator;

import java.io.IOException;

public class packageOrderController
{
    @javafx.fxml.FXML
    private TableColumn packagingIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdTableviewColumn;
    @javafx.fxml.FXML
    private TableColumn completionTimeTableviewColumn;
    @javafx.fxml.FXML
    private Text orderIdText;
    @javafx.fxml.FXML
    private TextField orderIdTextfield;
    @javafx.fxml.FXML
    private TableColumn packagingTypeTableviewColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private Text packagingTypeText;
    @javafx.fxml.FXML
    private Text packagingNoteText;
    @javafx.fxml.FXML
    private ComboBox packagingTypeComboBox;
    @javafx.fxml.FXML
    private TextArea packagingNoteTextArea;

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
    public void airportCateringServiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        DispatchCoordinator.renderDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void searchAndShowButtonOnAction(ActionEvent actionEvent) {
    }
}