package nonuser;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmergencyDispatch {
    private Integer DispatchId;
    private String AssignTruck;
    private LocalTime DeliveryTime;
    private Integer DispatchRequestID;
    private Integer Schedule ;

    public EmergencyDispatch(Integer dispatchId, String assignTruck, LocalTime deliveryTime) {
        DispatchId = dispatchId;
        AssignTruck = assignTruck;
        DeliveryTime = deliveryTime;
    }

    public Integer getDispatchId() {
        return DispatchId;
    }

    public void setDispatchId(Integer dispatchId) {
        DispatchId = dispatchId;
    }

    public String getAssignTruck() {
        return AssignTruck;
    }

    public void setAssignTruck(String assignTruck) {
        AssignTruck = assignTruck;
    }

    public LocalTime getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        DeliveryTime = deliveryTime;
    }
}
