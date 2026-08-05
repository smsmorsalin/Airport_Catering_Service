package nonuser;

import utility.databaseAccessor;

import java.io.*;
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

    public static Invoice searchInvoiceByOrderId(int orderId){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Invoice.bin"))) {

            while (true) {

                Object object = ois.readObject();

                if (object instanceof Invoice invoice) {

                    if (invoice.getOrderId() == orderId) {
                        return invoice;
                    }
                }
            }

        } catch (EOFException e) {
            // End of file reached normally
            System.out.println("Invoice not found for Order ID: " + orderId);

        } catch (FileNotFoundException e) {
            System.out.println("Invoice.bin file not found");

        } catch (InvalidClassException e) {
            System.out.println("Invoice class version does not match the file");

        } catch (IOException e) {
            System.out.println("Error reading Invoice.bin");

        } catch (ClassNotFoundException e) {
            System.out.println("Invoice class not found");
        }

        return null;
    }
}
