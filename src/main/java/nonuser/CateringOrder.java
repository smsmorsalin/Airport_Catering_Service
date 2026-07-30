package nonuser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CateringOrder {
    private final int orderId;
    private final String airlineId; //FF
    private final String FlightId; //FF
    private final LocalDate orderDate;
    private final String deliveryLocation;
    private ArrayList<String> orderItemIds; //FF of orderItem
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private String Status;

    public CateringOrder(int orderId, String airlineId, String flightId, LocalDate orderDate, String deliveryLocation, ArrayList<String> orderItemIds, LocalDate deliveryDate, LocalTime deliveryTime, String status) {
        this.orderId = orderId;
        this.airlineId = airlineId;
        FlightId = flightId;
        this.orderDate = orderDate;
        this.deliveryLocation = deliveryLocation;
        this.orderItemIds = orderItemIds;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        Status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getAirlineId() {
        return airlineId;
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
}
