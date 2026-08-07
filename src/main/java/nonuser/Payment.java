package nonuser;

import utility.databaseAccessor;

import java.io.*;
import java.time.LocalDate;

public class Payment implements Serializable {
    private final String paymentId;
    private String paymentType;
    private double paymentAmount;
    private final int orderId;
    private final String invoiceId;
    private final String transactionReference;
    private final LocalDate paymentDate;

    public Payment(int orderId, String invoiceId, String paymentType, double paymentAmount, String transactionReference, LocalDate paymentDate) {
        this.paymentId = generatePaymentId();
        this.orderId = orderId;
        this.invoiceId = invoiceId;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.transactionReference = transactionReference;
        this.paymentDate = paymentDate;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    private static String generatePaymentId(){
        String id;
        id = databaseAccessor.generateNewUniqueStringId("Payment.bin", "paymentId");
        return id;
    }

    public static Payment searchPaymentByOrderId(int orderId) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Payment.bin"))) {

            while (true) {

                Object object = ois.readObject();

                if (object instanceof Payment payment) {

                    if (payment.getOrderId() == orderId) {
                        return payment;
                    }
                }
            }

        } catch (EOFException e) {
            // End of file reached normally
            System.out.println("payment not found for Order ID: " + orderId);

        } catch (FileNotFoundException e) {
            System.out.println("payment.bin file not found");

        } catch (InvalidClassException e) {
            System.out.println("payment class version does not match the file");

        } catch (IOException e) {
            System.out.println("Error reading payment.bin");

        } catch (ClassNotFoundException e) {
            System.out.println("payment class not found");
        }

        return null;
    }
}
