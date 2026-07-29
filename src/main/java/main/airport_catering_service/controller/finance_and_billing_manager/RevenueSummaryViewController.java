package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RevenueSummaryViewController
{
    @javafx.fxml.FXML
    private Label paidAmountLabel;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private Label totalRevenueLabel;
    @javafx.fxml.FXML
    private TableView revenueTable;
    @javafx.fxml.FXML
    private Label pendingAmountLabel;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private ComboBox airlineComboBox;
    @javafx.fxml.FXML
    private Label netRevenueLabel;
    @javafx.fxml.FXML
    private TableColumn paymentColumn;
    @javafx.fxml.FXML
    private TableColumn revenueColumn;
    @javafx.fxml.FXML
    private TableColumn netRevenueColumn;
    @javafx.fxml.FXML
    private Label refundAmountLabel;
    @javafx.fxml.FXML
    private Button exportButton;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableColumn orderColumn;
    @javafx.fxml.FXML
    private Button generateSummaryButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void GenerateSummaryOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarRevenueSummaryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPDFOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) {
    }
}