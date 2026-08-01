package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class DispatchCoordinator extends Employee implements Serializable {

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
}
