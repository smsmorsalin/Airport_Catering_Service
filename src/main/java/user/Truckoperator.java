package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Truckoperator extends Employee implements Serializable {

    public Truckoperator(int userId, String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{

    }

    @Override
    public boolean updateProfile(){
        return true;
    }

    public static void renderDashboardView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/DashboardView.fxml");
    }

    public static void renderAcceptDeliveryAssignmentView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/AcceptDeliveryAssignmentView.fxml");
    }

    public static void renderCollectPackagedCateringOrdersView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/CollectPackagedCateringOrdersView.fxml");
    }

    public static void renderConfirmAircraftDeliveryView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/ConfirmAircraftDeliveryView.fxml");
    }

    public static void renderDisplayDepartureConfirmationView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/DisplayDepartureConfirmationView.fxml");
    }

    public static void renderReportDeliveryProblemsView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/ReportDeliveryProblemsView.fxml");
    }

    public static void renderStartDeliveryView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/StartDeliveryTripView.fxml");
    }
    public static void renderAssignmentDeliveryTasksView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/AssignedDeliveryTasksView.fxml");
    }
    public static void renderDeliveryHistoryView(javafx.event.ActionEvent event) throws IOException{
        SceneSwitchingHelper.fullSceneReplacement(event, "/Truckoperator/DeliveryHistoryView.fxml");
    }
}
