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
    public void viewDashboard(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/airline_representative/dashboardView.fxml"));

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public boolean updateProfile(){
        return false;
    }




    public boolean createCateringOrder(String flightId, String deliveryLocation,ArrayList<OrderItem> orderItems,
                                       LocalDate deliveryDate, LocalTime deliveryTime) {

        int orderId = databaseAccessor.generateNewUniqueId("CateringOrder.bin", "orderId");
        ArrayList<String> orderItemIds = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            orderItemIds.add(orderItem.getItemId());
        }

        CateringOrder cateringOrder = new CateringOrder(
                orderId, flightId, this.getUserId(), LocalDate.now(), deliveryLocation,
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
                "Order Id: "+ orderId);
        return true;
    }

    public final void modifyCateringOrder(int orderId, ArrayList<String> orderItemIds){
        ArrayList<Object> cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");

        for (Object object : cateringOrderList) {

            if (object instanceof CateringOrder cateringOrder) {

                if (cateringOrder.getOrderId() == orderId) {

                    cateringOrder.setOrderItemIds(orderItemIds);

                    BinaryFileUtility.overwriteObjects("CateringOrder.bin", cateringOrderList);

                    return;
                }
            }
        }
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

    public final void submitFlightDelayRequest(ArrayList<Object> CateringOrderList){
        BinaryFileUtility.overwriteObjects("CateringOrder.bin", CateringOrderList);
    }

    public ArrayList<String> trackCateringOrderStatus(int orderId){
        ArrayList<String> statusList = new ArrayList<String>();
        ArrayList<Object> cateringOrderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        String orderStatus = "";

        for (Object object : cateringOrderList) {
            if (object instanceof CateringOrder cateringOrder && orderId == (cateringOrder.getOrderId())) {
                orderStatus = cateringOrder.getStatus();
                break;
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

    // Bellow are the code for fxml sideBar rendering button on action
    public static void renderFxmlDashboard(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/dashboardView.fxml");
    }

    public static void renderFxmlCreateCateringOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/createCateringOrderView.fxml");
    }

    public static void renderFxmlModifyOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/modifyOrderView.fxml");
    }

    public static void renderFxmlCancelOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/cancelOrderView.fxml");
    }

    public static void renderFxmlFlightDelay(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/flightDelayView.fxml");
    }

    public static void renderFxmlTruckOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/truckOrderView.fxml");
    }

    public static void renderFxmlConfirmDelivery(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/confirmDeliveryView.fxml");
    }

    public static void renderFxmlPayBill(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/payBillView.fxml");
    }

    public static void renderFxmlOrderHistory(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/airline_representative/orderHistoryView.fxml");
    }

}
