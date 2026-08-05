package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.*;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AirlineRepresentative extends User implements Serializable {
    protected final String airlineId;
    protected String officeContact;

    public AirlineRepresentative(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, String airlineId, String officeContact) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status);
        this.airlineId = airlineId;
        this.officeContact = officeContact;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getOfficeContact() {
        return officeContact;
    }

    public void setOfficeContact(String officeContact) {
        this.officeContact = officeContact;
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user) {
        SceneSwitchingHelper.switchSceneWithData(event, "/airline_representative/dashboardView.fxml", user);
    }

    @Override
    public boolean updateProfile(){
        return false;
    }




    public boolean createCateringOrder(String flightId, String deliveryLocation,ArrayList<OrderItem> orderItems,
                                       LocalDate deliveryDate, LocalTime deliveryTime) {

        ArrayList<String> orderItemIds = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            orderItemIds.add(orderItem.getItemId());
        }

        CateringOrder cateringOrder = new CateringOrder(
                flightId,this.airlineId, this.getUserId(), LocalDate.now(), deliveryLocation,
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
    }

    public final boolean modifyCateringOrder(CateringOrder selectedCateringOrder, ArrayList<OrderItem> orderItemList) {

        if (selectedCateringOrder == null) {
            AlertGenerator.showAlert("Error", "Selected catering order is invalid.");
            return false;
        }

        if (orderItemList == null || orderItemList.isEmpty()) {
            AlertGenerator.showAlert("Error", "Order item list cannot be empty.");
            return false;
        }


        ArrayList<Object> cateringOrderList =
                BinaryFileUtility.readObjects("CateringOrder.bin");

        if (cateringOrderList == null || cateringOrderList.isEmpty()) {
            AlertGenerator.showAlert("Error", "No catering orders found.");
            return false;
        }

        boolean orderFound = false;

        for (int i = 0; i < cateringOrderList.size(); i++) {

            Object object = cateringOrderList.get(i);

            if (object instanceof CateringOrder cateringOrder && cateringOrder.getOrderId() == selectedCateringOrder.getOrderId()) {
                cateringOrderList.set(i, selectedCateringOrder);
                orderFound = true;
                break;
            }
        }

        if (!orderFound) {
            AlertGenerator.showAlert("Error", "Order not found.");
            return false;
        }

        ArrayList<Object> storedOrderItemList =
                BinaryFileUtility.readObjects("OrderItem.bin");

        if (storedOrderItemList == null) {
            storedOrderItemList = new ArrayList<>();
        }

        for (OrderItem modifiedOrderItem : orderItemList) {

            boolean itemFound = false;

            for (int i = 0; i < storedOrderItemList.size(); i++) {

                Object object = storedOrderItemList.get(i);

                if (object instanceof OrderItem storedOrderItem && storedOrderItem.getItemId().equals(modifiedOrderItem.getItemId())) {

                    storedOrderItemList.set(i, modifiedOrderItem);
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                storedOrderItemList.add(modifiedOrderItem);
            }
        }


        boolean orderItemsSaved = BinaryFileUtility.overwriteObjects("OrderItem.bin", storedOrderItemList);
        if (!orderItemsSaved) {AlertGenerator.showAlert("Error", "Order items could not be modified.");
            return false;
        }
        boolean cateringOrderSaved = BinaryFileUtility.overwriteObjects("CateringOrder.bin", cateringOrderList);

        if (!cateringOrderSaved) {AlertGenerator.showAlert("Error", "Catering order could not be modified.");
            return false;
        }

        AlertGenerator.showAlert("Success", "Order modified successfully."
        );
        return true;
    }

    public boolean cancelCateringOrder(int orderId){
        ArrayList<Object> readCateringOrders =
                BinaryFileUtility.readObjects("CateringOrder.bin");

        if (readCateringOrders == null || readCateringOrders.isEmpty()) {
            AlertGenerator.showAlert("error", "No order exists in the database.");
            return false;
        }

        for (Object object : readCateringOrders) {

            if (object instanceof CateringOrder cateringOrder) {

                if (cateringOrder.getOrderId() == orderId) {

                    // Check whether this logged-in user created the order
                    if (cateringOrder.getAirlineRepresentativeId() != this.getUserId()) {
                        AlertGenerator.showAlert("error", "You can only cancel orders created by you.");
                        return false;
                    }

                    if ("Cancelled".equals(cateringOrder.getStatus())) {
                        AlertGenerator.showAlert("error", "Order is already cancelled.");
                        return false;
                    }

                    if ("Pending".equals(cateringOrder.getStatus())) {

                        cateringOrder.setStatus("Cancelled");

                        boolean isSaved = BinaryFileUtility.overwriteObjects("CateringOrder.bin", readCateringOrders);

                        if (!isSaved) {
                            AlertGenerator.showAlert("error", "Failed to save the cancelled order.");
                            return false;
                        }

                        AlertGenerator.showAlert("success", "Order cancelled successfully.");
                        return true;
                    }

                    AlertGenerator.showAlert("error", "The order is processing and cannot be cancelled.");
                    return false;
                }
            }
        }

        AlertGenerator.showAlert("error", "Order ID does not exist.");
        return false;
    }

    public final void submitFlightDelayRequest(int orderId, LocalDate newDeliveryDate, LocalTime newDeliveryTime){
        ArrayList<Object> readCateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        if (readCateringOrderList == null || readCateringOrderList.isEmpty()) {
            AlertGenerator.showAlert("error", "No order exists in the database.");
            return;
        }
        for (Object object : readCateringOrderList) {
            if (object instanceof CateringOrder cateringOrder) {
                if (cateringOrder.getOrderId() == orderId) {
                    if (cateringOrder.getAirlineId() != this.getAirlineId()) {
                        AlertGenerator.showAlert("error", "this Airline not belong to You");
                    }
                    cateringOrder.setDeliveryDate(newDeliveryDate);
                    cateringOrder.setDeliveryTime(newDeliveryTime);
                    BinaryFileUtility.overwriteObjects("CateringOrder.bin", readCateringOrderList);
                    AlertGenerator.showAlert("success", "Delay request submitted.");
                    break;
                }
            }
        }

    }

    public ArrayList<String> trackCateringOrderStatus(int orderId){

        CateringOrder cateringOrder = CateringOrder.findById(orderId);
        if (cateringOrder == null){
            AlertGenerator.showAlert("error", "Order does not exist.");
            return null;
        }
        String orderStatus = cateringOrder.getStatus();

        ArrayList<String> statusList = new ArrayList<String>();
        if(orderStatus.equals("Pending")){
            AlertGenerator.showAlert("error", "Order is pending for approval");
            return null;
        }
        if(orderStatus.equals("Cancelled")){
            AlertGenerator.showAlert("error", "Order is cancelled");
            return null;
        }
        if(orderStatus.equals("Rejected")){
            AlertGenerator.showAlert("error", "Order is rejected");
            return null;
        }

        if (orderStatus.equals("Approved")){
            statusList.add("Approved");
        } else if (orderStatus.equals("Production")) {
            statusList.add("Approved");
            statusList.add("Production");
        } else if (orderStatus.equals("Quality Inspection")) {
            statusList.add("Approved");
            statusList.add("Production");
            statusList.add("Quality Inspection");
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

    public final void confirmCateringDelivery(int orderId, String receiverName){
        // find out the order from CateringOrder
        // if the delivery already done give an alert
        //else: create a ConfirmCateringDelivery

    }

    public final Boolean payCateringBill(String invoiceId, String method, String transactionReference){
        // add Payment
        return true;
    }

    //most dificult one
    public final void viewOrderPaymentHistory(LocalDate startDate, LocalDate endDate, String flightNumber, String status){


    }

    public static AirlineRepresentative createNewAirlineRepresentative(String password, String fullName, LocalDate dateOfBirth, String gender, String email, String phone, String address, String airlineId, String officeContact) {
        AirlineRepresentative newRepresentative = new AirlineRepresentative(password, fullName, "Airline Representative", dateOfBirth,
                        gender, email, phone, address, "Active", airlineId, officeContact);

        boolean saved = BinaryFileUtility.writeObjects("User.bin", newRepresentative);

        if (saved) {
            return newRepresentative;
        }

        return null;
    }

    @Override
    public String toString() {
        return "AirlineRepresentative{" +
                "airlineId='" + airlineId + '\'' +
                ", officeContact='" + officeContact + '\'' +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}
