package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.ServiceUpdate;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceUpdatesViewController implements UserReceiver
{
    private static final String SERVICE_UPDATE_FILE = "ServiceUpdate.bin";

    @javafx.fxml.FXML
    private Label recentUpdatesLabel;
    @javafx.fxml.FXML
    private Button publishUpdateBtn;
    @javafx.fxml.FXML
    private TextArea updateMessageTextField;
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> updateCategoryComboBox;
    @javafx.fxml.FXML
    private TextField updateTitleTextField;


    private CustomerSupportOfficer loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof CustomerSupportOfficer customerSupportOfficer){
            this.loggedInUser = customerSupportOfficer;
        } else {
            AlertGenerator.showAlert("Error", "Authentication failed");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
        updateCategoryComboBox.getItems().setAll(
                "Service Disruption", "Flight Schedule", "Catering Service",
                "Facility Update", "General Announcement");
        priorityComboBox.getItems().setAll("Low", "Medium", "High", "Critical");
        loadRecentUpdate();
    }

    @javafx.fxml.FXML
    public void PublishUpdateOnAction(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }

        String title = updateTitleTextField.getText().trim();
        String message = updateMessageTextField.getText().trim();
        if (title.isEmpty() || message.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Title and message should be filled");
            return;
        }
        if (title.length() > 100) {
            AlertGenerator.showAlert("Invalid Input", "Title cannot exceed 100 characters");
            return;
        }
        if (updateCategoryComboBox.getValue() == null || priorityComboBox.getValue() == null) {
            AlertGenerator.showAlert("Invalid Input", "Category and priority should be selected");
            return;
        }

        ServiceUpdate update = new ServiceUpdate(
                updateCategoryComboBox.getValue(), title, message,
                priorityComboBox.getValue(), loggedInUser.getEmployeeId());
        if (!BinaryFileUtility.writeObjects(SERVICE_UPDATE_FILE, update)) {
            AlertGenerator.showAlert("Error", "Service update could not be published");
            return;
        }

        AlertGenerator.showAlert("Success", "Service update published successfully");
        updateTitleTextField.clear();
        updateMessageTextField.clear();
        updateCategoryComboBox.getSelectionModel().clearSelection();
        priorityComboBox.getSelectionModel().clearSelection();
        loadRecentUpdate();
    }

    private void loadRecentUpdate() {
        ArrayList<Object> updates = BinaryFileUtility.readObjects(SERVICE_UPDATE_FILE);
        ServiceUpdate latest = null;
        for (Object object : updates) {
            if (object instanceof ServiceUpdate update
                    && (latest == null || update.getPublishedAt().isAfter(latest.getPublishedAt()))) {
                latest = update;
            }
        }
        if (latest == null) {
            recentUpdatesLabel.setText("No recent updates available");
            return;
        }
        recentUpdatesLabel.setText(
                latest.getTitle() + " (" + latest.getPriority() + "): "
                        + latest.getMessage());
    }


    private void switchTo(ActionEvent actionEvent, String view) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, view, loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/dashboardView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/dashboardView.fxml",
                loggedInUser);
    }


    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/RegisterComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/TrackComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/ResolveComplaintView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarNewAirlineRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/NewAirlineRequestView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarNewFlightEntryButtonOnAction(ActionEvent actionEvent)throws IOException{
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/NewFlightEntryView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarCancellationAndDelayButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/CancellationAndDelayView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/ServiceUpdatesView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(
                actionEvent, "/CustomerSupportOfficer/GenerateReportsView.fxml",
                loggedInUser);
    }
}
