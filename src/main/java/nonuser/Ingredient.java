package nonuser;

public class Ingredient {
    private final int ingredientId, unit;
    private String ingredientName;
    private double quantity;
    private Integer estimatedCost;
    private double PricePerUnit;

    public Ingredient(int ingredientId, int unit, String ingredientName, double quantity, Integer estimatedCost, double pricePerUnit) {
        this.ingredientId = ingredientId;
        this.unit = unit;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.estimatedCost = estimatedCost;
        this.PricePerUnit = pricePerUnit;
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

    public double getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        PricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", unit=" + unit +
                ", ingredientName='" + ingredientName + '\'' +
                ", quantity=" + quantity +
                ", estimatedCost=" + estimatedCost +
                ", PricePerUnit=" + PricePerUnit +
                '}';
    }
}
