package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.airport_catering_service.HelloApplication;

import java.io.IOException;

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
    public void loginButtonOnClick(ActionEvent actionEvent) {
    }
}