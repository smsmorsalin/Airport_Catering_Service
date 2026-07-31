package nonuser;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProductionPlan {

    private final int productionPlanId;
    private final int productionOrderId;
    private LocalDate productionDate;
    private LocalTime targetCompletionTime;
    private String specialInstructions;
    private String mealCategories;

    public ProductionPlan(int productionPlanId, int productionOrderId, LocalDate productionDate, LocalTime targetCompletionTime, String specialInstructions, String mealCategories) {
        this.productionPlanId = productionPlanId;
        this.productionOrderId = productionOrderId;
        this.productionDate = productionDate;
        this.targetCompletionTime = targetCompletionTime;
        this.specialInstructions = specialInstructions;
        this.mealCategories = mealCategories;
    }

    public int getProductionPlanId() {
        return productionPlanId;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalTime getTargetCompletionTime() {
        return targetCompletionTime;
    }

    public void setTargetCompletionTime(LocalTime targetCompletionTime) {
        this.targetCompletionTime = targetCompletionTime;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getMealCategories() {
        return mealCategories;
    }

    public void setMealCategories(String mealCategories) {
        this.mealCategories = mealCategories;
    }

    @Override
    public String toString() {
        return "ProductionPlan{" +
                "productionPlanId=" + productionPlanId +
                ", productionOrderId=" + productionOrderId +
                ", productionDate=" + productionDate +
                ", targetCompletionTime=" + targetCompletionTime +
                ", specialInstructions='" + specialInstructions + '\'' +
                ", mealCategories='" + mealCategories + '\'' +
                '}';
    }
}
