package nonuser;

public class DashBoard{
    private final String description;
    private final int ticketID;
    private final String status;
    private final boolean issueType;

    public DashBoard(String description, int ticketID, String status, boolean issueType) {
        this.description = description;
        this.ticketID = ticketID;
        this.status = status;
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getStatus() {
        return status;
    }

    public boolean isIssueType() {
        return issueType;
    }

    @Override
    public String toString() {
        return "DashBoard{" +
                "description='" + description + '\'' +
                ", ticketID=" + ticketID +
                ", status='" + status + '\'' +
                ", issueType=" + issueType +
                '}';
    }
}
