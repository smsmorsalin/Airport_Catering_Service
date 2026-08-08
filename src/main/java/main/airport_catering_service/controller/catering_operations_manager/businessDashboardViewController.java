package main.airport_catering_service.controller.catering_operations_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nonuser.CateringOrder;
import nonuser.Payment;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class businessDashboardViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label welcomeMessageFxid;

    private CateringOperationsManager loggedInUser;
    @javafx.fxml.FXML
    private PieChart fxidPiChart;
    @javafx.fxml.FXML
    private Label totalOrdersCountLabelFxid;
    @javafx.fxml.FXML
    private Label totalRevinueCountLabelFxid;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
            welcomeMessageFxid.setText("Welcome "+ loggedInUser.getFullName());
            piChartView();
            businessDashboardViewList();
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    private void piChartView(){
        data = loggedInUser.businessDashboardView();
        fxidPiChart.setData(data);
    }

    private void businessDashboardViewList(){
        int totalOrder = 0;
        float totalRevinue = 0;

        ArrayList<Object> orderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        ArrayList<Object> paymentList =  BinaryFileUtility.readObjects("Payment.bin");
        if (orderList.isEmpty() || paymentList.isEmpty()){
            return;
        }

        totalOrder = orderList.size();
        for (Object obj : paymentList) {
            if(obj instanceof Payment p){
                if (p.getPaymentDate().equals(LocalDate.now())) {
                    totalRevinue++;
                }
            }
        }
        totalOrdersCountLabelFxid.setText(Integer.toString(totalOrder));
        totalRevinueCountLabelFxid.setText(Float.toString(totalRevinue));
    }

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void seeTotalOrderHistory(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarEmergencyOperationButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/emergencyIssueView.fxml",
                loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarReviewAllCateringOrdersButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/reviewOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveOrRejectOrdersButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/approveOrRejectOrderView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void homeButtonAirportCateringService(ActionEvent actionEvent) throws IOException {
       SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/businessDashboardView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarOperationalReportsButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/operationalReportView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarLogoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        User.logout(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionButton(ActionEvent actionEvent)  throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/monitorProductionView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarDeliveryMonitoringButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/deliveryMonitoringView.fxml", loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarInventoryStatusButton(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/catering_operations_manager/inventoryStatusView.fxml", loggedInUser);
    }

}