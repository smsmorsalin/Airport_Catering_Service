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

public class CustomerSupportOfficer extends Employee implements Serializable  {

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

    public static void reverseDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/dashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/dashboardView.fxml", user);

    }

    @Override
    public boolean updateProfile(){return false;}

       public static void  viewRegisterComplaint(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/RegisterComplaintView.fxml",user);
       }

       public static void  viewTrackComplaint(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/TrackComplaintView.fxml",user);
       }

       public static void  viewResolveComplaint(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/ResolveComplaintView.fxml",user);
       }

       public static void  viewNewAirlineRequest(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/NewAirlineRequestView.fxml",user);
       }

       public static void  viewNewFlightEntry(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/NewFlightEntryView.fxml",user);
       }

       public static void  viewCancellationAndDelay(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/CancellationAndDelayView.fxml",user);
       }

       public static void  viewServiceUpdates(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/ServiceUpdatesView.fxml",user);
       }

       public static void  viewGenerateReports(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/CustomerSupportOfficer/GenerateReportsView.fxml",user);
       }

    }
