package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class KitchenProductionManager extends  Employee{


    public KitchenProductionManager(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException {

    }
    @Override
    public boolean updateProfile(){
        return false;
    }

    public static void viewMonitorProductionActivities(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(KitchenProductionManager.class.getResource(
                "/KitchenProductionManager/MonitorProductionActivitiesView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void  viewGenerateProductionReports (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/GenerateProductionReportsView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void  viewCreateProductionPlan(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionPlanView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewCalculateIngredientRequirements (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CalculateIngredientRequirementsView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }public static void  viewReceiveApprovedCateringOrders (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/ReceiveApprovedCateringOrdersView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }public static void  viewCreateMenuList (javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateMenuListView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }public static void  ViewCreateProductionSchedule(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/CreateProductionScheduleView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void  viewApproveProductionCompletion(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(
                KitchenProductionManager.class.getResource("/KitchenProductionManager/ApproveProductionCompletionView.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}

