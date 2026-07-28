package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import user.CustomerSupportOfficer;

import javax.imageio.IIOException;
import java.io.IOException;
import java.time.LocalDate;

public class dashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
        CustomerSupportOfficer c = null;

    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarDashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarRegisterComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewResisterComplaint(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarTrackComplaintButtonOnAction(ActionEvent actionEvent) throws IOException {
        CustomerSupportOfficer.viewTrackComplaint(actionEvent);
    }
}