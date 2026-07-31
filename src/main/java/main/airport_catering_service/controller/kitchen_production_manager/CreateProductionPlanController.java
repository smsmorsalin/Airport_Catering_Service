package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.ProductionPlan;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateProductionPlanController {
    @javafx.fxml.FXML
    private ComboBox<String> miniutesTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, String> statusTableView;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfProductionDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> hourTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> endTimeTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> startTimeTableView;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, String> stageNameTableView;
    @javafx.fxml.FXML
    private TableView<ProductionPlan> mainTableView;

    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
    }
    @javafx.fxml.FXML
    public void initialize() {
        hourTargetTimrCOmboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        miniutesTargetTimrCOmboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59");
    }
    @FXML
    public void createPlanOnAction(ActionEvent actionEvent) {
        if (productionOrderIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Order ID should be filled.");
            return;
        }
        if ( Integer.parseInt(productionOrderIDTextField.getText()) <= 0) {
            showAlert("Production Order ID must be greater than 0.");
            return;
        }
        if (dateOfProductionDatePicker.getValue() == null) {
            showAlert("Production Date should be selected.");
            return;
        }
        if (dateOfProductionDatePicker.getValue() .isBefore(LocalDate.now())) {
            showAlert("Production Date cannot be before today.");
            return;
        }
        if (hourTargetTimrCOmboBox.getValue() == null || miniutesTargetTimrCOmboBox.getValue() == null) {
            showAlert("Please select the target completion time.");
            return;
        }
        int hour = Integer.parseInt(hourTargetTimrCOmboBox.getValue());
        int minute = Integer.parseInt(miniutesTargetTimrCOmboBox.getValue());
        LocalTime targetTime = LocalTime.of(hour, minute);
        showAlert(
                "Production Plan created successfully.\n"+"Order ID: " + productionOrderIDTextField+ "\n" + "Production Date: " + dateOfProductionDatePicker + "\n" +
                        "Target Time:" +targetTime
        );
    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarProductionReportsOA(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarCalculateIngredientOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }
    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}