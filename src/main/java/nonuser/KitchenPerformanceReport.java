package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class KitchenPerformanceReport implements Serializable {

    private int reportId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int totalTasks;
    private int completedTasks;
    private int pendingTasks;
    private int mealsPrepared;
    private int rejectedBatches;
    private double efficiencyPercentage;


    public KitchenPerformanceReport(int reportId,
                                    LocalDate fromDate,
                                    LocalDate toDate,
                                    int totalTasks,
                                    int completedTasks,
                                    int pendingTasks,
                                    int mealsPrepared,
                                    int rejectedBatches,
                                    double efficiencyPercentage) {

        this.reportId = reportId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.mealsPrepared = mealsPrepared;
        this.rejectedBatches = rejectedBatches;
        this.efficiencyPercentage = efficiencyPercentage;
    }


    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }


    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }


    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }


    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }


    public int getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }


    public int getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(int pendingTasks) {
        this.pendingTasks = pendingTasks;
    }


    public int getMealsPrepared() {
        return mealsPrepared;
    }

    public void setMealsPrepared(int mealsPrepared) {
        this.mealsPrepared = mealsPrepared;
    }


    public int getRejectedBatches() {
        return rejectedBatches;
    }

    public void setRejectedBatches(int rejectedBatches) {
        this.rejectedBatches = rejectedBatches;
    }


    public double getEfficiencyPercentage() {
        return efficiencyPercentage;
    }

    public void setEfficiencyPercentage(double efficiencyPercentage) {
        this.efficiencyPercentage = efficiencyPercentage;
    }


    @Override
    public String toString() {
        return "KitchenPerformanceReport{" +
                "reportId=" + reportId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", totalTasks=" + totalTasks +
                ", completedTasks=" + completedTasks +
                ", pendingTasks=" + pendingTasks +
                ", mealsPrepared=" + mealsPrepared +
                ", rejectedBatches=" + rejectedBatches +
                ", efficiencyPercentage=" + efficiencyPercentage +
                '}';
    }
}