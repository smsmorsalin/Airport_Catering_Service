package nonuser;

import java.time.LocalTime;

public class Package {
    private Integer PackagingID;
    private LocalTime CompletionTime;

    public Package(Integer packagingID, LocalTime completionTime) {
        PackagingID = packagingID;
        CompletionTime = completionTime;
    }

    public Integer getPackagingID() {
        return PackagingID;
    }

    public void setPackagingID(Integer packagingID) {
        PackagingID = packagingID;
    }

    public LocalTime getCompletionTime() {
        return CompletionTime;
    }

    public void setCompletionTime(LocalTime completionTime) {
        CompletionTime = completionTime;
    }
}
