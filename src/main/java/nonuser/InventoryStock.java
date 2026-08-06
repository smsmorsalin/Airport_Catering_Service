package nonuser;

import utility.databaseAccessor;

public class InventoryStock {
    private final int stockId;
    private final String productName;
    private int productAvailability;
    private boolean hasStatus;

    public InventoryStock(String productName, int productAvailability, boolean hasStatus) {
        this.stockId = generateNewStockId();
        this.productName = productName;
        this.productAvailability = productAvailability;
        this.hasStatus = hasStatus;
    }

    public int getStockId() {
        return stockId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(int productAvailability) {
        this.productAvailability = productAvailability;
    }

    public boolean isHasStatus() {
        return hasStatus;
    }

    public void setHasStatus(boolean hasStatus) {
        this.hasStatus = hasStatus;
    }

    private int generateNewStockId(){
        return databaseAccessor.generateNewUniqueId("InventoryStock.bin", "stockId");
    }
}
