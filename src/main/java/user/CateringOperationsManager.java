package user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import main.airport_catering_service.controller.catering_operations_manager.approveOrRejectOrderViewController;
import nonuser.*;
import utility.AlertGenerator;
import utility.BinaryFileUtility;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CateringOperationsManager extends Employee implements Serializable {

    public CateringOperationsManager(String password, String fullName, String role, LocalDate dateOfBirth, String gender, String email, String phone, String address, String status, LocalDate joinDate, String department, String designation, float salary) {
        super(password, fullName, role, dateOfBirth, gender, email, phone, address, status, joinDate, department, designation, salary);
    }

    @Override
    public String toString() {
        return "CateringOperationsManager{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public void viewDashboard(javafx.event.ActionEvent event, User user){
        SceneSwitchingHelper.switchSceneWithData(event, "/catering_operations_manager/businessDashboardView.fxml", user);
    }

    @Override
    public boolean updateProfile(){
        return false;
    }

    public final void approveOrRejectOrder(ArrayList<Object> cateringOrder){
        boolean b = BinaryFileUtility.overwriteObjects("CateringOrder.bin", cateringOrder);

    }

    public final void reviewCateringOrder(ActionEvent event, int orderId, User user){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/catering_operations_manager/approveOrRejectOrderView.fxml"));
            Parent root = loader.load();

            Object controller = loader.getController();
            if(controller instanceof approveOrRejectOrderViewController a){
                a.setOrderId(orderId);
            }

            if (controller instanceof UserReceiver receiver) {
                receiver.setLoggedInUser(user);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            AlertGenerator.showAlert("error", "Scene Switch failed");
        } catch (Exception e) {
            AlertGenerator.showAlert("error", e.getMessage());
        }
    }

    public final ArrayList<Object> inventoryStatus(){
        ArrayList<Object> inventoryStatusList;
        inventoryStatusList = BinaryFileUtility.readObjects("InventoryStock.bin");
        return inventoryStatusList;
    }

    public final ArrayList<DeliveryStatus> monitorDeliveryStatus(LocalDate fromDate, LocalDate toDate){
        ArrayList<Object> readDeliveryStatusList;
        ArrayList<DeliveryStatus> returnDeliveryStatusList = new ArrayList<>();

        readDeliveryStatusList = BinaryFileUtility.readObjects("DeliveryStatus.bin");
        if(readDeliveryStatusList.isEmpty()){
            AlertGenerator.showAlert("error", "DeliveryStatus is empty");
            return null;
        }
        for(Object o : readDeliveryStatusList){
            if(o instanceof DeliveryStatus d){
                if(d.getDeliveryDate().isAfter(fromDate) && d.getDeliveryDate().isBefore(toDate)){
                    returnDeliveryStatusList.add(d);
                }
            }
        }
        return returnDeliveryStatusList;

    }
    public final ProductionActivities monitorProductionProgress(int productionOrderId){
        ArrayList<Object> readProductionActivitiesList = BinaryFileUtility.readObjects("ProductionActivities.bin");
        if(readProductionActivitiesList.isEmpty()){
            AlertGenerator.showAlert("error", "ProductionActivities is empty");
            return null;
        }
        for(Object o : readProductionActivitiesList){
            if(o instanceof ProductionActivities p){
                if(p.getProductionOrderId() == productionOrderId){
                    return p;
                }
            }
        }
        AlertGenerator.showAlert("error", "please check productionOrderId \n production orderId does not exist");
        return null;
    }

    public final ObservableList<PieChart.Data> businessDashboardView(){
        int pending = 0;
        int approved = 0;
        int delivered = 0;
        int rejected = 0;
        int cancelled = 0;

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

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

        return data;
    }


}
