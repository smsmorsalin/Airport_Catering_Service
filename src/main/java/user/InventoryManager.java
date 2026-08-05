package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.PurchaseRequest;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class InventoryManager extends Employee implements Serializable {

    public InventoryManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event,"/InventoryManager/DashboardView.fxml" ,user);
    }

    @Override
    public boolean updateProfile(){return false;}


    public boolean purchaseRequest(String productName, int quantity, String supplierName, LocalDate expectedDeliveryDate){
        //validation
        PurchaseRequest newRequest = new PurchaseRequest(productName, quantity, supplierName, expectedDeliveryDate);

        boolean b = BinaryFileUtility.writeObjects("PurchaseRequest.bin", newRequest);
        if(b){
            AlertGenerator.showAlert("Success", "purchase Request Created");
            return true;
        }
        return false;

    }





    //habijabi
    public static void renderCheckIngredientAvailability(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/CheckIngredientAvailabilityView.fxml",user);
    }

    public static void renderCreatePurchaseRequest(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/CreatePurchaseRequestView.fxml",user);
    }

    public static void renderDashboard(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/DashboardView.fxml",user);
    }

    public static void renderGenerateInventoryReport(javafx.event.ActionEvent event,User user ) {
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/GenerateInventoryReportView.fxml",user);
    }

    public static void renderLowStockAlert(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/LowStockAlertView.fxml",user);
    }

    public static void renderManageSupplier(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/ManageSupplierView.fxml",user);
    }

    public static void renderReceiveIngredient(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/ReceiveIngredientView.fxml",user);
    }

    public static void renderReserveIngredient(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/ReserveIngredientView.fxml",user);
    }

    public static void renderUpdateInventory(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/InventoryManager/UpdateInventoryView.fxml",user);
    }

}
