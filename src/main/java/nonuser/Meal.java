package nonuser;

import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.databaseAccessor;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {
    private int mealId;
    private String mealName;
    private float mealPrice;

    public Meal(String mealName, float mealPrice) {
        this.mealId = generateMealId();
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


    private static int generateMealId(){

        return databaseAccessor.generateNewUniqueId("Meal.bin", "mealId");
    }

    public static Meal searchMealExistent(int mealId){
        ArrayList<Object> mealArrayList;

        mealArrayList = BinaryFileUtility.readObjects("Meal.bin");

        if (mealArrayList == null || mealArrayList.isEmpty()){
            AlertGenerator.showAlert("Error", "No data in Meal file");
            return null;
        }
        for (Object obj : mealArrayList){
            if (obj instanceof Meal meal){
                if (meal.getMealId() == mealId){
                    return meal;
                }
            }
        }
        AlertGenerator.showAlert("Error", "Meal Not Exist in database");
        return null;
    }


    public static ProductionPlan searchProductionPlanExistent(int productionId) {
        ArrayList<Object> productionPlanArrayList =
                BinaryFileUtility.readObjects("ProductionPlan.bin");
        if (productionPlanArrayList == null || productionPlanArrayList.isEmpty()) {
            AlertGenerator.showAlert(
                    "Error",
                    "No data in Production Plan file"
            );
            return null;
        }

        for (Object obj : productionPlanArrayList) {

            if (obj instanceof ProductionPlan productionPlan) {

                if (productionPlan.getProductionId() == productionId) {
                    return productionPlan;
                }
            }
        }

        AlertGenerator.showAlert(
                "Error",
                "Production Plan does not exist"
        );

        return null;
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
