package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class DeliveryIssue implements Serializable {

    private int issueId;
    private int assignmentId;
    private String issueType;
    private String severity;
    private String location;
    private LocalDate issueDate;
    private String description;
    private String status;

    public DeliveryIssue(int issueId,
                         int assignmentId,
                         String issueType,
                         String severity,
                         String location,
                         LocalDate issueDate,
                         String description,
                         String status) {

        this.issueId = issueId;
        this.assignmentId = assignmentId;
        this.issueType = issueType;
        this.severity = severity;
        this.location = location;
        this.issueDate = issueDate;
        this.description = description;
        this.status = status;
    }

    public int getIssueId() {
        return issueId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}