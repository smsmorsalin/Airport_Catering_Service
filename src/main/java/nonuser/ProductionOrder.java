package nonuser;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProductionOrder {

    private final int productionOrderId;
    private final int productionTaskId;
    private final int orderId;

    private String airlineName;
    private String flightNumber;
    private String mealType;
    private int mealQuantity;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;

    public ProductionOrder(int productionOrderId, int productionTaskId, int orderId, String airlineName, String flightNumber, String mealType, int mealQuantity, LocalDate deliveryDate, LocalTime deliveryTime) {
        this.productionOrderId = productionOrderId;
        this.productionTaskId = productionTaskId;
        this.orderId = orderId;
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.mealType = mealType;
        this.mealQuantity = mealQuantity;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public int getProductionTaskId() {
        return productionTaskId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(int mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "ProductionOrder{" +
                "productionOrderId=" + productionOrderId +
                ", productionTaskId=" + productionTaskId +
                ", orderId=" + orderId +
                ", airlineName='" + airlineName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealQuantity=" + mealQuantity +
                ", deliveryDate=" + deliveryDate +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
