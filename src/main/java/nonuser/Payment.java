package nonuser;

import java.io.Serializable;

public class Payment implements Serializable {
    private static final String FILE_NAME = "Payment.bin";
    private final String paymentId;
    private final String invoiceId;
    private final double amount;
    private final String method;
    private final String transactionReference;
    private final java.time.LocalDate paymentDate;
    private String status;

    public Payment(String invoiceId, double amount, String method,
                   String transactionReference, java.time.LocalDate paymentDate) {
        paymentId = "PAY-" + utility.databaseAccessor.generateNewUniqueStringId(FILE_NAME, "paymentId");
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.method = method;
        this.transactionReference = transactionReference;
        this.paymentDate = paymentDate;
        status = "Completed";
    }

    public String getPaymentId() { return paymentId; }
    public String getInvoiceId() { return invoiceId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getTransactionReference() { return transactionReference; }
    public java.time.LocalDate getPaymentDate() { return paymentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
