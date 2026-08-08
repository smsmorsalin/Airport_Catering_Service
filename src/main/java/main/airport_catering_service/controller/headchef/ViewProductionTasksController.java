package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ViewProductionTasksController implements UserReceiver {

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn orderIdColumn;

    @FXML
    private TableView productionTaskTable;

    @FXML
    private TableColumn mealTypeColumn;

    @FXML
    private TableColumn taskIdColumn;

    @FXML
    private TableColumn priorityColumn;

    @FXML
    private Button clearButton;

    @FXML
    private TableColumn completionTimeColumn;

    @FXML
    private TableColumn airlineColumn;

    @FXML
    private TableColumn mealQuantityColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField orderIdField;

    @FXML
    private TableColumn flightColumn;

    @FXML
    private TextField productionTaskIdField;


    private Headchef loggedInUser;


    @Override
    public void setLoggedInUser(User user) {

        if (user instanceof Headchef headchef) {
            loggedInUser = headchef;
        }
        else {
            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page"
            );
        }
    }


    @FXML
    public void initialize() {

    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {

        Headchef.renderProductionTask(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void clearFields(ActionEvent actionEvent) {

        productionTaskIdField.clear();
        orderIdField.clear();
    }


    @FXML
    public void searchTask(ActionEvent actionEvent) {


        if (productionTaskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a production task ID"
            );

            return;
        }


        int taskId;

        try {

            taskId = Integer.parseInt(
                    productionTaskIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid production task ID"
            );

            return;
        }


        if (taskId <= 0) {

            AlertGenerator.showAlert(
                    "Error",
                    "Production task ID must be greater than zero"
            );

            return;
        }


        if (!orderIdField.getText().isEmpty()) {

            int orderId;

            try {

                orderId = Integer.parseInt(
                        orderIdField.getText()
                );

            } catch (NumberFormatException e) {

                AlertGenerator.showAlert(
                        "Error",
                        "Please enter a valid order ID"
                );

                return;
            }


            if (orderId <= 0) {

                AlertGenerator.showAlert(
                        "Error",
                        "Order ID must be greater than zero"
                );

                return;
            }
        }


        AlertGenerator.showAlert(
                "Success",
                "Production task information loaded successfully"
        );
    }
}