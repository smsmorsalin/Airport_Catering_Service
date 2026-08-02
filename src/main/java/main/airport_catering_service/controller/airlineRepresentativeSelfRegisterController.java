package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.Airline;
import user.AirlineRepresentative;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.util.ArrayList;

public class airlineRepresentativeSelfRegisterController
{
    @javafx.fxml.FXML
    private TextField fxidFullNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fxidAirlineComboBox;
    @javafx.fxml.FXML
    private TextField fxidPhoneNumberTextField;
    @javafx.fxml.FXML
    private TextField fxidNewPasswordTextField;
    @javafx.fxml.FXML
    private TextField fxidConfirmPasswordTextField;
    @javafx.fxml.FXML
    private AnchorPane reg_anchorPane;
    @javafx.fxml.FXML
    private DatePicker fxidDateOfBirthDatePicker;
    @javafx.fxml.FXML
    private TextField fxidEmailAddressTextField;
    @javafx.fxml.FXML
    private TextField fxidOfficeContactNumberField;
    @javafx.fxml.FXML
    private ComboBox<String> fxidGenderComboBox;
    @javafx.fxml.FXML
    private TextField fxidAddressTextField;

    @javafx.fxml.FXML
    public void initialize() {
        fxidGenderComboBox.getItems().addAll("Male", "Female", "Other");

        ArrayList<Object> airlineList = BinaryFileUtility.readObjects("Airline.bin");
        if (airlineList != null) {
            for (Object object : airlineList) {
                if (object instanceof Airline airline) {
                    fxidAirlineComboBox.getItems().add(airline.getAirlineId());
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void supportTeamButtonOnClick(Event event) {
    }

    @javafx.fxml.FXML
    public void registerButtonOnClick(ActionEvent actionEvent) throws IOException {
        if (fxidFullNameTextField.getText().trim().isEmpty() ||
                fxidPhoneNumberTextField.getText().trim().isEmpty() ||
                fxidEmailAddressTextField.getText().trim().isEmpty() ||
                fxidAddressTextField.getText().trim().isEmpty() ||
                fxidOfficeContactNumberField.getText().trim().isEmpty() ||
                fxidNewPasswordTextField.getText().isEmpty() ||
                fxidConfirmPasswordTextField.getText().isEmpty() ||
                fxidDateOfBirthDatePicker.getValue() == null ||
                fxidGenderComboBox.getValue() == null ||
                fxidAirlineComboBox.getValue() == null) {

            AlertGenerator.showAlert("Error", "Please fill all the fields.");
            return;
        }

        if (!fxidNewPasswordTextField.getText().equals(fxidConfirmPasswordTextField.getText())) {
            AlertGenerator.showAlert("Error", "Password and Confirm Password do not match.");
            return;
        }

        AirlineRepresentative representative = AirlineRepresentative.createNewAirlineRepresentative(
                        fxidNewPasswordTextField.getText(),
                        fxidFullNameTextField.getText().trim(),
                        fxidDateOfBirthDatePicker.getValue(),
                        fxidGenderComboBox.getValue(),
                        fxidEmailAddressTextField.getText().trim(),
                        fxidPhoneNumberTextField.getText().trim(),
                        fxidAddressTextField.getText().trim(),
                        fxidAirlineComboBox.getValue(),
                        fxidOfficeContactNumberField.getText().trim()
                );

        if (representative == null) {
            AlertGenerator.showAlert("Error", "Registration failed.");
            return;
        }

        AlertGenerator.showAlert("Success",
                "Registration successful.\nYour User ID is: " + representative.getUserId());

        SceneSwitchingHelper.fullSceneReplacement(actionEvent, "/main/airport_catering_service/loginView.fxml");
    }

    @javafx.fxml.FXML
    public void loginButtonOnClick(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/airport_catering_service/loginView.fxml"));
        Node node = loader.load();
        reg_anchorPane.getChildren().setAll(node);
    }
}