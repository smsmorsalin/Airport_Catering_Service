package main.airport_catering_service.controller.kitchen_production_manager;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import nonuser.DashBoard;
import user.User;
import user.KitchenProductionManager;
import user.UserReceiver;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;


public class dashboardController implements UserReceiver {
    @javafx.fxml.FXML
    private TableColumn<String,DashBoard>descriptionTableView;
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

    private KitchenProductionManager loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof KitchenProductionManager kitchenProductionManager){
            loggedInUser = kitchenProductionManager;
        }else{
        AlertGenerator.showAlert("error", "error Authentication failed");
        }
    }

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
    public void sideBarAirportCateringServiceOnAction(ActionEvent actionEvent)throws  IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }
    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent)throws  IOException {
        User.logout(actionEvent);
    }



    @javafx.fxml.FXML
    public void sideBarMonitorProductionOnAction(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewMonitorProductionActivities(actionEvent,loggedInUser);


    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOnAction(ActionEvent actionEvent) throws IOException {
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);

    }

    @javafx.fxml.FXML
    public void sideBarMenuListOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/KitchenProductionManager/CreateMenuList.fxml", loggedInUser);


    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOnAction(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewReceiveApprovedCateringOrders(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarApproveProductionOnAction(ActionEvent actionEvent) throws IOException {

        KitchenProductionManager.viewApproveProductionCompletion(actionEvent,loggedInUser);

    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOnAction(ActionEvent actionEvent) throws IOException{
        KitchenProductionManager.viewCalculateIngredientRequirements(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOnAction(ActionEvent actionEvent)throws  IOException {
        KitchenProductionManager.viewGenerateProductionReports(actionEvent,loggedInUser);
    }

    @javafx.fxml.FXML
    public void sideBarProductionPlanOnAction(ActionEvent actionEvent) throws  IOException{
        KitchenProductionManager.viewCreateProductionPlan(actionEvent,loggedInUser);
    }


}