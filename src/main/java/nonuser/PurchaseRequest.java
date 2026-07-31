package nonuser;

import java.time.LocalDate;

public class PurchaseRequest {
    private String IngredientName;
    private String Quantity;
    private String Supplier;
    private LocalDate DeliveryDate;
    private String PurchaseHistory;
    private LocalDate ReceivingDate;


    public PurchaseRequest(String ingredientName, String quantity, String supplier, LocalDate deliveryDate) {
        IngredientName = ingredientName;
        Quantity = quantity;
        Supplier = supplier;
        DeliveryDate = deliveryDate;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public LocalDate getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        DeliveryDate = deliveryDate;
    }
}
