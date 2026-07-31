package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class Headchef extends Employee{

    public Headchef(int userId, String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{

    }

    @Override
    public boolean updateProfile(){
        return true;
    }

    public static void renderDashboard(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/Dashboard.fxml");
    }

    public static void renderDisplayCookingProgress(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayCookingProgress.fxml");
    }

    public static void renderDisplayPreparationProgress(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayPreparationProgress.fxml");
    }

}
