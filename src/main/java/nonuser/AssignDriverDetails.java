package nonuser;

import java.io.Serializable;

public class AssignDriverDetails implements Serializable {
    private int orderID;
    private int truckID;
    private int truckNumber;
    private int driderID;
    private String status;

    public AssignDriverDetails(int orderID, int truckID, int truckNumber, int driderID) {
        this.orderID = orderID;
        this.truckID = truckID;
        this.truckNumber = truckNumber;
        this.driderID = driderID;
        this.status = "Assigned";
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    public int getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(int truckNumber) {
        this.truckNumber = truckNumber;
    }

    public int getDriderID() {
        return driderID;
    }

    public void setDriderID(int driderID) {
        this.driderID = driderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssignDriverDetails{" +
                "orderID=" + orderID +
                ", truckID=" + truckID +
                ", truckNumber=" + truckNumber +
                ", driderID=" + driderID +
                '}';
    }
}
