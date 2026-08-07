package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.CateringOrder;
import nonuser.CostRecord;
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

public class GenerateInvoiceViewController implements UserReceiver
{
    private static final String ORDER_FILE = "CateringOrder.bin";
    private static final String COST_FILE = "CostRecord.bin";
    private static final String INVOICE_FILE = "Invoice.bin";
    @javafx.fxml.FXML
    private Label packagingCostLabel;
    @javafx.fxml.FXML
    private Label rawMaterialCostLabel;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private Label summaryTotalAmountLabel;
    @javafx.fxml.FXML
    private Label productionCostLabel;
    @javafx.fxml.FXML
    private Label summaryAirlineNameLabel;
    @javafx.fxml.FXML
    private Label invoiceIdLabel;
    @javafx.fxml.FXML
    private Label summaryDateLabel;
    @javafx.fxml.FXML
    private Label summaryOrderLabel;
    @javafx.fxml.FXML
    private Label ingredientCostLabel;
    @javafx.fxml.FXML
    private DatePicker dueDatePicker;
    @javafx.fxml.FXML
    private TextField orderidTextField;
    @javafx.fxml.FXML
    private Label transportCostLabel;
    @javafx.fxml.FXML
    private Label operationCostLabel;
    @javafx.fxml.FXML
    private Label airlineNameLabel;
    @javafx.fxml.FXML
    private TextField billingAddressTextField;
    @javafx.fxml.FXML
    private Button verifyOrderButton;
    @javafx.fxml.FXML
    private Button generateInvoiceButton;

    private int selectedCateringOrderId;
    private ArrayList<Object> selectedObjectedList;
    @javafx.fxml.FXML
    private Label OrderIdLabel;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    private CateringOrder selectedCateringOrder;

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
        clearSummary();
    }

    @javafx.fxml.FXML
    public void generateinvoiceOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null || selectedCateringOrder == null) {
            AlertGenerator.showAlert("Invalid Input", "Verify an order first");
            return;
        }
        if (billingAddressTextField.getText().trim().isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Billing address should be filled");
            return;
        }
        if (dueDatePicker.getValue() == null
                || dueDatePicker.getValue().isBefore(LocalDate.now())) {
            AlertGenerator.showAlert("Invalid Input", "Select a valid future due date");
            return;
        }
        for (Object object : BinaryFileUtility.readObjects(INVOICE_FILE)) {
            if (object instanceof Invoice invoice
                    && invoice.getOrderId() == selectedCateringOrder.getOrderId()) {
                AlertGenerator.showAlert("Already Exists", "An invoice already exists for this order");
                return;
            }
        }
        CostRecord cost = findCostRecord(selectedCateringOrder.getOrderId());
        if (cost == null) {
            AlertGenerator.showAlert("Missing Cost", "Save a cost record before generating an invoice");
            return;
        }
        Invoice invoice = new Invoice(selectedCateringOrder.getOrderId(), cost.getTotal(), dueDatePicker.getValue(), false);
        if (!BinaryFileUtility.writeObjects(INVOICE_FILE, invoice)) {
            AlertGenerator.showAlert("Error", "Invoice could not be saved");
            return;
        }
        invoiceIdLabel.setText(invoice.getInvoiceId());
        summaryDateLabel.setText(invoice.getDueDate().toString());
        summaryTotalAmountLabel.setText(String.format("%.2f", invoice.getTotalAmount()));
        AlertGenerator.showAlert("Success", "Invoice generated successfully");
    }

    private CostRecord findCostRecord(int orderId) {
        CostRecord latest = null;
        for (Object object : BinaryFileUtility.readObjects(COST_FILE)) {
            if (object instanceof CostRecord cost && cost.getOrderId() == orderId
                    && (latest == null || cost.getRecordDate().isAfter(latest.getRecordDate()))) {
                latest = cost;
            }
        }
        return latest;
    }


    @javafx.fxml.FXML
    public void VerifyOrderOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        try{
            selectedCateringOrderId = Integer.parseInt(orderidTextField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("error", "Enter an integer Value");
            return;
        }
        selectedObjectedList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for(Object obj : selectedObjectedList){
            if (obj instanceof CateringOrder cateringOrder){
                if(cateringOrder.getOrderId() == selectedCateringOrderId){
                    if ("Cancelled".equalsIgnoreCase(cateringOrder.getStatus())
                            || "Canceled".equalsIgnoreCase(cateringOrder.getStatus())) {
                        AlertGenerator.showAlert("Error", "Order already cancelled");
                        return;
                    }
                    if ("Delivery".equalsIgnoreCase(cateringOrder.getStatus())
                            || "Delivered".equalsIgnoreCase(cateringOrder.getStatus())) {
                        AlertGenerator.showAlert("Error", "Order already delivered");
                        return;
                    }
                    if ("Rejected".equalsIgnoreCase(cateringOrder.getStatus())) {
                        AlertGenerator.showAlert("Error", "Order already rejected");
                        return;
                    }
                    ArrayList<Object> selectedInvoiceList = BinaryFileUtility.readObjects("Invoice.bin");

                    for (Object obj2 : selectedInvoiceList){
                        if (obj2 instanceof Invoice invoice){
                            if(invoice.getOrderId() == selectedCateringOrderId){
                                AlertGenerator.showAlert("error", "Already Invoice Generated");
                                return;
                            }
                        }
                    }
                    selectedCateringOrder = cateringOrder;
                    OrderIdLabel.setText("Order Id: " +cateringOrder.getOrderId());
                    orderStatusLabel.setText("Order Status: "+ cateringOrder.getStatus());
                    summaryOrderLabel.setText(String.valueOf(cateringOrder.getOrderId()));
                    summaryAirlineNameLabel.setText(cateringOrder.getAirlineId());
                    airlineNameLabel.setText(cateringOrder.getAirlineId());
                    CostRecord cost = findCostRecord(cateringOrder.getOrderId());
                    if (cost != null) {
                        setCostLabels(cost);
                    }
                    AlertGenerator.showAlert("Success", "Order verified");
                    return;
                }
            }
        }

        AlertGenerator.showAlert("Order Not Found", "No catering order was found with that ID");
    }

    private void setCostLabels(CostRecord cost) {
        rawMaterialCostLabel.setText(String.format("%.2f", cost.getRawMaterialCost()));
        ingredientCostLabel.setText(String.format("%.2f", cost.getIngredientCost()));
        productionCostLabel.setText(String.format("%.2f", cost.getProductionCost()));
        operationCostLabel.setText(String.format("%.2f", cost.getOperationalCost()));
        packagingCostLabel.setText(String.format("%.2f", cost.getPackagingCost()));
        transportCostLabel.setText(String.format("%.2f", cost.getTransportationCost()));
        totalAmountLabel.setText(String.format("%.2f", cost.getTotal()));
        summaryTotalAmountLabel.setText(String.format("%.2f", cost.getTotal()));
    }

    private void clearSummary() {
        invoiceIdLabel.setText("-");
        summaryOrderLabel.setText("-");
        summaryAirlineNameLabel.setText("-");
        summaryDateLabel.setText("-");
        summaryTotalAmountLabel.setText("0.00");
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
