package user;

import utility.AlertGenerator;
import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;

public class SuperAdmin implements Serializable {
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

    public void createNewUser(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String department, String designation, float salary, LocalDate joiningDate) {

        int newUserId = User.generateNewId();
        int newEmployeeId = Employee.generateEmployeeId();

        Employee newEmployee = null;

        switch (role) {

            case "Catering Operations Manager":
                newEmployee = new CateringOperationsManager(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Customer Support Officer":
                newEmployee = new CustomerSupportOfficer(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Finance and Billing Manager":
                newEmployee = new FinanceAndBillingManager(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Inventory Manager":
                newEmployee = new InventoryManager(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Dispatch Coordinator":
                newEmployee = new DispatchCoordinator(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Truck Operator":
                newEmployee = new Truckoperator(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Head Chef":
                newEmployee = new Headchef(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Kitchen Production Manager":
                newEmployee = new KitchenProductionManager(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            case "Food Quality Control Officer":
                newEmployee = new FoodQualityControlOfficer(
                        newUserId,
                        password,
                        fullName,
                        role,
                        dateOfBirth,
                        gender,
                        email,
                        phone,
                        address,
                        "Active",
                        newEmployeeId,
                        joiningDate,
                        department,
                        designation,
                        salary
                );
                break;

            default:
                AlertGenerator.showAlert("Error", "Invalid role selected.");
                return;
        }

        if (BinaryFileUtility.writeObjects("User.bin", newEmployee)) {
            AlertGenerator.showAlert("Success", "Employee created successfully.");
        } else {
            AlertGenerator.showAlert("Error", "Failed to save employee.");
        }
    }
}
