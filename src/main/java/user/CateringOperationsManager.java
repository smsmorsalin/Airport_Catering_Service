package user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.airport_catering_service.controller.catering_operations_manager.approveOrRejectOrderViewController;
import nonuser.CateringOrder;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CateringOperationsManager extends Employee implements Serializable {

    public CateringOperationsManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public String toString() {
        return "CateringOperationsManager{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", userId=" + userId +
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

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/catering_operations_manager/businessDashboardView.fxml", user);
    }

    @Override
    public boolean updateProfile(){
        return false;
    }

    public void approveOrRejectOrder(ArrayList<Object> cateringOrder){
        boolean b = BinaryFileUtility.overwriteObjects("CateringOrder.bin", cateringOrder);

    }

    public void reviewCateringOrder(ActionEvent event, int orderId, User user){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/catering_operations_manager/approveOrRejectOrderView.fxml"));
            Parent root = loader.load();

            Object controller = loader.getController();
            if(controller instanceof approveOrRejectOrderViewController a){
                a.setOrderId(orderId);
            }

            if (controller instanceof UserReceiver receiver) {
                receiver.setLoggedInUser(user);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            AlertGenerator.showAlert("error", "Scene Switch failed");
        } catch (Exception e) {
            AlertGenerator.showAlert("error", e.getMessage());
        }
    }


}
