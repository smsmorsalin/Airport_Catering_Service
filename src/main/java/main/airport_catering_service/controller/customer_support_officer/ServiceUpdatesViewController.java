package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.CustomerSupportOfficer;

import java.io.IOException;

public class ServiceUpdatesViewController
{
    @javafx.fxml.FXML
    private Label recentUpdatesLabel;
    @javafx.fxml.FXML
    private Button publishUpdateBtn;
    @javafx.fxml.FXML
    private Button viewUpdatesBtn;
    @javafx.fxml.FXML
    private TextArea updateMessageTextField;
    @javafx.fxml.FXML
    private ComboBox priorityComboBox;
    @javafx.fxml.FXML
    private Label updateStatusLabel;
    @javafx.fxml.FXML
    private Label summaryPriorityLabel;
    @javafx.fxml.FXML
    private Label summaryCategoryLabel;
    @javafx.fxml.FXML
    private ComboBox updateCategoryComboBox;
    @javafx.fxml.FXML
    private TextField updateTitleTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void ServiceUpdatesOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewUpdatesLabel(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void PublishUpdateOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarRegisterComplaintButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebardashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewdashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sidebarFlightDelayRequestButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarGenerateReportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarServiceUpdatesButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarFlightCancellationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarEmergencyModificationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarResolveComplaintButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarTrackComplaintButtonOnAction(ActionEvent actionEvent) {
    }
}