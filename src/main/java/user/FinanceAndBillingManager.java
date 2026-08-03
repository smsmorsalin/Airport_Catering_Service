package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class FinanceAndBillingManager extends Employee implements Serializable {

    public FinanceAndBillingManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){

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

    //Button to Dashboard

    public static void viewdashboard(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/FinanceAndBillingManager/dashboardView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
