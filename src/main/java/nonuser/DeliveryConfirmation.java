package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class DeliveryConfirmation implements Serializable {
    private final int orderId;
    private final String receiverName;
    private final LocalDate deliveredDate;

    public DeliveryConfirmation(int orderId, String receiverName, LocalDate deliveredDate) {
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.deliveredDate = deliveredDate;
    }
}
