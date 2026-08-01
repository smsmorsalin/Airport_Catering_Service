package nonuser;

public class ProductionActivities {
    private final int productionOrderId;
    private String productionStatus;
    private double completionPercentage;
    private String delayAlert;

    private final String airlineName;
    private final String assignedChef;
    private final int totalQuantity;
    private int completedQuantity;
    private int remainingQuantity;

    public ProductionActivities(int productionOrderId, String airlineName, String assignedChef, int totalQuantity, String productionStatus, double completionPercentage, String delayAlert, int completedQuantity, int remainingQuantity) {
        this.productionOrderId = productionOrderId;
        this.airlineName = airlineName;
        this.assignedChef = assignedChef;
        this.totalQuantity = totalQuantity;
        this.productionStatus = productionStatus;
        this.completionPercentage = completionPercentage;
        this.delayAlert = delayAlert;
        this.completedQuantity = completedQuantity;
        this.remainingQuantity = remainingQuantity;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(double completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public String getDelayAlert() {
        return delayAlert;
    }

    public void setDelayAlert(String delayAlert) {
        this.delayAlert = delayAlert;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAssignedChef() {
        return assignedChef;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(int completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    @Override
    public String toString() {
        return "ProductionActivities{" +
                "productionOrderId=" + productionOrderId +
                ", productionStatus='" + productionStatus + '\'' +
                ", completionPercentage=" + completionPercentage +
                ", delayAlert='" + delayAlert + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", assignedChef='" + assignedChef + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", completedQuantity=" + completedQuantity +
                ", remainingQuantity=" + remainingQuantity +
                '}';
    }
}
