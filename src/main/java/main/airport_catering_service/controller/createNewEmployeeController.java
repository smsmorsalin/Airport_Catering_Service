package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.SuperAdmin;

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
    public void createNewUserButtonOnAction(ActionEvent actionEvent) {

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
    }
}