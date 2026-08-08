package nonuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class DeliverySchedule implements Serializable {

    private int scheduleId;
    private int shipmentId;
    private int truckId;
    private String route;
    private LocalDate deliveryDate;
    private LocalTime departureTime;
    private LocalTime estimatedArrivalTime;
    private String status;


    public DeliverySchedule(int scheduleId, int shipmentId, int truckId,
                            String route, LocalDate deliveryDate,
                            LocalTime departureTime,
                            LocalTime estimatedArrivalTime,
                            String status) {

        this.scheduleId = scheduleId;
        this.shipmentId = shipmentId;
        this.truckId = truckId;
        this.route = route;
        this.deliveryDate = deliveryDate;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.status = status;
    }


    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }


    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }


    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }


    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }


    public LocalTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "DeliverySchedule{" +
                "scheduleId=" + scheduleId +
                ", shipmentId=" + shipmentId +
                ", truckId=" + truckId +
                ", route='" + route + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", departureTime=" + departureTime +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", status='" + status + '\'' +
                '}';
    }
}