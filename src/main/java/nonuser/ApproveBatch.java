package nonuser;

public class ApproveBatch {
    private final int batchId;
    private String approveRemark;

    public ApproveBatch(int batchId, String approveRemark) {
        this.batchId = batchId;
        this.approveRemark = approveRemark;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getApproveRemark() {
        return approveRemark;
    }

    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark;
    }

    @Override
    public String toString() {
        return "ApproveBatch{" +
                "batchId=" + batchId +
                ", approveRemark='" + approveRemark + '\'' +
                '}';
    }
}
