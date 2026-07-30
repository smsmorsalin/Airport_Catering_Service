package user;

import java.io.IOException;
import java.time.LocalDate;

public class Truckoperator extends Employee {

    public Truckoperator(int userId, String password, String fullName, String role, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status, employeeId, joinDate, department, designation, shift, salary);
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException{

    }

    @Override
    public boolean updateProfile(){
        return true;
    }
}
