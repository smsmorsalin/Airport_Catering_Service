package nonuser;

import java.io.Serializable;

public class KitchenStaffAssignment implements Serializable {

    private int assignmentId;
    private String staffName;
    private String station;
    private String shift;
    private int taskId;
    private String assignedTask;
    private String status;

    public KitchenStaffAssignment(int assignmentId,
                                  String staffName,
                                  String station,
                                  String shift,
                                  int taskId,
                                  String assignedTask,
                                  String status) {

        this.assignmentId = assignmentId;
        this.staffName = staffName;
        this.station = station;
        this.shift = shift;
        this.taskId = taskId;
        this.assignedTask = assignedTask;
        this.status = status;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KitchenStaffAssignment{" +
                "assignmentId=" + assignmentId +
                ", staffName='" + staffName + '\'' +
                ", station='" + station + '\'' +
                ", shift='" + shift + '\'' +
                ", taskId=" + taskId +
                ", assignedTask='" + assignedTask + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}