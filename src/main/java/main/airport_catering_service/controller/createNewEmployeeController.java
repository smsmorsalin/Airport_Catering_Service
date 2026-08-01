package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.SuperAdmin;
import user.User;

import java.io.IOException;
import java.util.Objects;

public class createNewEmployeeController
{
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField addressTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private TextField confirmPasswordTextField;
    @javafx.fxml.FXML
    private TextField salaryTextField;
    @javafx.fxml.FXML
    private TextField departmentTextField;
    @javafx.fxml.FXML
    private TextField fullNameField;
    @javafx.fxml.FXML
    private Label designationTextField111;
    @javafx.fxml.FXML
    private Label designationTextField1;
    @javafx.fxml.FXML
    private ComboBox<String> genderComboBox;
    @javafx.fxml.FXML
    private TextField designationTextField;
    @javafx.fxml.FXML
    private TextField newPasswordTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDatePicker;
    @javafx.fxml.FXML
    private TextField emailAddressTextField;
    @javafx.fxml.FXML
    private Label designationTextField11;

    SuperAdmin s = null;
    @javafx.fxml.FXML
    private DatePicker joiningDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        genderComboBox.getItems().addAll("Male", "Female", "Other");
        roleComboBox.getItems().addAll("Catering Operations Manager",
                "Customer Support Officer", "Dispatch Coordinator",
                "Finance And Billing Manager", "Food Quality Control Officer", "Head Chef",
                "Inventory Manager", "Kitchen Production Manager", "Truck Operator");

        s = new SuperAdmin("admin", "123");
    }

    @javafx.fxml.FXML
    public void createNewUserButtonOnAction(ActionEvent actionEvent) throws IOException {

//        String password, String fullName, String role, String dateOfBirth,
//                String gender, String email, String phone, String address,
//                String department, String designation, float salary
        s.createNewUser(
                confirmPasswordTextField.getText(),
                fullNameField.getText(),
                roleComboBox.getValue(),
                dateOfBirthDatePicker.getValue(),
                genderComboBox.getValue(),
                emailAddressTextField.getText(),
                phoneNumberTextField.getText(),
                addressTextField.getText(),
                departmentTextField.getText(),
                designationTextField.getText(),
                Float.parseFloat(salaryTextField.getText()),
                joiningDateDatePicker.getValue()
        );
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Want to go login Page?");
        a.setContentText("if you click yes you will go to login page. otherwise you will stay here");
        a.showAndWait();

        if (a.isResizable()) return;
        User.logout(actionEvent);
    }
}