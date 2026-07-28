package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class FinanceReportsViewController
{
    @javafx.fxml.FXML
    private Label outstandingLabel;
    @javafx.fxml.FXML
    private TableView financialReportTable;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn profitColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn paymentColumn;
    @javafx.fxml.FXML
    private TableColumn revenueColumn;
    @javafx.fxml.FXML
    private Label costLabel;
    @javafx.fxml.FXML
    private Label profitLabel;
    @javafx.fxml.FXML
    private TableColumn costColumn;
    @javafx.fxml.FXML
    private Label revenueLabel;
    @javafx.fxml.FXML
    private ComboBox reportTypeComboBox;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private Button exportPDFButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sidebarFinalcialReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPDFOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }
}