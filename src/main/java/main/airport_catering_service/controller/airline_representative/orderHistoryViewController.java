package main.airport_catering_service.controller.airline_representative;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import utility.SceneSwitchingHelper;

public class orderHistoryViewController
{
    @javafx.fxml.FXML
    private ComboBox fxidOrderStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn tableColInvoiceid;
    @javafx.fxml.FXML
    private TableColumn tableColOrderStatus;
    @javafx.fxml.FXML
    private TableColumn tableColOrderId;
    @javafx.fxml.FXML
    private TableColumn tableColPaymentStatus;
    @javafx.fxml.FXML
    private TableView fxidTableViewOrderHistory;
    @javafx.fxml.FXML
    private TableColumn tableColFlightNumber;
    @javafx.fxml.FXML
    private DatePicker fxidDateToDatePicker;
    @javafx.fxml.FXML
    private TextField fxidFlightNumberTextField;
    @javafx.fxml.FXML
    private DatePicker fxidDateFromDatePicker;
    @javafx.fxml.FXML
    private TableColumn tableColOrderDate;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void filterAndLoadDataInTableButton(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void sideBarModifyOrderButton(ActionEvent actionEvent) {
    }
}