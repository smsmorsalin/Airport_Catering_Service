package nonuser;

import utility.databaseAccessor;

import java.time.LocalDate;

public class Invoice {
    private final String invoiceId;
    private final int orderId;
    private double totalAmount;
    private LocalDate dueDate;
    private boolean isPaid;

    public Invoice(int orderId, double totalAmount, LocalDate dueDate, boolean isPaid) {
        this.invoiceId = generateInvoiceId();
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    private static String generateInvoiceId(){
        String id;
        id = databaseAccessor.generateNewUniqueStringId("Invoice.bin", "InvoiceId");
        return id;
    }
}
