package user;

import java.time.LocalDate;
import java.util.Random;

public abstract class Employee extends User {

    protected final int employeeId;
    protected String department;
    protected String designation;
    protected final LocalDate joinDate;
    protected String shift;
    protected float salary;

    public Employee(int userId, String password, String fullName, String dateOfBirth, String gender, String email, String phone, String address, String status, int employeeId, LocalDate joinDate, String department, String designation, String shift, float salary) {
        super(userId, password, fullName, dateOfBirth, gender, email, phone, address, status);
        this.employeeId = employeeId;
        this.joinDate = joinDate;
        this.department = department;
        this.designation = designation;
        this.shift = shift;
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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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
                ", shift='" + shift + '\'' +
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

    public static final int generateEmployeeId(){
        boolean tempUniqueIdCheck = false;
        int tempId;
        Random rand = new Random();
        do {
            tempId = rand.nextInt();
//            tempUniqueIdCheck = databaseAccessor.verifyUnique(tempId, "Employee.bin", "employeeId");
//            for Now as a testing purpose: tempId = unique id without verify
        }while(!tempUniqueIdCheck);
        return tempId;
    }


    public abstract boolean performAssignedDuty(String taskId);
    public abstract boolean viewWorkSchedule(LocalDate date);
    public abstract String getEmployeeType();

}
