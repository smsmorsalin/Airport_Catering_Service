package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class InventoryManager extends Employee{
    public InventoryManager(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{
    }

    @Override
    public boolean updateProfile(){return false;}


    public static void renderCheckIngredientAvailability(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/CheckIngredientAvailabilityView.fxml");
    }


}
