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
import user.AirlineRepresentative;
import user.CateringOperationsManager;
import user.User;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

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
        int userId = 0;
        try {
            userId = Integer.parseInt(fxidUsernameTextField.getText());
        }catch (NumberFormatException e){
            if(fxidUsernameTextField.getText().equals("admin")){
                SceneSwitchingHelper.fullSceneReplacement(event, "/main/airport_catering_service/createNewEmployeeView.fxml");
                return;
            }
        }
        String password = fxidPasswordTextfield.getText();

        User loggedInUser = User.verifyLogin(userId, password);

        if (loggedInUser == null) {
            AlertGenerator.showAlert(
                    "Error",
                    "Invalid username or password."
            );
            return;
        }

        if (loggedInUser instanceof AirlineRepresentative) {
            SceneSwitchingHelper.switchSceneWithData(
                    event,
                    "/AirlineRepresentative/dashboardView.fxml",
                    loggedInUser
            );
        }
        else if (loggedInUser instanceof CateringOperationsManager) {
            SceneSwitchingHelper.switchSceneWithData(
                    event,
                    "/CateringOperationsManager/businessDashboardView.fxml",
                    loggedInUser
            );
        }

        else if (fxidUsernameTextField.getText().equals("3")) {
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
        else if (fxidUsernameTextField.getText().equals("7")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Truckoperator/DashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (fxidUsernameTextField.getText().equals("8")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Headchef/DashboardView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        else if (fxidUsernameTextField.getText().equals("admin")) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/main/airport_catering_service/createNewEmployeeView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}