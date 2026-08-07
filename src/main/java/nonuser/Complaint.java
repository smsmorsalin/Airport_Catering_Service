package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Complaint implements Serializable {
    private static final String FILE_NAME = "Complaint.bin";

    private final int complaintId;
    private final int orderId;
    private final String airlineId;
    private final String category;
    private final String description;
    private final String priority;
    private final int submittedByEmployeeId;
    private final LocalDateTime submittedAt;
    private String status;
    private String resolutionNotes;
    private int resolvedByEmployeeId;
    private LocalDateTime resolvedAt;

    public Complaint(int orderId, String airlineId, String category,
                     String description, String priority, int submittedByEmployeeId) {
        complaintId = databaseAccessor.generateNewUniqueId(FILE_NAME, "complaintId");
        this.orderId = orderId;
        this.airlineId = airlineId;
        this.category = category;
        this.description = description;
        this.priority = priority;
        this.submittedByEmployeeId = submittedByEmployeeId;
        submittedAt = LocalDateTime.now();
        status = "Open";
        resolutionNotes = "";
    }

    public int getComplaintId() { return complaintId; }
    public int getOrderId() { return orderId; }
    public String getAirlineId() { return airlineId; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public int getSubmittedByEmployeeId() { return submittedByEmployeeId; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResolutionNotes() { return resolutionNotes; }
    public void setResolutionNotes(String resolutionNotes) { this.resolutionNotes = resolutionNotes; }
    public int getResolvedByEmployeeId() { return resolvedByEmployeeId; }
    public LocalDateTime getResolvedAt() { return resolvedAt; }
    public void resolve(String resolutionNotes, int employeeId) {
        this.resolutionNotes = resolutionNotes;
        resolvedByEmployeeId = employeeId;
        resolvedAt = LocalDateTime.now();
    }
}
