package nonuser;

import java.io.Serializable;

public class MealPreparation implements Serializable {

    private int preparationId;
    private int taskId;
    private String mealCategory;
    private String assignedTeam;
    private String instructions;
    private String specialRequirements;
    private String status;


    public MealPreparation(int preparationId, int taskId,
                           String mealCategory,
                           String assignedTeam,
                           String instructions,
                           String specialRequirements,
                           String status) {

        this.preparationId = preparationId;
        this.taskId = taskId;
        this.mealCategory = mealCategory;
        this.assignedTeam = assignedTeam;
        this.instructions = instructions;
        this.specialRequirements = specialRequirements;
        this.status = status;
    }


    public int getPreparationId() {
        return preparationId;
    }

    public void setPreparationId(int preparationId) {
        this.preparationId = preparationId;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }


    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "MealPreparation{" +
                "preparationId=" + preparationId +
                ", taskId=" + taskId +
                ", mealCategory='" + mealCategory + '\'' +
                ", assignedTeam='" + assignedTeam + '\'' +
                ", instructions='" + instructions + '\'' +
                ", specialRequirements='" + specialRequirements + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
