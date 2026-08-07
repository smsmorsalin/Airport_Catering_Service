package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class FinanceAndBillingManager extends Employee implements Serializable {



    public FinanceAndBillingManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public String toString() {
        return "FinanceAndBillingManager{" +
                "role='" + role + '\'' +
                ", employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/dashboardView.fxml", user);

    }

    @Override
    public boolean updateProfile(){
        return false;
    }



    public static void  viewdashboard(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/dashboardView.fxml",user);
    }

    public static void  viewCalculateCost(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/CalculateCostView.fxml",user);
    }

    public static void  viewGenerateInvoice(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/GenerateInvoiceView.fxml",user);
    }

    public static void  viewRecordPayment(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/RecordPaymentView.fxml",user);
    }

    public static void  viewProcessRefund(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/ProcessRefundView.fxml",user);
    }

    public static void  viewOutstandingPayments(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/OutstandingPaymentsView.fxml",user);
    }

    public static void  viewFinancialReports(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/FinancialReportsView.fxml",user);
    }

    public static void  viewRevenueSummary(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/RevenueSummaryView.fxml",user);
    }

    public static void  viewPaymentHistory(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FinanceAndBillingManager/PaymentHistoryView.fxml",user);
    }
}
