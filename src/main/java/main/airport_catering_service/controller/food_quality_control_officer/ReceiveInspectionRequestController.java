package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Inspection;
import user.FoodQualityControlOfficer;
import utility.AlertGenerator;

import java.io.IOException;

public class ReceiveInspectionRequestController
{
    @javafx.fxml.FXML
    private TableColumn<Inspection,String> inspectionStatusTableView;
    @javafx.fxml.FXML
    private TableColumn<Inspection,String> mealCategoryTableView;
    @javafx.fxml.FXML
    private TableView<Inspection> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<Inspection,Integer> inspectionRequestIDTableView;
    @javafx.fxml.FXML
    private TableColumn<Inspection,Integer> batchNumberTableView;
    @javafx.fxml.FXML
    private TextField inspectionRequestIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
        inspectionRequestIDTableView.setCellValueFactory(new PropertyValueFactory<>(" inspectionRequestId"));
        batchNumberTableView.setCellValueFactory(new PropertyValueFactory<>("batchNumber"));
        mealCategoryTableView.setCellValueFactory(new PropertyValueFactory<>("mealCategory"));
        inspectionRequestIDTableView.setCellValueFactory(new PropertyValueFactory<>("inspectionStatus"));
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        mainTableView.getItems().clear();
        if (inspectionRequestIDTextField.getText() == null) {
            AlertGenerator.showAlert("Invalid Input", "Id field should be filled");
            return;
        }
        int inspectionID;
        try {
            inspectionID = Integer.parseInt(inspectionRequestIDTextField.getText());
        } catch (Exception e) {
            AlertGenerator.showAlert("Wrong Input", "Id should be an Integer");
            return;
        }
        if (inspectionID <0){
            AlertGenerator.showAlert("Invalid Input","Inspection ID should i  grated than 0");
            return;
        }
    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarQualityTrendAnalysisOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarGenerateQAReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarManageQualityIssueOnAction(ActionEvent actionEvent) {
    }
}