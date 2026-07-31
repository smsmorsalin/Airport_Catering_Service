package nonuser;

public class Meal {
    private int mealId;
    private String mealName;
    private float mealPrice;

    public Meal(int mealId, String mealName, float mealPrice) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public float getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(float mealPrice) {
        this.mealPrice = mealPrice;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealPrice=" + mealPrice +
                '}';
    }
}
