package nonuser;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DeliveryAssignment implements Serializable {
    private final String assignmentId;
    private String packageId;
    private String dispatchCoordinatorId;
    private String assignedStaffId;
    private String destination;
    private LocalDateTime assignedTime;
    private String assignmentStatus;

    public DeliveryAssignment(String assignmentId, String packageId, String dispatchCoordinatorId,
                              String assignedStaffId, String destination, LocalDateTime assignedTime) {
        this.assignmentId = assignmentId;
        this.packageId = packageId;
        this.dispatchCoordinatorId = dispatchCoordinatorId;
        this.assignedStaffId = assignedStaffId;
        this.destination = destination;
        this.assignedTime = assignedTime;
        this.assignmentStatus = "ASSIGNED";
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getDispatchCoordinatorId() {
        return dispatchCoordinatorId;
    }

    public void setDispatchCoordinatorId(String dispatchCoordinatorId) {
        this.dispatchCoordinatorId = dispatchCoordinatorId;
    }

    public String getAssignedStaffId() {
        return assignedStaffId;
    }

    public void setAssignedStaffId(String assignedStaffId) {
        this.assignedStaffId = assignedStaffId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(LocalDateTime assignedTime) {
        this.assignedTime = assignedTime;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    // Called by dispatch coordinator to hand off the task
    public void receiveTaskFromDispatch(String dispatchCoordinatorId, String assignedStaffId) {
        this.dispatchCoordinatorId = dispatchCoordinatorId;
        this.assignedStaffId = assignedStaffId;
        this.assignmentStatus = "ASSIGNED";
    }

    @Override
    public String toString() {
        return "DeliveryAssignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", packageId='" + packageId + '\'' +
                ", dispatchCoordinatorId='" + dispatchCoordinatorId + '\'' +
                ", assignedStaffId='" + assignedStaffId + '\'' +
                ", destination='" + destination + '\'' +
                ", assignedTime=" + assignedTime +
                ", assignmentStatus='" + assignmentStatus + '\'' +
                '}';
    }
}