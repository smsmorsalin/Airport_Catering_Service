package nonuser;

import utility.databaseAccessor;

public class EmergencyOperation {
    private final int ticketId;
    private String issueType;
    private String description;
    private int assignedUserId;
    private String status;

    public EmergencyOperation(String issueType, String description, int assignedUserId) {
        this.ticketId = generateNewTicketId();
        this.issueType = issueType;
        this.description = description;
        this.assignedUserId = assignedUserId;
        this.status = "Assigned";   //Assigned, Solved, Unsolved
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(int assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmergencyOperation{" +
                "ticketId=" + ticketId +
                ", issueType='" + issueType + '\'' +
                ", description='" + description + '\'' +
                ", assignedUserId=" + assignedUserId +
                ", status='" + status + '\'' +
                '}';
    }

    private static int generateNewTicketId() {
        return databaseAccessor.generateNewUniqueId("EmergencyOperation.bin", "ticketId");
    }
}
