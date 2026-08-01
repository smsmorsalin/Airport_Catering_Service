package nonuser;

public class Inspection {
    private final int inspectionRequestId;
    private final int batchNumber;
    private String mealCategory;
    private String inspectionStatus;

    public Inspection(int inspectionRequestId, int batchNumber, String mealCategory, String inspectionStatus) {
        this.inspectionRequestId = inspectionRequestId;
        this.batchNumber = batchNumber;
        this.mealCategory = mealCategory;
        this.inspectionStatus = inspectionStatus;
    }

    public int getInspectionRequestId() {
        return inspectionRequestId;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }
}
