package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class PaymentHistoryViewController
{
    @javafx.fxml.FXML
    private TextField invoiceIdTextField;
    @javafx.fxml.FXML
    private Button exportBtn;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private Button viewPaymentBtn;
    @javafx.fxml.FXML
    private Button receiptBtn;
    @javafx.fxml.FXML
    private TableColumn methodColumn;
    @javafx.fxml.FXML
    private Button resetBtn;
    @javafx.fxml.FXML
    private TextField airlineTextField;
    @javafx.fxml.FXML
    private TableView paymentTable;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private ComboBox paymentStatusComboBox;
    @javafx.fxml.FXML
    private Button searchPaymentBtn;
    @javafx.fxml.FXML
    private TableColumn invoiceColumn;
    @javafx.fxml.FXML
    private ComboBox paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn paymentIdColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ResetOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarPaymentHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DownloadReceiptOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPDFOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewPaymentOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
    }
}