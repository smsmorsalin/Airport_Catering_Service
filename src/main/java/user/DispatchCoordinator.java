package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class DispatchCoordinator extends Employee{

    public DispatchCoordinator(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
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

}
