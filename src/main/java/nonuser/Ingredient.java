package nonuser;

public class Ingredient {
    private final int ingredientId, unit;
    private String ingredientName;
    private double quantity;
    private Integer estimatedCost;

    public Ingredient(int ingredientId, int unit, String ingredientName, double quantity, Integer estimatedCost) {
        this.ingredientId = ingredientId;
        this.unit = unit;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.estimatedCost = estimatedCost;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public int getUnit() {
        return unit;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Integer getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Integer estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
