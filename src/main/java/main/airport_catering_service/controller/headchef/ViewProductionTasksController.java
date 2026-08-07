package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ViewProductionTasksController implements UserReceiver {
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableColumn orderIdColumn;
    @javafx.fxml.FXML
    private TableView productionTaskTable;
    @javafx.fxml.FXML
    private TableColumn mealTypeColumn;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private TableColumn priorityColumn;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn completionTimeColumn;
    @javafx.fxml.FXML
    private TableColumn airlineColumn;
    @javafx.fxml.FXML
    private TableColumn mealQuantityColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private TableColumn flightColumn;
    @javafx.fxml.FXML
    private TextField productionTaskIdField;

    private Headchef loggedInUser;

    @Override
    public void setLoggedInUser(User user) {
        if (user instanceof Headchef headchef) {
            loggedInUser = headchef;
        } else {
            AlertGenerator.showAlert("Error", "This is not a valid user for this page");
        }
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderProductionTask(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
        productionTaskIdField.clear();
        orderIdField.clear();
    }

    @javafx.fxml.FXML
    public void searchTask(ActionEvent actionEvent) {

        if (productionTaskIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }

        int taskId;

        try {
            taskId = Integer.parseInt(productionTaskIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }

        if (taskId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }

        if (orderIdField.getText().isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter an order ID");
            return;
        }

        int orderId;

        try {
            orderId = Integer.parseInt(orderIdField.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }

        if (orderId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid order ID");
            return;
        }

        AlertGenerator.showAlert(
                "Success",
                "Production task information loaded successfully"
        );
    }
}