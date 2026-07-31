package nonuser;

import java.time.LocalTime;

public class ProductionSchedule {

    private final int scheduleId;
    private final int productionPlanId;
    private LocalTime scheduledStartTime;
    private LocalTime scheduledEndTime;
    private String workShift;

    public ProductionSchedule(int scheduleId, int productionPlanId, LocalTime scheduledStartTime, LocalTime scheduledEndTime, String workShift) {
        this.scheduleId = scheduleId;
        this.productionPlanId = productionPlanId;
        this.scheduledStartTime = scheduledStartTime;
        this.scheduledEndTime = scheduledEndTime;
        this.workShift = workShift;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getProductionPlanId() {
        return productionPlanId;
    }

    public LocalTime getScheduledStartTime() {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(LocalTime scheduledStartTime) {
        this.scheduledStartTime = scheduledStartTime;
    }

    public LocalTime getScheduledEndTime() {
        return scheduledEndTime;
    }

    public void setScheduledEndTime(LocalTime scheduledEndTime) {
        this.scheduledEndTime = scheduledEndTime;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    @Override
    public String toString() {
        return "ProductionSchedule{" +
                "scheduleId=" + scheduleId +
                ", productionPlanId=" + productionPlanId +
                ", scheduledStartTime=" + scheduledStartTime +
                ", scheduledEndTime=" + scheduledEndTime +
                ", workShift='" + workShift + '\'' +
                '}';
    }
}
