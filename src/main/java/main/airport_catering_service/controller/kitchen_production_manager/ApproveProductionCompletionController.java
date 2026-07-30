package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.KitchenProductionManager;

import javafx.scene.control.TextArea;
import java.io.IOException;

public class ApproveProductionCompletionController
{
    @javafx.fxml.FXML
    private TextArea completionNotesTextArea;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalStatusLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalIDLabel;
    @javafx.fxml.FXML
    private Label fxidDisplayApprovalTimeLabel;
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;
    @javafx.fxml.FXML
    private Label fxidDisplayProductionOrderIDLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void sideBarApproveProductionOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarAirportCateringServiceButtonOnA(ActionEvent actionEvent)throws IOException {
        KitchenProductionManager.reverseDashboard(actionEvent);
    }

    @javafx.fxml.FXML
    public void sideBarProductionScheduleOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOrderOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarReceiveOrdersOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ApproveCompletionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionReportsOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateIngredientOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarMenuListOnA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarProductionPlanOnA(ActionEvent actionEvent) {
    }
}