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
        SceneSwitchingHelper.switchSceneWithData(event,"/Headchef/DashboardView.Fxml", user);

    }

    @Override
    public boolean updateProfile(){
        return true;
    }

    public static void renderDashboardView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/DashboardView.fxml", user);
    }

    public static void renderDisplayCookingProgress(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/DisplayCookingProgressView.fxml", user);
    }

    public static void renderDisplayPreparationProgress(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/DisplayPreparationProgressView.fxml", user);
    }
    public static void renderProductionTaskInformation(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/DisplayProductionTaskInformationView.fxml", user);
    }
    public static void renderDisplayUpdateConfirmation(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/DisplayUpdateConfirmationView.fxml", user);
    }
    public static void renderHandleRejectedFoodBatches(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/HandleRejectedFoodBatchesView.fxml", user);
    }
    public static void renderManageMealPreparation(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/ManageMealPreparationView.fxml", user);
    }
    public static void renderProductionTask(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/ProductionTaskView.fxml", user);
    }
    public static void renderViewKitchenPerformanceReport(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Headchef/ViewKitchenPerformanceReportView.fxml", user);
    }

}
