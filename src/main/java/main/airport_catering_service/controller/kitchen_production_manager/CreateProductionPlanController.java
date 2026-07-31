package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.ProductionPlan;
import user.KitchenProductionManager;

import java.io.IOException;
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
    private Label fxidDisplayProductionDateLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayProductionPlanIDLabel;
    @javafx.fxml.FXML
    private ComboBox<String> hourTargetTimrCOmboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayMealCategoriesLabel;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> endTimeTableView;
    @javafx.fxml.FXML
    private Label fxidDisplayCompletionTimeLabel;
    @javafx.fxml.FXML
    private TableColumn<ProductionPlan, LocalTime> startTimeTableView;
    @javafx.fxml.FXML
    private TextArea specialInstructionsTextArea;
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
    public void searchOnAction(ActionEvent actionEvent) {
        int hour = Integer.parseInt(hourTargetTimrCOmboBox.getValue());
        int minute = Integer.parseInt( miniutesTargetTimrCOmboBox.getValue());
        LocalTime targetTime = LocalTime.of(hour, minute);

        if (productionOrderIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Order ID should be filled.");
            return;
        }

        int productionOrderId;

        try {
            productionOrderId = Integer.parseInt(productionOrderIDTextField.getText().trim());

            if (productionOrderId <= 0) {
                showAlert("Production Order ID must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showAlert("Production Order ID must contain numbers only.");
            return;
        }

        if (dateOfProductionDatePicker.getValue() == null) {
            showAlert("Production Date should be selected.");
            return;
        }

        if (dateOfProductionDatePicker.getValue().isBefore(LocalDate.now())) {
            showAlert("Production Date cannot be before today.");
            return;
        }

        if (hourTargetTimrCOmboBox.getValue() == null ||
                miniutesTargetTimrCOmboBox.getValue() == null) {

            showAlert("Please select the target completion time.");
            return;
        }


    }

}