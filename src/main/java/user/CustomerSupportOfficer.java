package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class CustomerSupportOfficer extends Employee implements Serializable {

    public CustomerSupportOfficer(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public String toString() {
        return "CustomerSupportOfficer{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
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
    public void viewDashboard(javafx.event.ActionEvent event, User user){

    }

    @Override
    public boolean updateProfile(){
        return false;
    }

//Dashboard TO Button
    public static void viewRegisterComplaint(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/RegisterComplaintView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void viewTrackComplaint(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/TrackComplaintView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewResolveComplaint(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/ResolveComplaintView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewEmergencyModification(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/EmergencyModificationView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewFlightDelayRequest(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/FlightDelayRequestView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewFlightCancellation(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/FlightCancellationView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewServiceUpdates(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/ServiceUpdatesView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void viewGenerateReports(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/GenerateReportsView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

//Button to Dashboard

    public static void viewdashboard(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/dashboardView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
