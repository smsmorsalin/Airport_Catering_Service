package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class DeliveryAssignment implements Serializable {

    private int assignmentId;
    private int orderId;
    private String flightNumber;
    private String airline;
    private String location;
    private LocalDate deliveryDate;
    private String status;

    public DeliveryAssignment(int assignmentId, int orderId,
                              String flightNumber, String airline,
                              String location, LocalDate deliveryDate,
                              String status) {

        this.assignmentId = assignmentId;
        this.orderId = orderId;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.location = location;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}