package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.ProductionPlan;
import user.KitchenProductionManager;

import java.io.IOException;

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
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60");
        endsHoursTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        endsMinutiesTimeComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60");

        workShiftComboBox1.getItems().addAll("Day", "Night");
    }

    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
    }


    @Deprecated
    public void clearOnAction(ActionEvent actionEvent) {

        if (workShiftComboBox1 == null) {
            showAlert("ComboBox Can not be empty");
        }

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
    public void createScheduleOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void confirmOnAction(ActionEvent actionEvent) {
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
}

//    }
//}@FXML
//public void createProductionPlanOnAction(ActionEvent actionEvent) {
//
//    String productionPlanId = productionPlanIDTextField.getText();
//
//    String startHour = startHoursTimeComboBox.getValue();
//    String startMinute = startMinitueTimeComboBox.getValue();
//
//    String endHour = endsHoursTimeComboBox.getValue();
//    String endMinute = endsMinutiesTimeComboBox.getValue();
//
//    String workShift = workShiftComboBox1.getValue();
//
//    // Check empty Production Plan ID
//    if (productionPlanId == null || productionPlanId.trim().isEmpty()) {
//        showAlert("Validation Error", "Please enter Production Plan ID.");
//        return;
//    }
//
//    // Check Production Plan ID is integer
//    try {
//        int id = Integer.parseInt(productionPlanId);
//
//        if (id <= 0) {
//            showAlert(
//                    "Validation Error",
//                    "Production Plan ID must be greater than 0."
//            );
//            return;
//        }
//
//    } catch (NumberFormatException e) {
//        showAlert(
//                "Validation Error",
//                "Production Plan ID must contain numbers only."
//        );
//        return;
//    }
//
//    // Check start time
//    if (startHour == null || startMinute == null) {
//        showAlert(
//                "Validation Error",
//                "Please select both start hour and start minute."
//        );
//        return;
//    }
//
//    // Check end time
//    if (endHour == null || endMinute == null) {
//        showAlert(
//                "Validation Error",
//                "Please select both end hour and end minute."
//        );
//        return;
//    }
//
//    // Check work shift
//    if (workShift == null) {
//        showAlert(
//                "Validation Error",
//                "Please select a work shift."
//        );
//        return;
//    }
//
//    int startHourValue = Integer.parseInt(startHour);
//    int startMinuteValue = Integer.parseInt(startMinute);
//
//    int endHourValue = Integer.parseInt(endHour);
//    int endMinuteValue = Integer.parseInt(endMinute);
//
//    LocalTime startTime = LocalTime.of(
//            startHourValue,
//            startMinuteValue
//    );
//
//    LocalTime endTime = LocalTime.of(
//            endHourValue,
//            endMinuteValue
//    );
//
//    // Check end time is after start time
//    if (!endTime.isAfter(startTime)) {
//        showAlert(
//                "Validation Error",
//                "End time must be after start time."
//        );
//        return;
//    }
//
//    showAlert(
//            "Success",
//            "Production plan information is valid."
//    )
//
