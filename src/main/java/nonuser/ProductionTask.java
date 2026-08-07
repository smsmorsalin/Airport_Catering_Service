package nonuser;

import java.io.Serializable;

public class ProductionTask implements Serializable {

    private int taskId;
    private int orderId;
    private String mealType;
    private int mealQuantity;
    private String priority;
    private String airline;
    private String flight;
    private String completionTime;
    private String status;


    public ProductionTask(int taskId, int orderId, String mealType,
                          int mealQuantity, String priority,
                          String airline, String flight,
                          String completionTime, String status) {

        this.taskId = taskId;
        this.orderId = orderId;
        this.mealType = mealType;
        this.mealQuantity = mealQuantity;
        this.priority = priority;
        this.airline = airline;
        this.flight = flight;
        this.completionTime = completionTime;
        this.status = status;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }


    public int getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(int mealQuantity) {
        this.mealQuantity = mealQuantity;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }


    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }


    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ProductionTask{" +
                "taskId=" + taskId +
                ", orderId=" + orderId +
                ", mealType='" + mealType + '\'' +
                ", mealQuantity=" + mealQuantity +
                ", priority='" + priority + '\'' +
                ", airline='" + airline + '\'' +
                ", flight='" + flight + '\'' +
                ", completionTime='" + completionTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}