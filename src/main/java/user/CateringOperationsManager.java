package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.CateringOrder;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CateringOperationsManager extends Employee implements Serializable {

    public CateringOperationsManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public String toString() {
        return "CateringOperationsManager{" +
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
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/catering_operations_manager/businessDashboardView.fxml"));

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public boolean updateProfile(){
        return false;
    }

    public void approveOrRejectOrder(ArrayList<Object> cateringOrder){
        boolean b = BinaryFileUtility.overwriteObjects("CateringOrder.bin", cateringOrder);

    }



    //below are the code for fxml sideBar rendering button on action
    public static void renderFxmlBusinessDashboardView(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/businessDashboardView.fxml");
    }

    public static void renderFxmlApproveOrRejectOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/approveOrRejectOrderView.fxml");
    }

    public static void renderFxmlReviewOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/reviewOrderView.fxml");
    }

    public static void renderFxmlOperationalReport(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/operationalReportView.fxml");
    }

    public static void renderFxmlMonitorProduction(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/monitorProductionView.fxml");
    }

    public static void renderFxmlInventoryStatus(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/inventoryStatusView.fxml");
    }

    public static void renderFxmlDeliveryMonitoring(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/deliveryMonitoringView.fxml");
    }

    public static void renderFxmlEmergencyIssue(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/emergencyIssueView.fxml");
    }

    public static void renderFxmlGenerateReport(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/catering_operations_manager/generateReportView.fxml");
    }


}
