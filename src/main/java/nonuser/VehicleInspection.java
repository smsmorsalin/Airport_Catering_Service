package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class VehicleInspection implements Serializable {

    private int inspectionId;
    private int truckId;
    private LocalDate inspectionDate;
    private String inspectionResult;
    private String inspectorName;
    private String remarks;


    public VehicleInspection(int inspectionId, int truckId,
                             LocalDate inspectionDate,
                             String inspectionResult,
                             String inspectorName,
                             String remarks) {

        this.inspectionId = inspectionId;
        this.truckId = truckId;
        this.inspectionDate = inspectionDate;
        this.inspectionResult = inspectionResult;
        this.inspectorName = inspectorName;
        this.remarks = remarks;
    }


    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }


    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }


    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }


    public String getInspectionResult() {
        return inspectionResult;
    }

    public void setInspectionResult(String inspectionResult) {
        this.inspectionResult = inspectionResult;
    }


    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "VehicleInspection{" +
                "inspectionId=" + inspectionId +
                ", truckId=" + truckId +
                ", inspectionDate=" + inspectionDate +
                ", inspectionResult='" + inspectionResult + '\'' +
                ", inspectorName='" + inspectorName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
