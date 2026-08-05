package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.Meal;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class KitchenProductionManager extends  Employee implements Serializable {

    public KitchenProductionManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    public Meal createNewMenu(String mealName, float mealPrice){
        Meal newMeal = new Meal(mealName, mealPrice);
        boolean isSave = BinaryFileUtility.writeObjects("Meal.bin", newMeal);
        if (isSave){
            return newMeal;
        }
        return null;
    }






    @Override
    public String toString() {
        return "KitchenProductionManager{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
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
    public static void reverseDashboard(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event,"/KitchenProductionManager/dashboardView.fxml",user);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/dashboardView.fxml", user);

    }
    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewMonitorProductionActivities(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/MonitorProductionActivities.fxml",user);
    }

    public static void  viewGenerateProductionReports (javafx.event.ActionEvent event,User user) {
    SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/GenerateProductionReports.fxml",user);
    }

    public static void  viewCreateProductionPlan(javafx.event.ActionEvent event,User user) {
    SceneSwitchingHelper.switchSceneWithData(event,  "/KitchenProductionManager/CreateProductionPlan.fxml" ,user);
    }
    public static void  viewCalculateIngredientRequirements (javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CalculateIngredientRequirements.fxml",user);

    }public static void  viewReceiveApprovedCateringOrders(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/ReceiveApprovedCateringOrders.fxml",user);

    }public static void  viewCreateMenuList (javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CreateMenuList.fxml",user);
//         SceneSwitchingHelper.switchSceneWithData(event, " /KitchenProductionManager/CreateMenuList.fxml ",user);


    }public static void  ViewCreateProductionSchedule(javafx.event.ActionEvent event, User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CreateProductionSchedule.fxml",user);
    }
    public static void  viewApproveProductionCompletion(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/ApproveProductionCompletion.fxml",user);
    }


}

