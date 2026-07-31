package nonuser;

public class ProductionTask {

    private final int productionTaskId;
    private final int orderId;

    public ProductionTask(int productionTaskId, int orderId) {
        this.productionTaskId = productionTaskId;
        this.orderId = orderId;
    }

    public int getProductionTaskId() {
        return productionTaskId;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "ProductionTask{" +
                "productionTaskId=" + productionTaskId +
                ", orderId=" + orderId +
                '}';
    }
}
