package nonuser;

public class ProductionCompletion {

    private final int approvalId;
    private final int productionOrderId;
    private String completionNotes;

    public ProductionCompletion(int approvalId, int productionOrderId, String completionNotes) {
        this.approvalId = approvalId;
        this.productionOrderId = productionOrderId;
        this.completionNotes = completionNotes;
    }

    public int getApprovalId() {
        return approvalId;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public String getCompletionNotes() {
        return completionNotes;
    }

    public void setCompletionNotes(String completionNotes) {
        this.completionNotes = completionNotes;
    }

    @Override
    public String toString() {
        return "ProductionCompletion{" +
                "approvalId=" + approvalId +
                ", productionOrderId=" + productionOrderId +
                ", completionNotes='" + completionNotes + '\'' +
                '}';
    }
}
