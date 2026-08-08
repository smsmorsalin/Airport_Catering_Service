package nonuser;

import java.io.Serializable;

public class Truck implements Serializable {

    private int truckId;
    private String truckNumber;
    private String truckType;
    private String capacity;
    private String currentStatus;
    private String assignedDriver;


    public Truck(int truckId, String truckNumber, String truckType,
                 String capacity, String currentStatus,
                 String assignedDriver) {

        this.truckId = truckId;
        this.truckNumber = truckNumber;
        this.truckType = truckType;
        this.capacity = capacity;
        this.currentStatus = currentStatus;
        this.assignedDriver = assignedDriver;
    }


    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }


    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }


    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }


    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }


    public String getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(String assignedDriver) {
        this.assignedDriver = assignedDriver;
    }


    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", truckNumber='" + truckNumber + '\'' +
                ", truckType='" + truckType + '\'' +
                ", capacity='" + capacity + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", assignedDriver='" + assignedDriver + '\'' +
                '}';
    }
}