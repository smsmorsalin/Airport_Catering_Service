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

        if(productionPlanIDTextField.getText().trim().isEmpty()){
            showAlert("Production Plan ID Should be filled");
            return;
        }
        if (  Integer.parseInt(productionPlanIDTextField.getText()) <= 0){
            showAlert("Production Plan ID Should be filled");
            return;
        }
        if (workShiftComboBox1 == null) {
            showAlert("ComboBox Can not be empty");
            return;
        }
        if (startMinitueTimeComboBox.getValue() == null || startHoursTimeComboBox.getValue()==null || endsHoursTimeComboBox.getValue()==null || endsMinutiesTimeComboBox.getValue()==null ) {
            showAlert("TIme ComboBox should be filled");

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