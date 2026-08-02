package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Headchef extends Employee implements Serializable {

    public Headchef(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){

    }

    @Override
    public boolean updateProfile(){
        return true;
    }

    public static void renderDashboardView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DashboardView.fxml");
    }

    public static void renderDisplayCookingProgress(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayCookingProgressView.fxml");
    }

    public static void renderDisplayPreparationProgress(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayPreparationProgressView.fxml");
    }
    public static void renderProductionTaskInformation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayProductionTaskInformationView.fxml");
    }
    public static void renderDisplayUpdateConfirmation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/DisplayUpdateConfirmationView.fxml");
    }
    public static void renderHandleRejectedFoodBatches(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/HandleRejectedFoodBatchesView.fxml");
    }
    public static void renderManageMealPreparation(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ManageMealPreparationView.fxml");
    }
    public static void renderProductionTask(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ProductionTaskView.fxml");
    }
    public static void renderViewKitchenPerformanceReport(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Headchef/ViewKitchenPerformanceReportView.fxml");
    }

}
