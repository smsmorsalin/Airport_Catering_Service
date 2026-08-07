package nonuser;

import java.io.Serializable;

public class DriverDetails implements Serializable {
    private int truckID;
    private int driverID;
    private int truckNumber;

    public DriverDetails(int truckID, int driverID, int truckNumber) {
        this.truckID = truckID;
        this.driverID = driverID;
        this.truckNumber = truckNumber;
    }

    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(int truckNumber) {
        this.truckNumber = truckNumber;
    }

    @Override
    public String toString() {
        return "DriverDetails{" +
                "truckID=" + truckID +
                ", driverID=" + driverID +
                ", truckNumber=" + truckNumber +
                '}';
    }
}
