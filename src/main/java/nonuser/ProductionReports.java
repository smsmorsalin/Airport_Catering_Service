package nonuser;

import java.time.LocalDate;

public class ProductionReports {

    private final int productionReportId;
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalProductionOrders;
    private int totalMealsProduced;
    private String ingredientConsumption;
    private double productionCompletionRate;
    private int delayedProductions;
    private double resourceUtilization;
    private double averageProductionTime;

    public ProductionReports(int productionReportId) {
        this.productionReportId = productionReportId;
    }
}
