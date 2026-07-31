package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class Headchef extends Employee{

    public Headchef(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
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
    public static void renderProductionTaskInformation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayProductionTaskInformation.fxml");
    }
    public static void renderDisplayUpdateConfirmation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayUpdateConfirmation.fxml");
    }
    public static void renderHandleRejectedFoodBatches(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/HandleRejectedFoodBatches.fxml");
    }
    public static void renderManageMealPreparation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ManageMealPreparation.fxml");
    }
    public static void renderProductionTaskView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ProductionTaskView.fxml");
    }
    public static void renderViewKitchenPerformanceReport(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ViewKitchenPerformanceReport.fxml");
    }

}
