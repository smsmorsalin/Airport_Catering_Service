package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

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
