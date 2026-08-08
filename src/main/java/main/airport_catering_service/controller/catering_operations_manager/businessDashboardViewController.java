package main.airport_catering_service.controller.catering_operations_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
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

public class businessDashboardViewController implements UserReceiver
{
    @javafx.fxml.FXML
    private Label welcomeMessageFxid;

    private CateringOperationsManager loggedInUser;
    @javafx.fxml.FXML
    private BarChart fxidBarChart;
    @javafx.fxml.FXML
    private PieChart fxidPiChart;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof CateringOperationsManager cateringOperationsManager) {
            this.loggedInUser = cateringOperationsManager;
            welcomeMessageFxid.setText("Welcome "+ loggedInUser.getFullName());
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

    @javafx.fxml.FXML
    public void initialize() {
        piChartView();
    }

    @Deprecated
    public void seePendingDeliverysButton(ActionEvent actionEvent) {
    }
    @Deprecated
    public void seePendingOrdersButton(ActionEvent actionEvent) {
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