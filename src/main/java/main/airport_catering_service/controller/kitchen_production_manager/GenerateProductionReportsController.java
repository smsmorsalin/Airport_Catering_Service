package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import user.KitchenProductionManager;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;


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
        reportTypeComboBox.getItems().addAll( "Daily", "Weekly", "Monthly", "Inspection", "Approval", "Rejection", "Compliance", "Quality Trend");

    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @FXML
    public void sideBarReceiveOrdersOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent);
    }

    @FXML
    public void sideBarApproveProductionOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewApproveProductionCompletion(actionEvent);
    }

    @FXML
    public void sideBarProductionPlanOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCreateProductionPlan(actionEvent);
    }

    @FXML
    public void sideBarMonitorProductionOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent);
    }

    @FXML
    public void sideBarProductionScheduleOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.ViewCreateProductionSchedule(actionEvent);
    }

    @FXML
    public void sideBarCalculateIngredientIOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent);
    }
    @FXML
    public void exportPDFOnAction(ActionEvent actionEvent) {
    }


    @FXML
    public void sideBarMenuListOA(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCreateMenuList(actionEvent);
    }

    @FXML
    public void confirmOnAction(ActionEvent actionEvent) {
        if(startDatePicker.getValue() == null || endDatePicker.getValue() ==null){
            AlertGenerator.showAlert("Invalid Input","Date must in selected");
            return;
        }
        if(startDatePicker.getValue().isAfter(endDatePicker.getValue())){
            AlertGenerator.showAlert("Invalid Input","Start Date should be before end date");
            return;
        }
        if(endDatePicker.getValue().isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Invaid Input","End date can not be present date");
            return;
        }
        if(reportTypeComboBox.getItems()==null){
            AlertGenerator.showAlert("Wrong Input","Combo Box must be selected ");
        }
    }



}