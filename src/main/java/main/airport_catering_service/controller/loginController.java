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

    private Stage stage;
    private Scene scene;
    private Parent root;

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
    public void loginButtonOnClick(ActionEvent actionEvent) throws IOException {
        if (fxidUsernameTextField.getText().equals("1")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AirlineRepresentative/dashboardView.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}