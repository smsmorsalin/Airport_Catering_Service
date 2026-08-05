package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EmergencyModificationRequest implements Serializable {
//    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "EmergencyModification.bin";

    private final int requestId;
    private final int orderId;
    private final int submittedByEmployeeId;
    private final String modificationRequest;
    private final String reason;
    private final String priority;
    private final LocalDateTime submittedAt;
    private String status;

    public EmergencyModificationRequest(int orderId,
                                        int submittedByEmployeeId,
                                        String modificationRequest,
                                        String reason,
                                        String priority) {
        this.requestId = databaseAccessor.generateNewUniqueId(FILE_NAME, "requestId");
        this.orderId = orderId;
        this.submittedByEmployeeId = submittedByEmployeeId;
        this.modificationRequest = modificationRequest;
        this.reason = reason;
        this.priority = priority;
        this.submittedAt = LocalDateTime.now();
        this.status = "Pending";
    }

    public int getRequestId() {
        return requestId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSubmittedByEmployeeId() {
        return submittedByEmployeeId;
    }

    public String getModificationRequest() {
        return modificationRequest;
    }

    public String getReason() {
        return reason;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmergencyModificationRequest{" +
                "requestId=" + requestId +
                ", orderId=" + orderId +
                ", submittedByEmployeeId=" + submittedByEmployeeId +
                ", modificationRequest='" + modificationRequest + '\'' +
                ", reason='" + reason + '\'' +
                ", priority='" + priority + '\'' +
                ", submittedAt=" + submittedAt +
                ", status='" + status + '\'' +
                '}';
    }
}
