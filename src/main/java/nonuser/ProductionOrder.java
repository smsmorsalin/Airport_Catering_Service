package nonuser;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProductionOrder {
    public ProductionOrder(int productionOrderId, int productionTaskId, LocalDate deliveryDate, LocalTime deliveryTime, String productionStatus) {
        this.productionOrderId = productionOrderId;
        this.productionTaskId = productionTaskId;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.productionStatus = productionStatus;
    }

    private final int productionOrderId;
    private final int productionTaskId;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private String productionStatus;
}

