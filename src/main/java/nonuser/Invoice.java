package nonuser;

import java.time.LocalDate;

public class Invoice {
    private final String invoiceId;
    private final int orderId;
    private double totalAmount;
    private LocalDate dueDate;
    private boolean isPaid;

    public Invoice(String invoiceId, int orderId, double totalAmount, LocalDate dueDate, boolean isPaid) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }
}
