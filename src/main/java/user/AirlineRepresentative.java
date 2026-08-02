package nonuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class DeliveryConfirmation implements Serializable {
    private final String confirmationId;
    private int orderId;
    private String receiverName;
    private String confirmedBy;
    private LocalDate confirmationTime;
    private String clientSignature;
    private boolean confirmed;

    // orderId: the CateringOrder being confirmed
    // receiverName: name of the person who received the delivery (client)
    // confirmedBy: how it was confirmed, e.g. "sms", "call", "in-person"
    // confirmationTime: date the confirmation was made
    public DeliveryConfirmation(int orderId, String receiverName, String confirmedBy, LocalDate confirmationTime) {
        this.confirmationId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.confirmedBy = confirmedBy;
        this.confirmationTime = confirmationTime;
        this.confirmed = true;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/airline_representative/dashboardView.fxml", user);
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }




    public boolean createCateringOrder(String flightId, String deliveryLocation,ArrayList<OrderItem> orderItems,
                                       LocalDate deliveryDate, LocalTime deliveryTime) {

        ArrayList<String> orderItemIds = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            orderItemIds.add(orderItem.getItemId());
        }

        CateringOrder cateringOrder = new CateringOrder(
                flightId, this.getAirlineId(), this.getUserId(), LocalDate.now(), deliveryLocation,
                orderItemIds, deliveryDate, deliveryTime
        );

        for (OrderItem orderItem : orderItems) {
            BinaryFileUtility.writeObjects("OrderItem.bin", orderItem);
        }

        boolean saved = BinaryFileUtility.writeObjects("CateringOrder.bin", cateringOrder);

        if (!saved) {
            AlertGenerator.showAlert("Error", "Failed to save the catering order.");
            return false;
        }
        AlertGenerator.showAlert("Info", "Successfully saved the catering order.\n" +
                "Order Id: "+ cateringOrder.getOrderId());
        return true;
    public String getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(String confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public LocalDate getConfirmationTime() {
        return confirmationTime;
    }

    public void setConfirmationTime(LocalDate confirmationTime) {
        this.confirmationTime = confirmationTime;
    }

    public ArrayList<String> trackCateringOrderStatus(int orderId){
        ArrayList<String> statusList = new ArrayList<String>();
        ArrayList<Object> cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        String orderStatus = "";

        for (Object object : cateringOrderList) {
            if (object instanceof CateringOrder cateringOrder && orderId == (cateringOrder.getOrderId())) {
                if (cateringOrder.getAirlineId().equals(this.getAirlineId())) {
                    orderStatus = cateringOrder.getStatus();
                    break;
                }
                AlertGenerator.showAlert("error", "This order doesn't belong to your airline.");
            }
        }
        if (orderStatus.isEmpty()) {
            AlertGenerator.showAlert("error", "Order ID does not exist.");
            return null;
        }
        if(orderStatus.equals("Cancelled")){
            AlertGenerator.showAlert("error", "Order is already cancelled.");
            return null;
        }
        if(orderStatus.equals("Pending")){
            AlertGenerator.showAlert("error", "Order is Pending.");
        }

        if (orderStatus.equals("Approved")){
            statusList.add("Approved");
        } else if (orderStatus.equals("Production")) {
            statusList.add("Approved");
            statusList.add("Production");
        } else if (orderStatus.equals("quality Inspection")) {
            statusList.add("Approved");
            statusList.add("Production");
            statusList.add("quality Inspection");
        } else if (orderStatus.equals("Dispatch")) {
            statusList.add("Approved");
            statusList.add("Production");
            statusList.add("Quality Inspection");
            statusList.add("Dispatch");
        } else if (orderStatus.equals("Delivery")) {
            statusList.add("Approved");
            statusList.add("Production");
            statusList.add("Quality Inspection");
            statusList.add("Dispatch");
            statusList.add("Delivery");
        }
        return statusList;

    }

    public final DeliveryConfirmation confirmCateringDelivery(int orderId, String receiverName){
        // find out the order from CateringOrder
        // if the delivery already done give an alert
        //else: create a ConfirmCateringDelivery
        DeliveryConfirmation newDeliveryConfirmation = new DeliveryConfirmation(1, "sms", LocalDate.now());
        return newDeliveryConfirmation;
    }

    public final Boolean payCateringBill(String invoiceId,String method,String transactionReference){
        // add Payment
        return true;
    public String getClientSignature() {
        return clientSignature;
    }

    public void setClientSignature(String clientSignature) {
        this.clientSignature = clientSignature;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String toString() {
        return "DeliveryConfirmation{" +
                "confirmationId='" + confirmationId + '\'' +
                ", orderId=" + orderId +
                ", receiverName='" + receiverName + '\'' +
                ", confirmedBy='" + confirmedBy + '\'' +
                ", confirmationTime=" + confirmationTime +
                ", clientSignature='" + clientSignature + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}