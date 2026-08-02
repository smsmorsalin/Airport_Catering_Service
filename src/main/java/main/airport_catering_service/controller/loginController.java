package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import user.AirlineRepresentative;
import user.CateringOperationsManager;
import user.User;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class loginController {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @javafx.fxml.FXML
    private TextField fxidPasswordTextfield;
    @javafx.fxml.FXML
    private TextField fxidUsernameTextField;
    @FXML
    private AnchorPane login_anchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void supportTeamButtonOnClick(Event event) {
    }

    @FXML
    public void registerButtonOnClick(Event event) throws IOException {
       FXMLLoader registerFXML = new FXMLLoader(getClass().getResource("/main/airport_catering_service/airlineRepresentativeSelfRegisterView.fxml"));
       Node node = registerFXML.load();
       login_anchorPane.getChildren().setAll(node);

    }


    @javafx.fxml.FXML
    public void loginButtonOnClick(ActionEvent event) throws IOException {
        String username = fxidUsernameTextField.getText().trim();
        String password = fxidPasswordTextfield.getText();

        /*
         * Check empty fields
         */
        if (username.isEmpty() || password.isEmpty()) {
            AlertGenerator.showAlert(
                    "Validation Error",
                    "Username and password are required."
            );
            return;
        }

        /*
         * Super Admin login
         */
        if (username.equalsIgnoreCase(ADMIN_USERNAME)) {

            if (!password.equals(ADMIN_PASSWORD)) {
                AlertGenerator.showAlert(
                        "Login Error",
                        "Invalid admin password."
                );
                return;
            }

            SceneSwitchingHelper.fullSceneReplacement(
                    event,
                    "/main/airport_catering_service/createNewEmployeeView.fxml"
            );

            return;
        }


//         * Normal users must enter a numeric user ID
        int userId;

        try {
            userId = Integer.parseInt(username);

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Login Error",
                    "User ID must be a number."
            );

            return;
        }


//         * Verify user ID and password from User.bin
        User loggedInUser = User.verifyLogin(userId, password);

        if (loggedInUser == null) {
            AlertGenerator.showAlert(
                    "Login Error",
                    "Invalid user ID or password."
            );
            return;
        }


//         * Open Airline Representative dashboard

        if (loggedInUser instanceof AirlineRepresentative) {

            SceneSwitchingHelper.switchSceneWithData(
                    event,
                    "/airline_representative/dashboardView.fxml",
                    loggedInUser
            );

            return;
        }


//         * Open Catering Operations Manager dashboard
        if (loggedInUser instanceof CateringOperationsManager) {

            SceneSwitchingHelper.switchSceneWithData(
                    event,
                    "/catering_operations_manager/businessDashboardView.fxml",
                    loggedInUser
            );

            return;
        }


//         * The user exists, but no dashboard is configured
        AlertGenerator.showAlert(
                "Login Error",
                "No dashboard is configured for this user role."
        );

    }
}