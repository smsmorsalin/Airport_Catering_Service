package user;

import java.time.LocalDate;

public class SuperAdmin{
    private final String username;
    private String adminPassword;

    public SuperAdmin(String username, String adminPassword) {
        this.username = username;
        this.adminPassword = adminPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void createNewUser(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String department, String designation, float salary, LocalDate joiningDate){

        if (role.equals("Catering Operations Manager")) {
            int newUserId = User.generateNewId();
            int newEmployeeId = User.generateNewId();

            CateringOperationsManager newManager = new CateringOperationsManager(
//            int userId, String password, String fullName, String role, LocalDate dateOfBirth,
//            String gender, String email, String phone, String address,
//            String status, int employeeId,
//            LocalDate joinDate, String department, String designation, float salary
                    newUserId, password, fullName,role, dateOfBirth, gender, email, phone, address,
                    "active", newEmployeeId, joiningDate, department, designation, salary
            );


        }

    }
}
