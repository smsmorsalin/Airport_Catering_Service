package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.DashBoard;
import nonuser.EmergencyModificationRequest;
import user.FinanceAndBillingManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class dashboardViewController implements UserReceiver {
    private static final String REQUEST_FILE = "EmergencyModification.bin";

    @javafx.fxml.FXML private TableColumn<DashBoard, String> descriptionTableView;
    @javafx.fxml.FXML private TextField enterTicketIDtextField;
    @javafx.fxml.FXML private Label emargencyIssueLabel;
    @javafx.fxml.FXML private TableColumn<DashBoard, Integer> ticketIDTableColumn;
    @javafx.fxml.FXML private TableColumn<DashBoard, String> statusTableView;
    @javafx.fxml.FXML private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML private TableView<DashBoard> mainTableView;
    @javafx.fxml.FXML private TableColumn<DashBoard, String> issueTypeTableView;

    private FinanceAndBillingManager loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof FinanceAndBillingManager manager) {
            loggedInUser = manager;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().setAll("Pending", "Approved", "Rejected", "Resolved");
        ticketIDTableColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTicketID()));
        issueTypeTableView.setCellValueFactory(data -> new SimpleStringProperty("Emergency Modification"));
        descriptionTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));
        statusTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));
        loadRequests();
    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        String ticketText = enterTicketIDtextField.getText().trim();
        if (ticketText.isEmpty() || statusComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID and status should be provided");
            return;
        }
        int ticketId;
        try {
            ticketId = Integer.parseInt(ticketText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Invalid Input", "Ticket ID should be an integer");
            return;
        }
        ArrayList<Object> requests = BinaryFileUtility.readObjects(REQUEST_FILE);
        for (Object object : requests) {
            if (object instanceof EmergencyModificationRequest request
                    && request.getRequestId() == ticketId) {
                request.setStatus(statusComboBox.getValue());
                if (!BinaryFileUtility.overwriteObjects(REQUEST_FILE, requests)) {
                    AlertGenerator.showAlert("Error", "Status could not be saved");
                    return;
                }
                AlertGenerator.showAlert("Success", "Issue status updated successfully");
                loadRequests();
                return;
            }
        }
        AlertGenerator.showAlert("Ticket Not Found", "No emergency issue was found with that ID");
    }

    private void loadRequests() {
        ArrayList<DashBoard> rows = new ArrayList<>();
        int pending = 0;
        for (Object object : BinaryFileUtility.readObjects(REQUEST_FILE)) {
            if (object instanceof EmergencyModificationRequest request) {
                rows.add(new DashBoard(request.getModificationRequest() + " | " + request.getReason(),
                        request.getRequestId(), request.getStatus(), true));
                if ("Pending".equalsIgnoreCase(request.getStatus())) pending++;
            }
        }
        mainTableView.getItems().setAll(rows);
        emargencyIssueLabel.setText("Emergency Issues: " + pending);
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent event) throws IOException { User.logout(event); }

    private void switchTo(ActionEvent event, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(event, view, loggedInUser);
    }

    @javafx.fxml.FXML public void sidebarDashboardButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/dashboardView.fxml"); }
    @javafx.fxml.FXML public void sidebardashboardButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/dashboardView.fxml"); }
    @javafx.fxml.FXML public void sidebarHomePageButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/dashboardView.fxml"); }
    @javafx.fxml.FXML public void sideBarCalculateCostButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/CalculateCostView.fxml"); }
    @javafx.fxml.FXML public void sideBarGenerateInvoiceButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/GenerateInvoiceView.fxml"); }
    @javafx.fxml.FXML public void sideBarRecordPaymentButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/RecordPaymentView.fxml"); }
    @javafx.fxml.FXML public void sideBarProcessRefundButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/ProcessRefundView.fxml"); }
    @javafx.fxml.FXML public void sideBarOutstandingPaymentsButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/OutstandingPaymentsView.fxml"); }
    @javafx.fxml.FXML public void sideBarFinancialReportsButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/FinancialReportsView.fxml"); }
    @javafx.fxml.FXML public void sideBarRevenueSummaryButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/RevenueSummaryView.fxml"); }
    @javafx.fxml.FXML public void sideBarPaymentHistoryButtonOnAction(ActionEvent e) throws IOException { switchTo(e, "/finance_and_billing_manager/PaymentHistoryView.fxml"); }
}
