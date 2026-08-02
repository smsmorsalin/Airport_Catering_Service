package user;

import utility.BinaryFileUtility;
import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Employee extends User implements Serializable {

    protected final int employeeId;
    protected String department;
    protected String designation;
    protected final LocalDate joinDate;
    protected float salary;

    public Employee(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status);
        this.employeeId = generateEmployeeId();
        this.joinDate = joinDate;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
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

    public static void submitActivityLog(int employeeId, String action, String description, LocalDate activityTime){
        //code
    }

    private static final int generateEmployeeId(){
        ArrayList<Object> objects = BinaryFileUtility.readObjects("User.bin");

        int maximumId = 0;

        if (objects == null || objects.isEmpty()) {
            return 1001;   // Starting Employee ID
        }

        for (Object object : objects) {
            if (object instanceof Employee employee) {
                if (employee.getEmployeeId() > maximumId) {
                    maximumId = employee.getEmployeeId();
                }
            }
        }
        return maximumId == 0 ? 1001 : maximumId + 1;
    }


}
