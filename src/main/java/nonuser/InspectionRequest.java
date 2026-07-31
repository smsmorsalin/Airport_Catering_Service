package nonuser;

public class InspectionRequest {
    private final int inspectionRequestId;
    private final int productionOrderId;

    public InspectionRequest(int inspectionRequestId, int productionOrderId) {
        this.inspectionRequestId = inspectionRequestId;
        this.productionOrderId = productionOrderId;
    }

    public int getInspectionRequestId() {
        return inspectionRequestId;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    @Override
    public String toString() {
        return "InspectionRequest{" +
                "inspectionRequestId=" + inspectionRequestId +
                ", productionOrderId=" + productionOrderId +
                '}';
    }
}
