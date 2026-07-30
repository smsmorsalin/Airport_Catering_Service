package nonuser;

public class OrderItem {
    private final String iteamId;
    private int mealId; //FF
    private int quantity;

    public OrderItem(String iteamId, int mealId, int quantity) {
        this.iteamId = iteamId;
        this.mealId = mealId;
        this.quantity = quantity;
    }

    public String getIteamId() {
        return iteamId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
