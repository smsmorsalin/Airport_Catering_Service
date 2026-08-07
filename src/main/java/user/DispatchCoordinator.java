package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.AssignDriverDetails;
import nonuser.DriverDetails;
import nonuser.PurchaseRequest;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class DispatchCoordinator extends Employee implements Serializable {

    public DispatchCoordinator(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public boolean updateProfile() {
        return false;
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event,"/DispatchCoordinator/DashboardView.fxml",user);
    }



    public static void renderAssignTruck(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/AssignTruckView.fxml", user);
    }

    public static void renderDashboard(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/DashboardView.fxml",user);
    }

    public static void renderEmergencyDelivery(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/EmergencyDeliveryView.fxml",user);
    }

    public static void renderGenerateDispatchReport(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/GenerateDispatchReportView.fxml",user);
    }

    public static void renderManageDeliveryDelay(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/ManageDeliveryDelayView.fxml",user);
    }

    public static void renderMonitorDelivery(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/MonitorDeliveryView.fxml",user);
    }

    public static void renderPackageOrder(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/PackageOrderView.fxml",user);
    }

    public static void renderReceiveDispatchRequest(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/ReceiveDispatchRequestView.fxml",user);
    }

    public static void renderScheduleDelivery(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/DispatchCoordinator/ScheduleDeliveryView.fxml",user);

    }

    public boolean AssignDriverDetails (int truckID, int driverID, int truckNumber,int orderID) {
        AssignDriverDetails newAssignDriver = new AssignDriverDetails(orderID, truckID, truckNumber, driverID);
        boolean b = BinaryFileUtility.writeObjects("AssignDriverDetails.bin", newAssignDriver);
        if(b){
            return true;
        }
        return false;
    }
}
