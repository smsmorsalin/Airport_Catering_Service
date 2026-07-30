package main.airport_catering_service.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController
{
    @javafx.fxml.FXML
    private TextField fxidPasswordTextfield;
    @javafx.fxml.FXML
    private TextField fxidUsernameTextField;
    @FXML
    private AnchorPane login_anchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void supportTeamButtonOnClick(Event event) {
    }

    @FXML
    public void registerButtonOnClick(Event event) throws IOException {
       FXMLLoader registerFXML = new FXMLLoader(getClass().getResource("/main/airport_catering_service/airlineRepresentativeSelfRegisterView.fxml"));
       Node node = registerFXML.load();
       login_anchorPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void loginButtonOnClick(ActionEvent event) throws IOException {
        if (fxidUsernameTextField.getText().equals("1")){
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/AirlineRepresentative/dashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (fxidUsernameTextField.getText().equals("2")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/CateringOperationsManager/businessDashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (fxidUsernameTextField.getText().equals("3")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/CustomerSupportOfficer/dashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (fxidUsernameTextField.getText().equals("4")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/FinanceAndBillingManager/dashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        else if (fxidUsernameTextField.getText().equals("9")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/KitchenProductionManager/dashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (fxidUsernameTextField.getText().equals("10")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/FoodQualityControlOfficer/dashboardView.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (fxidUsernameTextField.getText().equals("5")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/InventoryManager/DashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        else if (fxidUsernameTextField.getText().equals("6")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/DispatchCoordinator/DashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}