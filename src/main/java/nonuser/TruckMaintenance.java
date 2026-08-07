package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class TruckMaintenance implements Serializable {

    private int maintenanceId;
    private int truckId;
    private String issueDescription;
    private LocalDate maintenanceDate;
    private String maintenanceStatus;
    private String remarks;


    public TruckMaintenance(int maintenanceId, int truckId,
                            String issueDescription,
                            LocalDate maintenanceDate,
                            String maintenanceStatus,
                            String remarks) {

        this.maintenanceId = maintenanceId;
        this.truckId = truckId;
        this.issueDescription = issueDescription;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceStatus = maintenanceStatus;
        this.remarks = remarks;
    }


    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }


    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }


    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }


    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }


    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "TruckMaintenance{" +
                "maintenanceId=" + maintenanceId +
                ", truckId=" + truckId +
                ", issueDescription='" + issueDescription + '\'' +
                ", maintenanceDate=" + maintenanceDate +
                ", maintenanceStatus='" + maintenanceStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}