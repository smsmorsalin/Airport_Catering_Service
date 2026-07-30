package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class KitchenProductionManager extends  Employee{


    public KitchenProductionManager(int userId, String password, String fullName, String role, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public String toString() {
        return "KitchenProductionManager{" +
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
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException {

    }
    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewMonitorProductionActivities(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/MonitorProductionActivities.fxml");
    }

    public static void  viewGenerateProductionReports (javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/GenerateProductionReports.fxml");
    }

    public static void  viewCreateProductionPlan(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionPlan.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewCalculateIngredientRequirements (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CalculateIngredientRequirements.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }public static void  viewReceiveApprovedCateringOrders(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/ReceiveApprovedCateringOrders.fxml");

    }public static void  viewCreateMenuList (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateMenuList.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }public static void  ViewCreateProductionSchedule(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionSchedule.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewApproveProductionCompletion(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/ApproveProductionCompletion.fxml");
    }

    public static void reverseDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (KitchenProductionManager.class.getResource("/KitchenProductionManager/dashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

