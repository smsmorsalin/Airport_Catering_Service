package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class DeliveryStatus implements Serializable {
    private final int deliveryId;
    private final String receiverName;
    private final LocalDate deliveryDate;
    private final int deliverBy;

    public DeliveryStatus(int deliveryId, String receiverName, LocalDate deliveryDate, int deliverBy) {
        this.deliveryId = deliveryId;
        this.receiverName = receiverName;
        this.deliveryDate = deliveryDate;
        this.deliverBy = deliverBy;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public int getDeliverBy() {
        return deliverBy;
    }
}
