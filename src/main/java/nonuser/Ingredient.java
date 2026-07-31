package nonuser;

public class Ingredient {
    private final int ingredientId;
    private String IngredientName;
    private double Quantity;

    public Ingredient(int ingredientId, String ingredientName, double quantity) {
        this.ingredientId = ingredientId;
        IngredientName = ingredientName;
        Quantity = quantity;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }
}
