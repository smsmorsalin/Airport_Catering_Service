package main.airport_catering_service.controller.headchef;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import nonuser.QualityInspectionRequest;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;
import java.time.LocalDate;
import javafx.beans.property.SimpleObjectProperty;

public class RequestQualityInspectionController implements UserReceiver {

    @FXML
    private TableColumn<QualityInspectionRequest, Integer> requestIdColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, Integer> taskIdColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, String> mealCategoryColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, LocalDate> requestDateColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, String> priorityColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, String> remarksColumn;

    @FXML
    private TableColumn<QualityInspectionRequest, String> inspectionStatusColumn;

    @FXML
    private TableView<QualityInspectionRequest> inspectionTable;

    @FXML
    private Button submitButton;

    @FXML
    private Button loadTaskButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Button backButton;

    @FXML
    private Button resetButton;

    @FXML
    private ComboBox<String> priorityComboBox;

    @FXML
    private DatePicker inspectionDatePicker;

    @FXML
    private TextField mealCategoryField;

    @FXML
    private TextArea remarksTextArea;

    @FXML
    private TextField taskIdField;



    private Headchef loggedInUser;

    private final ObservableList<QualityInspectionRequest> inspectionRequests =
            FXCollections.observableArrayList();

    private int nextRequestId = 1;


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

        priorityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Urgent"
        );

        requestIdColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getRequestId()
                ).asObject()
        );

        taskIdColumn.setCellValueFactory(
                cellData -> new SimpleObjectProperty<>(
                        cellData.getValue().getTaskId()
                )
        );

        mealCategoryColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getMealCategory()
                )
        );

        requestIdColumn.setCellValueFactory(
                cellData -> new SimpleObjectProperty<>(
                        cellData.getValue().getRequestId()
                )
        );

        priorityColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getPriority()
                )
        );

        remarksColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getRemarks()
                )
        );

        inspectionStatusColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getInspectionStatus()
                )
        );

        inspectionTable.setItems(inspectionRequests);
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

        Headchef.renderDisplayUpdateConfirmation(
                actionEvent,
                loggedInUser
        );
    }


    @FXML
    public void resetForm(ActionEvent actionEvent) {

        taskIdField.clear();
        mealCategoryField.clear();
        remarksTextArea.clear();

        priorityComboBox.getSelectionModel()
                .clearSelection();

        inspectionDatePicker.setValue(null);
    }


    @FXML
    public void submitInspectionRequest(ActionEvent actionEvent) {

        if (taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        int taskId;

        try {

            taskId = Integer.parseInt(
                    taskIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid task ID"
            );

            return;
        }


        if (priorityComboBox.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select inspection priority"
            );

            return;
        }


        if (inspectionDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select inspection date"
            );

            return;
        }


        if (remarksTextArea.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter remarks"
            );

            return;
        }


        QualityInspectionRequest request =
                new QualityInspectionRequest(
                        nextRequestId++,
                        taskId,
                        mealCategoryField.getText(),
                        inspectionDatePicker.getValue(),
                        priorityComboBox.getValue(),
                        remarksTextArea.getText(),
                        "Pending"
                );


        inspectionRequests.add(request);

        inspectionTable.refresh();


        AlertGenerator.showAlert(
                "Success",
                "Quality inspection request submitted"
        );


        resetForm(actionEvent);
    }


    @FXML
    public void loadTask(ActionEvent actionEvent) {

        if (taskIdField.getText().isEmpty()) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a task ID"
            );

            return;
        }


        int taskId;

        try {

            taskId = Integer.parseInt(
                    taskIdField.getText()
            );

        } catch (NumberFormatException e) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please enter a valid task ID"
            );

            return;
        }


        if (taskId <= 0) {

            AlertGenerator.showAlert(
                    "Error",
                    "Task ID must be greater than zero"
            );

            return;
        }


        if (inspectionDatePicker.getValue() == null) {

            AlertGenerator.showAlert(
                    "Error",
                    "Please select an inspection date"
            );

            return;
        }


        if (inspectionDatePicker.getValue()
                .isBefore(LocalDate.now())) {

            AlertGenerator.showAlert(
                    "Error",
                    "Inspection date cannot be in the past"
            );

            return;
        }


        AlertGenerator.showAlert(
                "Success",
                "Task loaded successfully"
        );
    }
}