package nonuser;

import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.databaseAccessor;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductionActivities implements Serializable {
    private final int productionOrderId;
    private String productionStatus;
    private double completionPercentage;
    private String delayAlert;

    private final String airlineName;
    private final String assignedChef;
    private final int totalQuantity;
    private int completedQuantity;
    private int remainingQuantity;

    public ProductionActivities(String airlineName, String assignedChef, int totalQuantity, String productionStatus, double completionPercentage, String delayAlert, int completedQuantity, int remainingQuantity) {
        this.productionOrderId = generateProductionOrderId();
        this.airlineName = airlineName;
        this.assignedChef = assignedChef;
        this.totalQuantity = totalQuantity;
        this.productionStatus = productionStatus;
        this.completionPercentage = completionPercentage;
        this.delayAlert = delayAlert;
        this.completedQuantity = completedQuantity;
        this.remainingQuantity = remainingQuantity;
    }

    public ProductionActivities(int productionOrderId){
        this.productionOrderId = productionOrderId;
        this.airlineName = "";
        this.assignedChef = "";
        this.totalQuantity = 0;
        this.productionStatus = "";
        this.completionPercentage = 0;
        this.delayAlert = "";
        this.completedQuantity = 0;
        this.remainingQuantity = 0;
    }


    public int getProductionOrderId() {
        return productionOrderId;
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

    private static int generateProductionOrderId() {
        return databaseAccessor.generateNewUniqueId("ProductionActivities.bin", "productionOrderId");
    }

    public static boolean updateProductionStatus(int productionOrderId) {

        ArrayList<Object> productionActivitiesList = BinaryFileUtility.readObjects("ProductionActivities.bin");
        if (productionActivitiesList == null || productionActivitiesList.isEmpty()) {
            return false;
        }
        boolean found = false;
        for (Object obj : productionActivitiesList) {
            if (obj instanceof ProductionActivities productionActivities) {
                if (productionActivities.getProductionOrderId() == productionOrderId) {
//                    productionActivities.setProductionStatus(newStatus);
                    found = true;
                }
            }
        }if (!found) {
            return false;
        }return BinaryFileUtility.overwriteObjects("ProductionActivities.bin", productionActivitiesList);
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
