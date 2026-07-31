package nonuser;

import java.time.LocalDate;

public class DeliveryConfirmation {
    private final int orderId;
    private final String receiverName;
    private final LocalDate deliveredDate;

    public DeliveryConfirmation(int orderId, String receiverName, LocalDate deliveredDate) {
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.deliveredDate = deliveredDate;
    }
}
