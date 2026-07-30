package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.airport_catering_service.HelloApplication;

import java.io.IOException;
import java.time.LocalDate;

public class FoodQualityControlOfficer extends Employee {
    public FoodQualityControlOfficer (int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public String toString() {
        return "FoodQualityControlOfficer{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
                ", shift='" + shift + '\'' +
                ", salary=" + salary +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public void viewDashboard(ActionEvent event) throws IOException {

    }

    @Override
    public boolean updateProfile() {
        return false;
    }

    public static void viewQualityTrendAnalysis(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/QualityTrendAnalysisView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewApproveBatch(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/ApproveBatchView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void viewPerformInspection(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/PerformInspectionView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewRejectBatch(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/RejectBatchView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void viewReceiveInspectionRequest(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/ReceiveInspectionRequestView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewFoodSafetyCheck (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/FoodSafetyCheckView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewGenerateQAReport (javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/GenerateQAReportView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
    public static void  viewManageQualityIssue (javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/ManageQualityIssueView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
    public static void reverseFQCDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (FoodQualityControlOfficer.class.getResource("/FoodQualityControlOfficer/dashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
