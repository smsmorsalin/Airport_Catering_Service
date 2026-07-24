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


public class viewProductionTaskController
{
    @javafx.fxml.FXML
    private TableColumn productionOrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn mealTypesTableView;
    @javafx.fxml.FXML
    private TableColumn mealQualityTableView;
    @javafx.fxml.FXML
    private TableColumn airlineNameTableView;
    @javafx.fxml.FXML
    private TableColumn deliveryDeadlineTableView;
    @javafx.fxml.FXML
    private TableView mainTableView;
    @javafx.fxml.FXML
    private TextField inspectionRequestIDTextField;

    @FXML
    private AnchorPane mainPane;

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

    @javafx.fxml.FXML
    public void sidebarAirporCateringServiceButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlL =  new FXMLLoader(dashboardViewController.class.getResource("dashboardView"));
        Node node = fxmlL.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void manageMealPreparationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void assignKitchenStaffOnAction(ActionEvent actionEvent) {
    }
}