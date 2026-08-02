package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import nonuser.DashBoard;
import user.FoodQualityControlOfficer;
import user.User;
import utility.AlertGenerator;

import java.io.IOException;


public class dashboardController {
    @javafx.fxml.FXML
    private TableColumn<String,DashBoard> descriptionTableView;
    @javafx.fxml.FXML
    private Label enterTicketIDTextField;
    @javafx.fxml.FXML
    private TextField enterTicketIDtextField;
    @javafx.fxml.FXML
    private Label emargencyIssueLabel;
    @javafx.fxml.FXML
    private TableColumn<Integer,DashBoard> ticketIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<String,DashBoard> statusTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TableView<DashBoard> mainTableView;
    @javafx.fxml.FXML
    private TableColumn<Boolean,DashBoard> issueTypeTableView;

    private AnchorPane reg_anchorPane;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending","Processing","Completed");
    }
    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        mainTableView.getItems().clear();

        if(statusComboBox.getValue() == null){
            AlertGenerator.showAlert("Invalid Input","ComboBox items should be selected");
            return;
        }
        if(enterTicketIDTextField.getText().trim().isEmpty()){
            AlertGenerator.showAlert("Invalid Input","Ticket Id should be filled");
            return;
        }
        int ticketId;
        try{
            ticketId = Integer.parseInt(enterTicketIDTextField.getText());
        }catch (Exception e){
            AlertGenerator.showAlert("Invalid Input","Ticket Id should be only Integer");
            return;
        }
        if(ticketId <= 0){
            AlertGenerator.showAlert("Invalid Input","Ticker Id should not be grater than 0");
            return;
        }
    }


    @javafx.fxml.FXML
    public void sideBarQAReportOnAction(ActionEvent actionEvent) throws  IOException {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarQualityIssueOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.viewManageQualityIssue(actionEvent);


    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.viewRejectBatch(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.viewFoodSafetyCheck(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarInspectionRequestOnAction(ActionEvent actionEvent) throws IOException{
        FoodQualityControlOfficer.viewReceiveInspectionRequest(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarAirportCateringServiceOnAction(ActionEvent actionEvent) {
//        FoodQualityControlOfficer.viewQualityTrendAnalysis(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent)throws IOException {
        FoodQualityControlOfficer.viewPerformInspection(actionEvent);
    }


    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) throws  IOException{
        FoodQualityControlOfficer.viewApproveBatch(actionEvent);


    }

    @javafx.fxml.FXML
    public void sideBarTrendAnalysisOnAction(ActionEvent actionEvent) throws IOException {
        FoodQualityControlOfficer.viewQualityTrendAnalysis(actionEvent);


    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws  IOException{
        User.logout(actionEvent);
    }
}