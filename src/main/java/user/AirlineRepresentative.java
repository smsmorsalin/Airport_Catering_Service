package nonuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class DeliveryConfirmation implements Serializable {
    private final String confirmationId;
    private int orderId;
    private String receiverName;
    private String confirmedBy;
    private LocalDate confirmationTime;
    private String clientSignature;
    private boolean confirmed;

    // orderId: the CateringOrder being confirmed
    // receiverName: name of the person who received the delivery (client)
    // confirmedBy: how it was confirmed, e.g. "sms", "call", "in-person"
    // confirmationTime: date the confirmation was made
    public DeliveryConfirmation(int orderId, String receiverName, String confirmedBy, LocalDate confirmationTime) {
        this.confirmationId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.confirmedBy = confirmedBy;
        this.confirmationTime = confirmationTime;
        this.confirmed = true;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(String confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public LocalDate getConfirmationTime() {
        return confirmationTime;
    }

    public void setConfirmationTime(LocalDate confirmationTime) {
        this.confirmationTime = confirmationTime;
    }

    public String getClientSignature() {
        return clientSignature;
    }

    public void setClientSignature(String clientSignature) {
        this.clientSignature = clientSignature;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String toString() {
        return "DeliveryConfirmation{" +
                "confirmationId='" + confirmationId + '\'' +
                ", orderId=" + orderId +
                ", receiverName='" + receiverName + '\'' +
                ", confirmedBy='" + confirmedBy + '\'' +
                ", confirmationTime=" + confirmationTime +
                ", clientSignature='" + clientSignature + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}