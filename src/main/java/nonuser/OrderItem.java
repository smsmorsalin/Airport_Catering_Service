package nonuser;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private final String itemId;
    private Meal meal; //FF
    private int quantity;

    public OrderItem(String itemId, Meal meal, int quantity) {
        this.itemId = itemId;
        this.meal = meal;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMealName() {
        if (meal == null) {
            return "";
        }

        return meal.getMealName();
    }

    public int getMealId() {
        if (meal == null) {
            return 0;
        }

        return meal.getMealId();
    }
}
