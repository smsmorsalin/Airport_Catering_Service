package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;

public final class OrderItem implements Serializable {
    private final String itemId;
    private Meal meal; //FF
    private int quantity;

    public OrderItem(Meal meal, int quantity) {
        this.itemId = generateItemId();
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

    private static String generateItemId(){
        return databaseAccessor.generateNewUniqueStringId("OrderItem.bin", "itemId");
    }
}
