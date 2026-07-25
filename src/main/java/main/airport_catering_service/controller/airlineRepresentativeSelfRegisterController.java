package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class airlineRepresentativeSelfRegisterController
{
    @javafx.fxml.FXML
    private TextField fxidUsernameTextField;
    @javafx.fxml.FXML
    private TextField fxidFullNameTextField;
    @javafx.fxml.FXML
    private ComboBox fxidAirlineComboBox;
    @javafx.fxml.FXML
    private TextField fxidPhoneNumberTextField;
    @javafx.fxml.FXML
    private TextField fxidNewPasswordTextField;
    @javafx.fxml.FXML
    private TextField fxidConfirmPasswordTextField;
    @javafx.fxml.FXML
    private AnchorPane reg_anchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void supportTeamButtonOnClick(Event event) {
    }

    @javafx.fxml.FXML
    public void registerButtonOnClick(ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void loginButtonOnClick(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/airport_catering_service/loginView.fxml"));
        Node node = loader.load();
        reg_anchorPane.getChildren().setAll(node);
    }
}