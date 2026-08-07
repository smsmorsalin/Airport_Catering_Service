package nonuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ProductionPlan implements Serializable {
    private final int productionId;
    private LocalDate productionDate;
    private LocalTime targetTime, StartTime, endTime;
    private String workShift, stage;

    public ProductionPlan(int productionId, LocalDate productionDate, LocalTime targetTime, LocalTime startTime, LocalTime endTime, String workShift, String stage) {
        this.productionId = productionId;
        this.productionDate = productionDate;
        this.targetTime = targetTime;
        this.StartTime = startTime;
        this.endTime = endTime;
        this.workShift = workShift;
        this.stage = stage;
    }

    public ProductionPlan(int productionId, LocalTime startTime,LocalTime endTime, String workShift) {
        this.productionId = productionId;
        this.productionDate = null;
        this.targetTime = null;
        this.StartTime = startTime;
        this.endTime = endTime;
        this.workShift = workShift;
        this.stage = "";
    }

    public int getProductionId() {
        return productionId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalTime getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(LocalTime targetTime) {
        this.targetTime = targetTime;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime startTime) {
        StartTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "ProductionPlan{" +
                "productionId=" + productionId +
                ", productionDate=" + productionDate +
                ", targetTime=" + targetTime +
                ", StartTime=" + StartTime +
                ", endTime=" + endTime +
                ", workShift='" + workShift + '\'' +
                ", stage='" + stage + '\'' +
                '}';
    }
}
