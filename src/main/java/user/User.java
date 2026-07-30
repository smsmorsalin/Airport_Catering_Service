package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public abstract class User {
    protected final int userId;
    private String password;
    protected String role;
    protected String fullName;
    protected final String dateOfBirth;
    protected final String gender;
    protected String email;
    protected String phone;
    protected String address;
    protected String status;
    protected final LocalDate createDate;

    public User(int userId, String password, String fullName, String role, String dateOfBirth, String gender, String email, String phone, String address, String status) {
        this.userId = userId;
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

    public String getDateOfBirth() {
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
        User user = null;
        if  (userId == 0 || password.isEmpty()) {
            return user;
        }
        // if: user in database/files then check the password for this user. if match then return the user object
        //else: return null
        return user;
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

    public final static int generateNewId(){
        int tempId = (int) databaseAccessor.generateNewUniqueId("User.bin", "userId");
        return tempId;
    }

    public abstract void viewDashboard(javafx.event.ActionEvent event) throws IOException;
    public abstract boolean updateProfile();
}
