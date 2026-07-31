package user;

import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class Truckoperator extends Employee {

    public Truckoperator(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent Event) throws IOException {

    }

    @Override
    public boolean updateProfile() {return true;}

    public static void renderDashboard(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/DashboardView.fxml");
    }

    public static void renderAcceptDeliveryAssignment(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/AcceptDeliveryAssignmentView.fxml");
    }
    public static void renderCollectPackagedCateringOrders(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/CollectPackagedCateringOrdersView.fxml");
    }
    public static void renderConfirmAircraftDelivery(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/ConfirmAircraftDeliveryView.fxml");
    }
    public static void renderDisplayDepartureConfirmation(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/DisplayDepartureConfirmationView.fxml");
    }
    public static void renderReportDeliveryProblems(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/ReportDeliveryProblemsView.fxml");
    }
    public static void renderStartDeliveryTrip(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/StartDeliveryTripView.fxml");
    }
    public static void renderViewAssignedDeliveryTasks(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/ViewAssignedDeliveryTasksView.fxml");
    }
    public static void renderviewDeliveryHistory(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event,"/truckoperator/viewDeliveryHistoryView.fxml");
    }
}
