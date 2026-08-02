package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.CateringOrder;
import nonuser.Invoice;
import user.FinanceAndBillingManager;
import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.util.ArrayList;

public class GenerateInvoiceViewController
{
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
    private ArrayList<Object> selectedInvoiceList;
    @javafx.fxml.FXML
    private Label OrderIdLabel;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    private CateringOrder selectedCateringOrder;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateinvoiceOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarGenerateInvoiceOnAction(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void VerifyOrderOnAction(ActionEvent actionEvent) {
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
                    if(cateringOrder.getStatus().equals("Canceled")){
                        AlertGenerator.showAlert("error", "Order Already canceled");
                        return;
                    }
                    if(cateringOrder.getStatus().equals("Delivery")){
                        AlertGenerator.showAlert("error", "Order Already Delivered");
                        return;
                    }
                    if(cateringOrder.getStatus().equals("Rejected")){
                        AlertGenerator.showAlert("error", "Order Already Rejected");
                        return;
                    }
                    selectedInvoiceList = BinaryFileUtility.readObjects("Invoice.bin");

                    for (Object obj2 : selectedInvoiceList){
                        if (obj2 instanceof Invoice invoice){
                            if(invoice.getOrderId() == selectedCateringOrderId){
                                AlertGenerator.showAlert("error", "Already Invoice Generated");
                                return;
                            }
                            selectedCateringOrder = cateringOrder;
                        }
                    }
                    OrderIdLabel.setText("Order Id: " +cateringOrder.getOrderId());
                    orderStatusLabel.setText("Order Status: "+ cateringOrder.getStatus());
                    return;
                }
            }
        }

    }

    @Deprecated
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarHomePageButtonOnAction(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void sidebarHomePageButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRevenueSummaryButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewRevenueSummary(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarRecordPaymentButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewRecordPayment(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProcessRefundButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewProcessRefund(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateInvoiceButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewGenerateInvoice(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarPaymentHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewPaymentHistory(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewCalculateCost(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFinancialReportsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewFinancialReports(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent actionEvent) throws IOException{
        FinanceAndBillingManager.viewOutstandingPayments(actionEvent);
    }

}