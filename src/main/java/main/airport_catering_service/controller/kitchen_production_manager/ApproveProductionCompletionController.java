package main.airport_catering_service.controller.kitchen_production_manager;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.KitchenProductionManager;

import javafx.scene.control.TextArea;
import java.io.IOException;

public class ApproveProductionCompletionController
{
    @javafx.fxml.FXML
    private TextField productionOrderIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void showAlert(String s) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(s);
        a.showAndWait();
        return;
    }

    @javafx.fxml.FXML
    public void ApproveCompletionOnAction(ActionEvent actionEvent) {

        if (productionOrderIDTextField.getText() == null || productionOrderIDTextField.getText().trim().isEmpty()) {
            showAlert("Production Plan ID should be filled");
            return;
        }

        int productionId;
        try {
            productionId = Integer.parseInt(productionOrderIDTextField.getText().trim());
        } catch (Exception e) {
            showAlert("Production Plan ID must be an integer");
            return;
        }
        if (productionId <= 0) {
            showAlert("Production Plan ID must be greater than 0");
            return;
        }
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
    public void sideBarReceiveOrdersOnA(ActionEvent actionEvent) {
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