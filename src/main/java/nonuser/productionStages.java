package nonuser;

import java.time.LocalTime;

public class productionStages {

    private final int productionStageId;
    private final int productionPlanId;
    private String stageName;
    private LocalTime startTime;
    private LocalTime endTime;

    public productionStages(int productionStageId, int productionPlanId, String stageName, LocalTime startTime, LocalTime endTime) {
        this.productionStageId = productionStageId;
        this.productionPlanId = productionPlanId;
        this.stageName = stageName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getProductionStageId() {
        return productionStageId;
    }

    public int getProductionPlanId() {
        return productionPlanId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "productionStages{" +
                "productionStageId=" + productionStageId +
                ", productionPlanId=" + productionPlanId +
                ", stageName='" + stageName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
