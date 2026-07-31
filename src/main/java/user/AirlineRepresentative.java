package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nonuser.*;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;
import utility.databaseAccessor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AirlineRepresentative extends User {
    protected final String airlineId;
    protected String officeContact;

    public AirlineRepresentative(int userId, String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, String airlineId, String officeContact) {
        super(userId, password, fullName, role, dateOfBirth, gender, email, phone, address, status);
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
                getClass().getResource("/AirlineRepresentative/dashboardView.fxml"));

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




    public final void createCateringOrder(String flightId, String deliveryLocation, ArrayList<OrderItem> orderItems, LocalDate deliveryDate, LocalTime deliveryTime, String status){
        ArrayList<String> orderItemIds = new ArrayList<String>();
        for (OrderItem orderItem : orderItems){
            BinaryFileUtility.writeObjects("OrderItem.bin", orderItem);
            orderItemIds.add(orderItem.getIteamId());
        }
        int newOrderId = (Integer) databaseAccessor.generateNewUniqueId("CateringOrder.bin", "orderId");
        CateringOrder newOrder = new CateringOrder(
                newOrderId,
                flightId,
                LocalDate.now(),
                deliveryLocation,
                orderItemIds,
                deliveryDate,
                deliveryTime,
                status
        );

        BinaryFileUtility.writeObjects("CateringOrder.bin", newOrder);
    }

    public final void modifyCateringOrder(String orderId, ArrayList<String> orderItemIds){
        // find out the orderId and modify OrderItemIds
    }

    public void cancelCateringOrder(String orderId){
        //set status == cancel
    }

    public final void submitFlightDelayRequest(String orderId, LocalDate newDepartureDate, LocalTime newDepartureTime){
        // find out id and set
    }

    public ArrayList<String> trackCateringOrderStatus(String orderId){

        // find out orderStatus from CateringOrder by orderId

        ArrayList<String> statusList = new ArrayList<String>();
        String orderStatus = "delivered";

        if (orderStatus.equals("approved")){
            statusList.add("approved");
        } else if (orderStatus.equals("prodcution")) {
            statusList.add("approved");
            statusList.add("prodcution");
        } else if (orderStatus.equals("quality Inspection")) {
            statusList.add("approved");
            statusList.add("prodcution");
            statusList.add("quality Inspection");
        } else if (orderStatus.equals("dispatch")) {
            statusList.add("approved");
            statusList.add("prodcution");
            statusList.add("quality Inspection");
            statusList.add("dispatch");
        } else if (orderStatus.equals("delivery")) {
            statusList.add("approved");
            statusList.add("prodcution");
            statusList.add("quality Inspection");
            statusList.add("dispatch");
            statusList.add("delivery");
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


    // Bellow are the code for fxml sideBar rendering button on action
    public static void renderFxmlDashboard(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/dashboardView.fxml");
    }

    public static void renderFxmlCreateCateringOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/createCateringOrderView.fxml");
    }

    public static void renderFxmlModifyOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/modifyOrderView.fxml");
    }

    public static void renderFxmlCancelOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/cancelOrderView.fxml");
    }

    public static void renderFxmlFlightDelay(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/flightDelayView.fxml");
    }

    public static void renderFxmlTruckOrder(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/truckOrderView.fxml");
    }

    public static void renderFxmlConfirmDelivery(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/confirmDeliveryView.fxml");
    }

    public static void renderFxmlPayBill(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/payBillView.fxml");
    }

    public static void renderFxmlOrderHistory(javafx.event.ActionEvent event) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(event, "/AirlineRepresentative/orderHistoryView.fxml");
    }

}
