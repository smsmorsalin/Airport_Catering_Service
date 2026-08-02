package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class User implements Serializable {
    protected final int userId;
    private String password;
    protected String role;
    protected String fullName;
    protected final LocalDate dateOfBirth;
    protected final String gender;
    protected String email;
    protected String phone;
    protected String address;
    protected String status;
    protected final LocalDate createDate;

    public User(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status) {
        this.userId = generateNewId();
        this.createDate = LocalDate.now();
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
//                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static final User verifyLogin(int userId, String password) {
        if (userId <= 0 || password == null || password.trim().isEmpty()) {
            return null;
        }

        ArrayList<Object> users = BinaryFileUtility.readObjects("User.bin");

        if (users == null || users.isEmpty()) {
            return null;
        }

        for (Object object : users) {

            if (object instanceof User user) {

                if (user.getUserId() == userId &&
                        user.getPassword().equals(password)) {

                    return user;
                }
            }
        }

        return null;
    }

    public static void logout(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/main/airport_catering_service/loginView.fxml");
    }

    public final boolean changePassword(String oldPassword, String newPassword) {
        // if user not valid return false

        if (password.equals(oldPassword)) {
            password = newPassword;
            return true;
        }
        else{
            return false;
        }
    }

    private static int generateNewId(){
        ArrayList<Object> objects =
                BinaryFileUtility.readObjects("User.bin");

        int maximumId = 0;

        if (objects == null || objects.isEmpty()) {
            return 1;
        }

        for (Object object : objects) {
            if (object instanceof User user) {
                if (user.getUserId() > maximumId) {
                    maximumId = user.getUserId();
                }
            }
        }

        return maximumId + 1;
    }

    public abstract void viewDashboard(javafx.event.ActionEvent event, User user);
    public abstract boolean updateProfile();
}
