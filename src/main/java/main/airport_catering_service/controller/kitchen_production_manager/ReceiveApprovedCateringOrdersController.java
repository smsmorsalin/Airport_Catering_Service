package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class ReceiveApprovedCateringOrdersController
{
    @javafx.fxml.FXML
    private TableColumn productionOrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn mealTypesTableView;
    @javafx.fxml.FXML
    private TableColumn airlineNameTableView;
    @javafx.fxml.FXML
    private TableColumn deliveryDeadlineTableView;
    @javafx.fxml.FXML
    private TableView mainTableView;
    @FXML
    private TextField productionTaskIDTextField;
    @FXML
    private TableColumn mealQuantityTableView;
    @FXML
    private TextField orderIDTextField1;

    @FXML
    private AnchorPane anchorPan;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sidebarAirporCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlL =  new FXMLLoader(dashboardViewController.class.getResource("dashboardView"));
//        Node node = fxmlL.load();
//        mainPane.getChildren().setAll(node);

        FXMLLoader registerFXML = new FXMLLoader(getClass().getResource("/main/airport_catering_service/dashboardView.fxml"));
        Node node = registerFXML.load();
        anchorPan.getChildren().setAll(node);

    }

    @Deprecated
    public void manageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void assignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarmanageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarHandleRejectedBatchOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sidebarAirportCateringServiceButtonOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarRequestQualityInspectionOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarUpdateProductionStatusOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarMonitorCookingProgressOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarassignKitchenStaffOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void homeButtonAirportCateringServiceOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sideBarKitchenPerformanceReportOnAction(ActionEvent actionEvent) {
    }
}