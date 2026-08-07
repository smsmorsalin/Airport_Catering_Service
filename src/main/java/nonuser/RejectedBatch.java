package nonuser;

import java.io.Serializable;

public class RejectedBatch implements Serializable {

    private int batchId;
    private int taskId;
    private String mealType;
    private String rejectedBy;
    private String rejectionReason;
    private String assignedTeam;
    private String status;
    private String correctiveAction;


    public RejectedBatch(int batchId, int taskId,
                         String mealType,
                         String rejectedBy,
                         String rejectionReason,
                         String assignedTeam,
                         String status,
                         String correctiveAction) {

        this.batchId = batchId;
        this.taskId = taskId;
        this.mealType = mealType;
        this.rejectedBy = rejectedBy;
        this.rejectionReason = rejectionReason;
        this.assignedTeam = assignedTeam;
        this.status = status;
        this.correctiveAction = correctiveAction;
    }


    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }


    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }


    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }


    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }


    @Override
    public String toString() {
        return "RejectedBatch{" +
                "batchId=" + batchId +
                ", taskId=" + taskId +
                ", mealType='" + mealType + '\'' +
                ", rejectedBy='" + rejectedBy + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", assignedTeam='" + assignedTeam + '\'' +
                ", status='" + status + '\'' +
                ", correctiveAction='" + correctiveAction + '\'' +
                '}';
    }
}
