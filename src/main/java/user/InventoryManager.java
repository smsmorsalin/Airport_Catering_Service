package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class InventoryManager extends Employee implements Serializable {

    public InventoryManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{
    }

    @Override
    public boolean updateProfile(){return false;}


    public static void renderCheckIngredientAvailability(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/CheckIngredientAvailabilityView.fxml");
    }

    public static void renderCreatePurchaseRequest(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/CreatePurchaseRequestView.fxml");
    }

    public static void renderDashboard(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/DashboardView.fxml");
    }

    public static void renderGenerateInventoryReport(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/GenerateInventoryReportView.fxml");
    }

    public static void renderLowStockAlert(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/LowStockAlertView.fxml");
    }

    public static void renderManageSupplier(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/ManageSupplierView.fxml");
    }

    public static void renderReceiveIngredient(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/ReceiveIngredientView.fxml");
    }

    public static void renderReserveIngredient(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/ReserveIngredientView.fxml");
    }

    public static void renderUpdateInventory(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/InventoryManager/UpdateInventoryView.fxml");
    }

    public static void reverseDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader
                (InventoryManager.class.getResource("/InventoryManager/DashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
