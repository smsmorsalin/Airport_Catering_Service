package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class RefundRecord implements Serializable {
    private final String refundId;
    private final String paymentId;
    private final int orderId;
    private final double amount;
    private final String reason;
    private final String method;
    private final String notes;
    private final LocalDate refundDate;
    private final int processedByEmployeeId;
    private String status;

    public RefundRecord(String paymentId, int orderId, double amount, String reason,
                        String method, String notes, int processedByEmployeeId) {
        refundId = "REF-" + java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.reason = reason;
        this.method = method;
        this.notes = notes;
        this.processedByEmployeeId = processedByEmployeeId;
        refundDate = LocalDate.now();
        status = "Processed";
    }

    public String getRefundId() { return refundId; }
    public String getPaymentId() { return paymentId; }
    public int getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getReason() { return reason; }
    public String getMethod() { return method; }
    public String getNotes() { return notes; }
    public LocalDate getRefundDate() { return refundDate; }
    public int getProcessedByEmployeeId() { return processedByEmployeeId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
