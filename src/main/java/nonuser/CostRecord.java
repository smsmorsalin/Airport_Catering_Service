package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDate;

public class CostRecord implements Serializable {
    private static final String FILE_NAME = "CostRecord.bin";
    private final int recordId;
    private final int orderId;
    private final double rawMaterialCost;
    private final double ingredientCost;
    private final double productionCost;
    private final double operationalCost;
    private final double packagingCost;
    private final double transportationCost;
    private final LocalDate recordDate;

    public CostRecord(int orderId, double rawMaterialCost, double ingredientCost,
                      double productionCost, double operationalCost,
                      double packagingCost, double transportationCost,
                      LocalDate recordDate) {
        recordId = databaseAccessor.generateNewUniqueId(FILE_NAME, "recordId");
        this.orderId = orderId;
        this.rawMaterialCost = rawMaterialCost;
        this.ingredientCost = ingredientCost;
        this.productionCost = productionCost;
        this.operationalCost = operationalCost;
        this.packagingCost = packagingCost;
        this.transportationCost = transportationCost;
        this.recordDate = recordDate;
    }

    public int getRecordId() { return recordId; }
    public int getOrderId() { return orderId; }
    public double getRawMaterialCost() { return rawMaterialCost; }
    public double getIngredientCost() { return ingredientCost; }
    public double getProductionCost() { return productionCost; }
    public double getOperationalCost() { return operationalCost; }
    public double getPackagingCost() { return packagingCost; }
    public double getTransportationCost() { return transportationCost; }
    public LocalDate getRecordDate() { return recordDate; }
    public double getTotal() {
        return rawMaterialCost + ingredientCost + productionCost
                + operationalCost + packagingCost + transportationCost;
    }
}
