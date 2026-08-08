package nonuser;

import java.io.Serializable;

public class CookingProgress implements Serializable {

    private int taskId;
    private String mealCategory;
    private String assignedTeam;
    private int progressPercentage;
    private String estimatedTime;
    private String status;
    private String remarks;


    public CookingProgress(int taskId,
                           String mealCategory,
                           String assignedTeam,
                           int progressPercentage,
                           String estimatedTime,
                           String status,
                           String remarks) {

        this.taskId = taskId;
        this.mealCategory = mealCategory;
        this.assignedTeam = assignedTeam;
        this.progressPercentage = progressPercentage;
        this.estimatedTime = estimatedTime;
        this.status = status;
        this.remarks = remarks;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }


    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }


    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }


    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "CookingProgress{" +
                "taskId=" + taskId +
                ", mealCategory='" + mealCategory + '\'' +
                ", assignedTeam='" + assignedTeam + '\'' +
                ", progressPercentage=" + progressPercentage +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}