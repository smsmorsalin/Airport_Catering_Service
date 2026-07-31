package nonuser;

public class IngredientRequirement {
    private final int ingredientRequirementId;
    private final int productionOrderId;
    private String ingredientName;
    private double quantityRequired;
    private String unit;
    private double estimatedCost;

    public IngredientRequirement(int ingredientRequirementId, int productionOrderId, String ingredientName, double quantityRequired, String unit, double estimatedCost) {
        this.ingredientRequirementId = ingredientRequirementId;
        this.productionOrderId = productionOrderId;
        this.ingredientName = ingredientName;
        this.quantityRequired = quantityRequired;
        this.unit = unit;
        this.estimatedCost = estimatedCost;
    }

    public int getIngredientRequirementId() {
        return ingredientRequirementId;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(double quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    @Override
    public String toString() {
        return "IngredientRequirement{" +
                "ingredientRequirmentId=" + ingredientRequirementId +
                ", productionOrderId=" + productionOrderId +
                ", ingredientName='" + ingredientName + '\'' +
                ", quantityRequired=" + quantityRequired +
                ", unit='" + unit + '\'' +
                ", estimatedCost=" + estimatedCost +
                '}';
    }
}
