package nonuser;

import utility.databaseAccessor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ServiceUpdate implements Serializable {
    private static final String FILE_NAME = "ServiceUpdate.bin";

    private final int updateId;
    private final String category;
    private final String title;
    private final String message;
    private final String priority;
    private final int publishedByEmployeeId;
    private final LocalDateTime publishedAt;

    public ServiceUpdate(String category, String title, String message,
                         String priority, int publishedByEmployeeId) {
        updateId = databaseAccessor.generateNewUniqueId(FILE_NAME, "updateId");
        this.category = category;
        this.title = title;
        this.message = message;
        this.priority = priority;
        this.publishedByEmployeeId = publishedByEmployeeId;
        publishedAt = LocalDateTime.now();
    }

    public int getUpdateId() { return updateId; }
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getPriority() { return priority; }
    public int getPublishedByEmployeeId() { return publishedByEmployeeId; }
    public LocalDateTime getPublishedAt() { return publishedAt; }
}
