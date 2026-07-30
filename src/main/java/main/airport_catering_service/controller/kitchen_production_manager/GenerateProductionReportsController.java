package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import user.KitchenProductionManager;

import java.io.IOException;


public class GenerateProductionReportsController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalProductionOrdersLabel;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private Label fxidDisplayTotalMealsProducedLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayDelayedProductionsLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayAverageProductionTimeLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayCompletionRateLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) {
    }

    @FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarCalculateIngredientIOA(ActionEvent actionEvent) {
    }

    @FXML
    public void eportPDFOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) {
    }
}