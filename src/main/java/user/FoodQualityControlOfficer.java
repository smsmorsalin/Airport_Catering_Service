package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.airport_catering_service.HelloApplication;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class FoodQualityControlOfficer extends Employee implements Serializable {


    public FoodQualityControlOfficer(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event,"/FoodQualityControlOfficer/dashboardView.fxml",user);

    }

    @Override
    public boolean updateProfile() {
        return false;
    }

    public static void viewQualityTrendAnalysis(javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/QualityTrendAnalysisView.fxml",user);

    }

    public static void viewApproveBatch(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/ApproveBatchView.fxml",user);



    }
    public static void viewPerformInspection(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/PerformInspectionView.fxml",user);


    }

    public static void viewRejectBatch(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/RejectBatchView.fxml",user);


    }
    public static void viewReceiveInspectionRequest(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/ReceiveInspectionRequestView.fxml",user);


    }
    public static void  viewFoodSafetyCheck (javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/FoodSafetyCheckView.fxml",user);

    }
    public static void  viewGenerateQAReport (javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/GenerateQAReportView.fxml",user);



    }
    public static void  viewManageQualityIssue (javafx.event.ActionEvent event,User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/FoodQualityControlOfficer/ManageQualityIssueView.fxml",user);


    }
    public static void reverseFQCDashboard(javafx.event.ActionEvent event,User user) {
        SceneSwitchingHelper.switchSceneWithData(event,"/FoodQualityControlOfficer/dashboardView.fxml",user );

    }


}
