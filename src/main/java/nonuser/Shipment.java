package nonuser;

import java.io.Serializable;

public class Shipment implements Serializable {

    private int shipmentId;
    private String foodType;
    private int quantity;
    private String destination;
    private String deliveryStatus;
    private String assignedTruck;
    private String shipmentDate;


    public Shipment(int shipmentId, String foodType, int quantity,
                    String destination, String deliveryStatus,
                    String assignedTruck, String shipmentDate) {

        this.shipmentId = shipmentId;
        this.foodType = foodType;
        this.quantity = quantity;
        this.destination = destination;
        this.deliveryStatus = deliveryStatus;
        this.assignedTruck = assignedTruck;
        this.shipmentDate = shipmentDate;
    }


    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }


    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }


    public String getAssignedTruck() {
        return assignedTruck;
    }

    public void setAssignedTruck(String assignedTruck) {
        this.assignedTruck = assignedTruck;
    }


    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }


    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", foodType='" + foodType + '\'' +
                ", quantity=" + quantity +
                ", destination='" + destination + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", assignedTruck='" + assignedTruck + '\'' +
                ", shipmentDate='" + shipmentDate + '\'' +
                '}';
    }
}