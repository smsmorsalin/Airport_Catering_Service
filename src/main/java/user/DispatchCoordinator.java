package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class DispatchCoordinator extends Employee{

    public DispatchCoordinator(int userId, String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, salary);
    }

    @Override
    public boolean updateProfile() {
        return false;
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{

    }


    public static void renderAssignTruck(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/AssignTruckView.fxml");
    }

    public static void renderDashboard(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/DashboardView.fxml");
    }

    public static void renderEmergencyDelivery(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/EmergencyDeliveryView.fxml");
    }

    public static void renderGenerateDispatchReport(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/GenerateDispatchReportView.fxml");
    }

    public static void renderManageDeliveryDelay(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/ManageDeliveryDelayView.fxml");
    }

    public static void renderMonitorDelivery(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/MonitorDeliveryView.fxml");
    }

    public static void renderPackageOrder(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/PackageOrderView.fxml");
    }

    public static void renderReceiveDispatchRequest(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/ReceiveDispatchRequestView.fxml");
    }

    public static void renderScheduleDelivery(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/DispatchCoordinator/ScheduleDeliveryView.fxml");
    }

    public static void reverseDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (DispatchCoordinator.class.getResource("/DispatchCoordinator/DashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
