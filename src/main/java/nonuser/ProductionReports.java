package nonuser;

import java.time.LocalDate;

public class ProductionReports {
    private final int productionReportId;

    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalProductionOrders;
    private int totalMealsProduced;
    private double averageProductionTime;
    private int rejectedFoodBatches;
    private int reworkedBatches;
    private String staffProductivitySummary;
    private double productionEfficiencyRate;

    public ProductionReports(int productionReportId, String reportType, LocalDate startDate, LocalDate endDate, int totalProductionOrders, int totalMealsProduced, double averageProductionTime, int rejectedFoodBatches, int reworkedBatches, String staffProductivitySummary, double productionEfficiencyRate) {
        this.productionReportId = productionReportId;
        this.reportType = reportType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalProductionOrders = totalProductionOrders;
        this.totalMealsProduced = totalMealsProduced;
        this.averageProductionTime = averageProductionTime;
        this.rejectedFoodBatches = rejectedFoodBatches;
        this.reworkedBatches = reworkedBatches;
        this.staffProductivitySummary = staffProductivitySummary;
        this.productionEfficiencyRate = productionEfficiencyRate;
    }

    public int getProductionReportId() {
        return productionReportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTotalProductionOrders() {
        return totalProductionOrders;
    }

    public void setTotalProductionOrders(int totalProductionOrders) {
        this.totalProductionOrders = totalProductionOrders;
    }

    public int getTotalMealsProduced() {
        return totalMealsProduced;
    }

    public void setTotalMealsProduced(int totalMealsProduced) {
        this.totalMealsProduced = totalMealsProduced;
    }

    public double getAverageProductionTime() {
        return averageProductionTime;
    }

    public void setAverageProductionTime(double averageProductionTime) {
        this.averageProductionTime = averageProductionTime;
    }

    public int getRejectedFoodBatches() {
        return rejectedFoodBatches;
    }

    public void setRejectedFoodBatches(int rejectedFoodBatches) {
        this.rejectedFoodBatches = rejectedFoodBatches;
    }

    public int getReworkedBatches() {
        return reworkedBatches;
    }

    public void setReworkedBatches(int reworkedBatches) {
        this.reworkedBatches = reworkedBatches;
    }

    public String getStaffProductivitySummary() {
        return staffProductivitySummary;
    }

    public void setStaffProductivitySummary(String staffProductivitySummary) {
        this.staffProductivitySummary = staffProductivitySummary;
    }

    public double getProductionEfficiencyRate() {
        return productionEfficiencyRate;
    }

    public void setProductionEfficiencyRate(double productionEfficiencyRate) {
        this.productionEfficiencyRate = productionEfficiencyRate;
    }

    @Override
    public String toString() {
        return "ProductionReports{" +
                "productionReportId=" + productionReportId +
                ", reportType='" + reportType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalProductionOrders=" + totalProductionOrders +
                ", totalMealsProduced=" + totalMealsProduced +
                ", averageProductionTime=" + averageProductionTime +
                ", rejectedFoodBatches=" + rejectedFoodBatches +
                ", reworkedBatches=" + reworkedBatches +
                ", staffProductivitySummary='" + staffProductivitySummary + '\'' +
                ", productionEfficiencyRate=" + productionEfficiencyRate +
                '}';
    }
}
