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
import main.airport_catering_service.HelloApplication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Objects;

public class loginController
{
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

        //optimize solution
//        userObject.viewDashboard();

        if (fxidUsernameTextField.getText().equals("1")){
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/AirlineRepresentative/dashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Airline Representative");
            stage.setScene(scene);
            stage.show();

        } else if (fxidUsernameTextField.getText().equals("2")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/CateringOperationsManager/businessDashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Catering Operations Manager");
            stage.setScene(scene);
            stage.show();
        }
    }
}