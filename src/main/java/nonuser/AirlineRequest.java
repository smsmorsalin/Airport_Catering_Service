package nonuser;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AirlineRequest implements Serializable {
    private final int requestId;
    private final String newAirlineId;
    private final String newAirlineName;
    private final int submittedByEmployeeId;
    private final LocalDateTime submittedAt;
    private String status;

    public AirlineRequest(int requestId, String newAirlineId, String newAirlineName,
                          int submittedByEmployeeId) {
        this.requestId = requestId;
        this.newAirlineId = newAirlineId;
        this.newAirlineName = newAirlineName;
        this.submittedByEmployeeId = submittedByEmployeeId;
        submittedAt = LocalDateTime.now();
        status = "Pending";
    }

    public int getRequestId() { return requestId; }
    public String getNewAirlineId() { return newAirlineId; }
    public String getNewAirlineName() { return newAirlineName; }
    public int getSubmittedByEmployeeId() { return submittedByEmployeeId; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
