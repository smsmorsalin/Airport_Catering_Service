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

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/dashboardView.fxml", user);

    }
    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewMonitorProductionActivities(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/MonitorProductionActivities.fxml");
    }

    public static void  viewGenerateProductionReports (javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/GenerateProductionReports.fxml");
    }

    public static void  viewCreateProductionPlan(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionPlan.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void  viewCalculateIngredientRequirements (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CalculateIngredientRequirements.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }public static void  viewReceiveApprovedCateringOrders(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/ReceiveApprovedCateringOrders.fxml");

    }public static void  viewCreateMenuList (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateMenuList.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }public static void  ViewCreateProductionSchedule(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionSchedule.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewApproveProductionCompletion(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/KitchenProductionManager/ApproveProductionCompletion.fxml");
    }

    public static void reverseDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (KitchenProductionManager.class.getResource("/KitchenProductionManager/dashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

