package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.ProductionPlan;
import user.KitchenProductionManager;
import utility.BinaryFileUtility;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateProductionScheduleController {
    @javafx.fxml.FXML
    private ComboBox<String> workShiftComboBox1;
    @javafx.fxml.FXML
    private ComboBox<String> endsMinutiesTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> startHoursTimeComboBox;
    @javafx.fxml.FXML
    private TextField productionPlanIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> endsHoursTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> startMinitueTimeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        startHoursTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        startMinitueTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");
        endsHoursTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        endsMinutiesTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");
        workShiftComboBox1.getItems().addAll("Day", "Night");


        // get value

        int startHour = Integer.parseInt(startHoursTimeComboBox.getValue());
        int startMinute = Integer.parseInt(startMinitueTimeComboBox.getValue());

        int endHour = Integer.parseInt(endsHoursTimeComboBox.getValue());
        int endMinute = Integer.parseInt(endsMinutiesTimeComboBox.getValue());

        LocalTime startTime = LocalTime.of(startHour, startMinute);
        LocalTime endTime = LocalTime.of(endHour, endMinute);

        String workShift = workShiftComboBox1.getValue();

        if (!endTime.isAfter(startTime)) {showAlert("End Time must be after Start Time");
            return;
        }


// file read

        ArrayList<Object> productionPlanObjectList = BinaryFileUtility.readObjects("ProductionPlan.bin");

        ProductionPlan selectedProductionPlan = null;

        int productionId=0;
        for (Object object : productionPlanObjectList) {
            if (object instanceof ProductionPlan productionPlan) {
                if (productionPlan.getProductionId() == productionId) {
                    selectedProductionPlan = productionPlan;
                    break;
                }
            }
        }

        if (selectedProductionPlan == null) {
            showAlert("Production Plan not found");
            return;
        }


// Set Schedule data

        selectedProductionPlan.setStartTime(startTime);
        selectedProductionPlan.setEndTime(endTime);
        selectedProductionPlan.setWorkShift(workShift);
        selectedProductionPlan.setStatus("Scheduled");


// file write
        boolean saved = BinaryFileUtility.writeObjects("ProductionSchedule.bin", selectedProductionPlan);

        if (!saved) {
            showAlert("Production Schedule could not be saved");
            return;
        }


//Show

        showAlert(
                "Production Schedule created successfully.\n" +
                        "Production Plan ID: " + productionId + "\n" +
                        "Start Time: " + startTime + "\n" +
                        "End Time: " + endTime + "\n" +
                        "Work Shift: " + workShift
        );

    }
    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
        return;
    }


    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createScheduleOOnAction(ActionEvent actionEvent) {

        if (productionPlanIDTextField.getText() == null || productionPlanIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Plan ID should be filled");
            return;
        }
        int productionId;
        try {
            productionId = Integer.parseInt(productionPlanIDTextField.getText().trim()
            );
        } catch (NumberFormatException e) {
            showAlert("Production Plan ID must be an integer");
            return;
        }
        if (productionId <= 0) {
            showAlert("Production Plan ID must be greater than 0");
            return;
        }

        if (workShiftComboBox1.getValue() == null) {
            showAlert("Please select a Work Shift");
            return;
        }

        if (startHoursTimeComboBox.getValue() == null || startMinitueTimeComboBox.getValue() == null || endsHoursTimeComboBox.getValue() == null || endsMinutiesTimeComboBox.getValue() == null) {
            showAlert("Please select Start Time and End Time");
            return;
        }
    }
}