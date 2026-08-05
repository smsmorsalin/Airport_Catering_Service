package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.CostRecord;
import nonuser.FinancialReport;
import nonuser.Invoice;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FinanceReportsViewController implements UserReceiver
{
    private static final String COST_FILE = "CostRecord.bin";
    private static final String INVOICE_FILE = "Invoice.bin";
    @javafx.fxml.FXML
    private Label outstandingLabel;
    @javafx.fxml.FXML
    private TableView<FinancialReport> financialReportTable;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> profitColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> paymentColumn;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> revenueColumn;
    @javafx.fxml.FXML
    private Label costLabel;
    @javafx.fxml.FXML
    private Label profitLabel;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,Integer> costColumn;
    @javafx.fxml.FXML
    private Label revenueLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport, LocalDate> dateColumn;

    private FinanceAndBillingManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FinanceAndBillingManager financeAndBillingManager){
            this.loggedInUser = financeAndBillingManager;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        reportTypeComboBox.getItems().setAll("Daily Summary", "Revenue", "Profit and Loss", "Outstanding");
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getReportDate()));
        revenueColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getRevenue()));
        costColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getCost()));
        paymentColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().isPaymentReceive() ? 1 : 0));
        profitColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getProfit()));
    }

    @Deprecated
    public void sidebarFinancialReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReportOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        if(reportTypeComboBox.getValue() == null){
            AlertGenerator.showAlert("Wrong Input","Combo Box should be selected");
            return;
        }
        if(fromDatePicker.getValue() == null || toDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(fromDatePicker.getValue().isAfter(toDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(toDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invalid Input","End date can not be present date");
            return;
        }

        Map<LocalDate, Double> costsByDate = new HashMap<>();
        for (Object object : BinaryFileUtility.readObjects(COST_FILE)) {
            if (object instanceof CostRecord cost
                    && inRange(cost.getRecordDate(), fromDatePicker.getValue(), toDatePicker.getValue())) {
                costsByDate.merge(cost.getRecordDate(), cost.getTotal(), Double::sum);
            }
        }
        Map<LocalDate, Double> revenueByDate = new HashMap<>();
        Map<LocalDate, Integer> paidByDate = new HashMap<>();
        double outstanding = 0;
        for (Object object : BinaryFileUtility.readObjects(INVOICE_FILE)) {
            if (object instanceof Invoice invoice
                    && inRange(invoice.getDueDate(), fromDatePicker.getValue(), toDatePicker.getValue())) {
                revenueByDate.merge(invoice.getDueDate(), invoice.getTotalAmount(), Double::sum);
                if (invoice.isPaid()) {
                    paidByDate.merge(invoice.getDueDate(), 1, Integer::sum);
                } else {
                    outstanding += invoice.getTotalAmount();
                }
            }
        }
        ArrayList<FinancialReport> rows = new ArrayList<>();
        for (LocalDate date : costsByDate.keySet()) {
            int revenue = (int) Math.round(revenueByDate.getOrDefault(date, 0.0));
            int cost = (int) Math.round(costsByDate.get(date));
            FinancialReport report = new FinancialReport(
                    paidByDate.getOrDefault(date, 0) > 0, revenue, cost,
                    revenue - cost, reportTypeComboBox.getValue());
            report.setReportDate(date);
            rows.add(report);
        }
        rows.sort((first, second) -> second.getReportDate().compareTo(first.getReportDate()));
        financialReportTable.getItems().setAll(rows);
        double totalRevenue = rows.stream().mapToDouble(FinancialReport::getRevenue).sum();
        double totalCost = rows.stream().mapToDouble(FinancialReport::getCost).sum();
        revenueLabel.setText(String.format("%.2f", totalRevenue));
        costLabel.setText(String.format("%.2f", totalCost));
        profitLabel.setText(String.format("%.2f", totalRevenue - totalCost));
        outstandingLabel.setText(String.format("%.2f", outstanding));
        AlertGenerator.showAlert("Success", "Financial report generated successfully");
    }

    private boolean inRange(LocalDate date, LocalDate from, LocalDate to) {
        return date != null && !date.isBefore(from) && !date.isAfter(to);
    }

    private void switchTo (ActionEvent event, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(event, view, loggedInUser);
    }


    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/CalculateCostView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/GenerateInvoiceView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RecordPaymentView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/ProcessRefundView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/OutstandingPaymentsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/FinancialReportsView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/RevenueSummaryView.fxml",
                loggedInUser);
    }


    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/FinanceAndBillingManager/PaymentHistoryView.fxml",
                loggedInUser);
    }
}
