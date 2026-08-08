package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class QualityInspectionRequest implements Serializable {

    private int requestId;
    private int taskId;
    private String mealCategory;
    private LocalDate inspectionDate;
    private String priority;
    private String remarks;
    private String inspectionStatus;


    public QualityInspectionRequest(int requestId,
                                    int taskId,
                                    String mealCategory,
                                    LocalDate inspectionDate,
                                    String priority,
                                    String remarks,
                                    String inspectionStatus) {

        this.requestId = requestId;
        this.taskId = taskId;
        this.mealCategory = mealCategory;
        this.inspectionDate = inspectionDate;
        this.priority = priority;
        this.remarks = remarks;
        this.inspectionStatus = inspectionStatus;
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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


    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }


    @Override
    public String toString() {
        return "QualityInspectionRequest{" +
                "requestId=" + requestId +
                ", taskId=" + taskId +
                ", mealCategory='" + mealCategory + '\'' +
                ", inspectionDate=" + inspectionDate +
                ", priority='" + priority + '\'' +
                ", remarks='" + remarks + '\'' +
                ", inspectionStatus='" + inspectionStatus + '\'' +
                '}';
    }
}