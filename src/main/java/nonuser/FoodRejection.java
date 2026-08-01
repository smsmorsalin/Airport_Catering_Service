package nonuser;

import java.time.LocalDate;

public class FoodRejection {
    private final int rejectionId;
    private final int BatchNumber;
    private final LocalDate rejectionDate;
    private String rejectionStatus;
    private final String rejectionReason;

    public FoodRejection(int rejectionId, int batchNumber, LocalDate rejectionDate, String rejectionReason, String rejectionStatus) {
        this.rejectionId = rejectionId;
        BatchNumber = batchNumber;
        this.rejectionDate = rejectionDate;
        this.rejectionReason = rejectionReason;
        this.rejectionStatus = rejectionStatus;
    }

    public int getRejectionId() {
        return rejectionId;
    }

    public int getBatchNumber() {
        return BatchNumber;
    }

    public LocalDate getRejectionDate() {
        return rejectionDate;
    }

    public String getRejectionStatus() {
        return rejectionStatus;
    }

    public void setRejectionStatus(String rejectionStatus) {
        this.rejectionStatus = rejectionStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

}
