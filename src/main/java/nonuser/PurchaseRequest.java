package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDate;

public class PurchaseRequest implements Serializable {
    private int ingredientId;
    private String ingredientName;
    private int quantity;
    private String supplier;
    private LocalDate expectedDeliveryDate;
    private String PurchaseHistory;
    private LocalDate receivingDate;
    private String status;

    public PurchaseRequest(String ingredientName, int quantity, String supplier, LocalDate expectedDeliveryDate) {
        this.ingredientId = generateNewIngredientId();
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.supplier = supplier;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = "Pending";
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getPurchaseHistory() {
        return PurchaseHistory;
    }

    public void setPurchaseHistory(String purchaseHistory) {
        PurchaseHistory = purchaseHistory;
    }

    public LocalDate getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDate receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private static int generateNewIngredientId(){
        return databaseAccessor.generateNewUniqueId("PurchaseRequest.bin", "ingredientId");
    }
}
