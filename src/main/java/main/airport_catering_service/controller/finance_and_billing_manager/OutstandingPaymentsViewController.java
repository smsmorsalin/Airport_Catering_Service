package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class OutstandingPaymentsViewController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn dueDateColumn;
    @javafx.fxml.FXML
    private ComboBox invoiceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private TableColumn overdueColumn;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Label totalDueLabel;
    @javafx.fxml.FXML
    private TableView outstandingInvoiceTable;
    @javafx.fxml.FXML
    private TableColumn invoiceIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sidebarOutstandingPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }
}