package main.airport_catering_service.controller.catering_operations_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nonuser.CateringOrder;
import user.CateringOperationsManager;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
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
            businessDashboardViewList();
        } else {
            AlertGenerator.showAlert("Error", "Invalid user for this page.");
        }
    }

    int pending = 0;
    int approved = 0;
    int delivered = 0;
    int rejected = 0;
    int cancelled = 0;
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    private void piChartView(){
        data.clear();
        ArrayList<Object> orderList = BinaryFileUtility.readObjects("CateringOrder.bin");
        for (Object obj : orderList) {
            if(obj instanceof CateringOrder c){
                switch(c.getStatus()){
                    case "Pending":
                        pending++;
                        break;

                    case "Approved":
                        approved++;
                        break;

                    case "Rejected":
                        rejected++;
                        break;

                    case "Cancelled":
                        cancelled++;
                        break;

                    case "Delivered":
                        delivered++;
                        break;
                }
            }
        }

        data.add(new PieChart.Data("Pending", pending));
        data.add(new PieChart.Data("Approved", approved));
        data.add(new PieChart.Data("Rejected", rejected));
        data.add(new PieChart.Data("Cancelled", cancelled));
        data.add(new PieChart.Data("Delivered", delivered));

        fxidPiChart.setData(data);

    }

    private void businessDashboardViewList(){
        List<Integer> businessList = loggedInUser.businessDashboardView();
        if(businessList.isEmpty()){
            return;
        }
        totalOrdersCountLabelFxid.setText(Integer.toString(businessList.indexOf(0)));
        totalRevinueCountLabelFxid.setText(Integer.toString(businessList.indexOf(1)));
    }

    @javafx.fxml.FXML
    public void initialize() {
        piChartView();
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