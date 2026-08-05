package main.airport_catering_service.controller.food_quality_control_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import nonuser.DashBoard;
import user.*;
import utility.AlertGenerator;

import java.io.IOException;


public class dashboardController implements UserReceiver {
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

    private FoodQualityControlOfficer loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof FoodQualityControlOfficer foodQualityControlOfficer){
            loggedInUser = foodQualityControlOfficer;
            return;
        }
        AlertGenerator.showAlert("error", "error Authentication failed");
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending","Processing","Completed");
    }
    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
//        String name = loggedInUser.getFullName();
//        AlertGenerator.showAlert(name, "Your name is "+name);

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
    public void sideBarAirportCateringServiceOnAction(ActionEvent actionEvent) throws IOException{
        FoodQualityControlOfficer.reverseFQCDashboard(actionEvent );
    }


    @javafx.fxml.FXML
    public void sideBarQAReportOnAction(ActionEvent actionEvent)  {
        FoodQualityControlOfficer.viewGenerateQAReport(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarQualityIssueOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewManageQualityIssue(actionEvent,loggedInUser );


    }

    @javafx.fxml.FXML
    public void sideBarRejectBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewRejectBatch(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarFoodSafetyCheckOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewFoodSafetyCheck(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void sideBarInspectionRequestOnAction(ActionEvent actionEvent){
        FoodQualityControlOfficer.viewReceiveInspectionRequest(actionEvent,loggedInUser );
    }



    @javafx.fxml.FXML
    public void sideBarPerformInspectionOnAction(ActionEvent actionEvent){
        FoodQualityControlOfficer.viewPerformInspection(actionEvent,loggedInUser );
    }


    @javafx.fxml.FXML
    public void sideBarApproveBatchOnAction(ActionEvent actionEvent) {
        FoodQualityControlOfficer.viewApproveBatch(actionEvent,loggedInUser );


    }

    @javafx.fxml.FXML
    public void sideBarTrendAnalysisOnAction(ActionEvent actionEvent)  {
        FoodQualityControlOfficer.viewApproveBatch(actionEvent,loggedInUser );
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws  IOException{
        User.logout(actionEvent);
    }
}