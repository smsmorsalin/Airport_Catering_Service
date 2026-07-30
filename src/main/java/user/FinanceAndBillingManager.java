package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FinanceAndBillingManager extends Employee {

    public FinanceAndBillingManager(int userId, String password, String fullName, String role, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{

    }

    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewCalculateCost(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/CalculateCostView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void viewGenerateInvoice(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/GenerateInvoiceView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewRecordPayment(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/RecordPaymentView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewProcessRefund(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/ProcessRefundView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewOutstandingPayments(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/OutstandingPaymentsView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewFinancialReports(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/FinancialReportsView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewRevenueSummary(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/RevenueSummaryView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewPaymentHistory(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(FinanceAndBillingManager.class.getResource("/FinanceAndBillingManager/PaymentHistoryView.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
