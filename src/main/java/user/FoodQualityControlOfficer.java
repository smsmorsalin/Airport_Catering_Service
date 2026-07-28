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

    public static void viewTrackComplaint(javafx.event.ActionEvent event) throws IOException{
//        FXMLLoader loader = new FXMLLoader(
//                CustomerSupportOfficer.class.getResource("/CustomerSupportOfficer/TrackComplaintView.fxml"));
//
//        Parent root = loader.load();
//
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
    }

}
