package nonuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CateringOrder implements Serializable {
    private final int orderId;
    private final String FlightId; //FF
    private final int airlineRepresentativeId;
    private final LocalDate orderDate;
    private final String deliveryLocation;
    private ArrayList<String> orderItemIds; //FF of orderItem
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private String Status;
    private boolean isDelay;

    public CateringOrder(int orderId, String flightId,int airlineRepresentativeId, LocalDate orderDate, String deliveryLocation, ArrayList<String> orderItemIds, LocalDate deliveryDate, LocalTime deliveryTime) {
        this.orderId = orderId;
        FlightId = flightId;
        this.orderDate = orderDate;
        this.airlineRepresentativeId = airlineRepresentativeId;
        this.deliveryLocation = deliveryLocation;
        this.orderItemIds = orderItemIds;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        Status = "Pending";
        this.isDelay = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getFlightId() {
        return FlightId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public ArrayList<String> getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(ArrayList<String> orderItemIds) {
        this.orderItemIds = orderItemIds;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAirlineRepresentativeId() {
        return airlineRepresentativeId;
    }

    public boolean isDelay() {
        return isDelay;
    }

    public void setDelay(boolean delay) {
        isDelay = delay;
    }

    @Override
    public String toString() {
        return "CateringOrder{" +
                "orderId=" + orderId +
                ", FlightId='" + FlightId + '\'' +
                ", airlineRepresentativeId=" + airlineRepresentativeId +
                ", orderDate=" + orderDate +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", orderItemIds=" + orderItemIds +
                ", deliveryDate=" + deliveryDate +
                ", deliveryTime=" + deliveryTime +
                ", Status='" + Status + '\'' +
                ", isDelay=" + isDelay +
                '}';
    }
}
