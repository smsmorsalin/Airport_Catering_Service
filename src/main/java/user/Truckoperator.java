package user;

import utility.SceneSwitchingHelper;

import java.io.Serializable;
import java.time.LocalDate;

public class Truckoperator extends Employee implements Serializable {

    public Truckoperator(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/DashboardView.fxml", user);

    }

    @Override
    public boolean updateProfile(){
        return true;

    }

    public static void renderDashboardView(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/DashboardView.fxml", user);
    }

    public static void renderAcceptDeliveryAssignmentView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/AcceptDeliveryAssignmentView.fxml", user);
    }

    public static void renderCollectPackagedCateringOrdersView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/CollectPackagedCateringOrdersView.fxml", user);
    }

    public static void renderConfirmAircraftDeliveryView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/ConfirmAircraftDeliveryView.fxml",  user);
    }

    public static void renderDisplayDepartureConfirmationView(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/UpdateTransitStatus.fxml",  user);
    }

    public static void renderReportDeliveryProblemsView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/ReportDeliveryProblemsView.fxml",  user);
    }

    public static void renderStartDeliveryView(javafx.event.ActionEvent event, User user)  {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/UpdateDepartureStatus.fxml",  user);
    }
    public static void renderAssignmentDeliveryTasksView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/AssignedDeliveryTasksView.fxml",  user);
    }
    public static void renderDeliveryHistoryView(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/Truckoperator/DeliveryPerformanceReport.fxml",  user);
    }
}
