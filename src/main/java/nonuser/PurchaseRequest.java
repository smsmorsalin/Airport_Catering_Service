package nonuser;

import utility.databaseAccessor;

import java.time.LocalDate;

public class PurchaseRequest {
    private int ingredientId;
    private String IngredientName;
    private int Quantity;
    private String Supplier;
    private LocalDate expectedDeliveryDate;
    private String PurchaseHistory;
    private LocalDate ReceivingDate;
    private String Status;


    public PurchaseRequest(String ingredientName, int quantity, String supplier, LocalDate expectedDeliveryDate) {
        this.ingredientId = generateNewIngredientId();
        IngredientName = ingredientName;
        Quantity = quantity;
        Supplier = supplier;
        this.expectedDeliveryDate = expectedDeliveryDate;
        PurchaseHistory = null;
        ReceivingDate = null;
        Status = "Pending";
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }


    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPurchaseHistory() {
        return PurchaseHistory;
    }

    public void setPurchaseHistory(String purchaseHistory) {
        PurchaseHistory = purchaseHistory;
    }

    public LocalDate getReceivingDate() {
        return ReceivingDate;
    }

    public void setReceivingDate(LocalDate receivingDate) {
        ReceivingDate = receivingDate;
    }

    private int generateNewIngredientId(){
        return databaseAccessor.generateNewUniqueId("PurchaseRequest.bin", "ingredientId");
    }
}
