package user;

import javafx.event.ActionEvent;
import nonuser.Meal;
import nonuser.ProductionActivities;

import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
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

        }return null;
    }

    public ProductionActivities createProductionOrderID (int productionOrderId){
        ProductionActivities newProductionId = new ProductionActivities(productionOrderId);
        boolean isSave = BinaryFileUtility.writeObjects("ProductionActivities.bin",newProductionId);
        if(isSave){
            return newProductionId;
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
    public static void reverseDashboard(ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event,"/KitchenProductionManager/dashboardView.fxml",user);
    }

    @Override
    public void viewDashboard(ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/dashboardView.fxml", user);

    }
    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewMonitorProductionActivities(ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/MonitorProductionActivities.fxml",user);
    }

    public static void  viewGenerateProductionReports (ActionEvent event, User user) {
    SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/GenerateProductionReports.fxml",user);
    }

    public static void  viewCreateProductionPlan(ActionEvent event, User user) {
    SceneSwitchingHelper.switchSceneWithData(event,  "/KitchenProductionManager/CreateProductionPlan.fxml" ,user);
    }
    public static void  viewCalculateIngredientRequirements (ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CalculateIngredientRequirements.fxml",user);

    }public static void  viewReceiveApprovedCateringOrders(ActionEvent event, User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/ReceiveApprovedCateringOrders.fxml",user);

    }public static void  viewCreateMenuList (ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CreateMenuList.fxml",user);
//         SceneSwitchingHelper.switchSceneWithData(event, " /KitchenProductionManager/CreateMenuList.fxml ",user);


    }public static void  ViewCreateProductionSchedule(ActionEvent event, User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/CreateProductionSchedule.fxml",user);
    }
    public static void  viewApproveProductionCompletion(ActionEvent event, User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/KitchenProductionManager/ApproveProductionCompletion.fxml", user);
    }
}




