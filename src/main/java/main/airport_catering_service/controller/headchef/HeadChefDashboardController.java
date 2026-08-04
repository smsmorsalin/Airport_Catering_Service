package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class HeadChefDashboardController implements UserReceiver
{
    @javafx.fxml.FXML
    private Button handleRejectedBatchButton;
    @javafx.fxml.FXML
    private Button monitorCookingProgressButton;
    @javafx.fxml.FXML
    private Button updateProductionStatusButton;
    @javafx.fxml.FXML
    private Button assignKitchenStaffButton;
    @javafx.fxml.FXML
    private Button requestQualityInspectionButton;
    @javafx.fxml.FXML
    private Button logoutButton;
    @javafx.fxml.FXML
    private Button manageMealPreparationButton;
    @javafx.fxml.FXML
    private Button viewProductionTasksButton;
    @javafx.fxml.FXML
    private Button kitchenPerformanceReportButton;

    private Headchef loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof Headchef headchef){
            loggedInUser = headchef;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void manageMealPreparation(ActionEvent actionEvent)throws IOException {
        Headchef.renderManageMealPreparation(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void requestQualityInspection(ActionEvent actionEvent) throws IOException {
        Headchef.renderDisplayUpdateConfirmation(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void updateProductionStatus(ActionEvent actionEvent) {
        Headchef.renderDisplayCookingProgress(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void viewProductionTasks(ActionEvent actionEvent) throws IOException {
        Headchef.renderDisplayPreparationProgress(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void kitchenPerformanceReport(ActionEvent actionEvent) throws IOException {
        Headchef.renderViewKitchenPerformanceReport(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void assignKitchenStaff(ActionEvent actionEvent) throws IOException {
        Headchef.renderProductionTaskInformation(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void monitorCookingProgress(ActionEvent actionEvent) {
        Headchef.renderDisplayCookingProgress(actionEvent,  loggedInUser);
    }

    @javafx.fxml.FXML
    public void handleRejectedBatch(ActionEvent actionEvent) throws IOException {
        Headchef.renderHandleRejectedFoodBatches(actionEvent, loggedInUser);
    }
    @Deprecated
    public void ProductionTaskInformation(ActionEvent actionEvent) throws IOException {
        Headchef.renderProductionTaskInformation(actionEvent, loggedInUser);
    }
}