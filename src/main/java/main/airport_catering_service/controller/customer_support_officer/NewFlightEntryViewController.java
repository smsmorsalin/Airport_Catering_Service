package main.airport_catering_service.controller.customer_support_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.Flight;
import user.CustomerSupportOfficer;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class NewFlightEntryViewController implements UserReceiver
{
    private static final String FLIGHT_FILE = "Flight.bin";

    @javafx.fxml.FXML
    private TableColumn<Flight, String> flightStatusColumn;
    @javafx.fxml.FXML
    private TextField destinationTextField;
    @javafx.fxml.FXML
    private TableView<Flight> flightTable;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> flightNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> airlineIdColumn;
    @javafx.fxml.FXML
    private TextField flightNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> flightIdColumn;
    @javafx.fxml.FXML
    private TextField flightIdTextField;
    @javafx.fxml.FXML
    private TextField airlineIdTextField;
    @javafx.fxml.FXML
    private Button addFlightButton;

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
        flightIdColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getFlightId()));
        flightNameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getFlightName()));
        airlineIdColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getAirlineId()));
        flightStatusColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty("Scheduled"));
        loadFlights();
    }

    private void loadFlights() {
        flightTable.getItems().setAll(BinaryFileUtility.readObjects(FLIGHT_FILE).stream()
                .filter(Flight.class::isInstance)
                .map(Flight.class::cast)
                .toList());
    }

    @javafx.fxml.FXML
    public void addFlightOnAction(ActionEvent actionEvent) {
        String flightId = flightIdTextField.getText().trim();
        String flightName = flightNameTextField.getText().trim();
        String airlineId = airlineIdTextField.getText().trim();
        String destination = destinationTextField.getText().trim();

        if (flightId.isEmpty() || flightName.isEmpty() || airlineId.isEmpty() || destination.isEmpty()) {
            AlertGenerator.showAlert("Invalid Input", "All flight fields should be filled");
            return;
        }
        if (Flight.checkFlightIdExists(flightId)) {
            AlertGenerator.showAlert("Duplicate Flight", "A flight already exists with this ID");
            return;
        }

        Flight flight = new Flight(flightId, flightName, LocalDate.now(), LocalTime.now(), destination, airlineId);
        if (BinaryFileUtility.writeObjects(FLIGHT_FILE, flight)) {
            loadFlights();
            flightIdTextField.clear();
            flightNameTextField.clear();
            airlineIdTextField.clear();
            destinationTextField.clear();
            AlertGenerator.showAlert("Success", "Flight added successfully");
        } else {
            AlertGenerator.showAlert("Error", "Flight could not be saved");
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
