package main.airport_catering_service.controller.headchef;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.ProductionTask;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ViewProductionTasksController implements UserReceiver {

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<ProductionTask, Integer> orderIdColumn;

    @FXML
    private TableView<ProductionTask> productionTaskTable;

    @FXML
    private TableColumn<ProductionTask, String> mealTypeColumn;

    @FXML
    private TableColumn<ProductionTask, Integer> taskIdColumn;

    @FXML
    private TableColumn<ProductionTask, String> priorityColumn;

    @FXML
    private Button clearButton;

    @FXML
    private TableColumn<ProductionTask, String> completionTimeColumn;

    @FXML
    private TableColumn<ProductionTask, String> airlineColumn;

    @FXML
    private TableColumn<ProductionTask, Integer> mealQuantityColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField orderIdField;

    @FXML
    private TableColumn<ProductionTask, String> flightColumn;

    @FXML
    private TextField productionTaskIdField;


    private Headchef loggedInUser;

    private final ObservableList<ProductionTask> productionTasks =
            FXCollections.observableArrayList();


    @Override
    public void setLoggedInUser(User user) {

        if (user instanceof Headchef headchef) {
            loggedInUser = headchef;
        } else {
            AlertGenerator.showAlert(
                    "Error",
                    "This is not a valid user for this page"
            );
        }
    }


    @FXML
    public void initialize() {

        taskIdColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(
                        cellData.getValue().getTaskId()
                ).asObject()
        );

        orderIdColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(
                        cellData.getValue().getOrderId()
                ).asObject()
        );

        mealTypeColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getMealType()
                )
        );

        mealQuantityColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(
                        cellData.getValue().getMealQuantity()
                ).asObject()
        );

        priorityColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getPriority()
                )
        );

        airlineColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getAirline()
                )
        );

        flightColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getFlight()
                )
        );

        completionTimeColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getCompletionTime()
                )
        );

        productionTaskTable.setItems(productionTasks);
    }


    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {

        Headchef.renderDashboardView(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void refreshTable(ActionEvent actionEvent) {

        productionTasks.clear();
        productionTaskTable.refresh();

        AlertGenerator.showAlert(
                "Success",
                "Production task table cleared"
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


        int orderId = taskId * 10;

        if (!orderIdField.getText().isEmpty()) {

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


        ProductionTask task =
                new ProductionTask(
                        taskId,
                        orderId,
                        "Chicken Meal",
                        100,
                        "High",
                        "Biman Bangladesh Airlines",
                        "BG-305",
                        "18:00",
                        "Pending"
                );


        productionTasks.clear();
        productionTasks.add(task);

        productionTaskTable.refresh();


        AlertGenerator.showAlert(
                "Success",
                "Production task information loaded successfully"
        );
    }
}