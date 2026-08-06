package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.AirlineRequest;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;
import java.io.IOException;

public class NewAirlineRequestViewController implements UserReceiver
{
    private static final String REQUEST_FILE = "AirlineRequest.bin";

    @javafx.fxml.FXML
    private TableColumn<AirlineRequest, String> airlineNameColumn;
    @javafx.fxml.FXML
    private TableColumn<AirlineRequest, String> airlineIdColumn;
    @javafx.fxml.FXML
    private TableView<AirlineRequest> airlineRequestTable;
    @javafx.fxml.FXML
    private TextField newAirlineNameTextField;
    @javafx.fxml.FXML
    private Label summaryPriorityLabel;
    @javafx.fxml.FXML
    private TableColumn<AirlineRequest, String> requestStatusColumn;
    @javafx.fxml.FXML
    private TextField newAirlineIdTextField;
    @javafx.fxml.FXML
    private TextField requestIdTextField;
    @javafx.fxml.FXML
    private Button addAirlineButton;
    @javafx.fxml.FXML
    private TableColumn<AirlineRequest, Integer> requestIdColumn;

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
        requestIdColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleObjectProperty<>(cell.getValue().getRequestId()));
        airlineIdColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNewAirlineId()));
        airlineNameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNewAirlineName()));
        requestStatusColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getStatus()));
        airlineRequestTable.getItems().setAll(BinaryFileUtility.readObjects(REQUEST_FILE).stream()
                .filter(AirlineRequest.class::isInstance)
                .map(AirlineRequest.class::cast)
                .toList());
        summaryPriorityLabel.setText("-");
    }

    @javafx.fxml.FXML
    public void addAirlineOnAction(ActionEvent actionEvent) {
        String airlineId = newAirlineIdTextField.getText().trim();
        String airlineName = newAirlineNameTextField.getText().trim();
        if (airlineId.isEmpty() || airlineName.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "Airline ID and name should be filled");
            return;
        }
        if (loggedInUser == null) {
            AlertGenerator.showAlert("Error", "Please log in again");
            return;
        }
        for (Object object : BinaryFileUtility.readObjects(REQUEST_FILE)) {
            if (object instanceof AirlineRequest request
                    && request.getNewAirlineId().equalsIgnoreCase(airlineId)
                    && "Pending".equalsIgnoreCase(request.getStatus())) {
                AlertGenerator.showAlert("Duplicate Request", "A pending request already exists for this airline ID");
                return;
            }
        }
        AirlineRequest request = new AirlineRequest(
                databaseAccessor.generateNewUniqueId(REQUEST_FILE, "requestId"),
                airlineId, airlineName, loggedInUser.getEmployeeId());
        if (BinaryFileUtility.writeObjects(REQUEST_FILE, request)) {
            initialize();
            newAirlineIdTextField.clear();
            newAirlineNameTextField.clear();
            AlertGenerator.showAlert("Success", "Airline request submitted successfully");
        } else {
            AlertGenerator.showAlert("Error", "Airline request could not be saved");
        }
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
