package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;

import java.io.IOException;

public class RequestQualityInspectionController
{
    @javafx.fxml.FXML
    private TableColumn mealCategoryColumn;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn requestDateColumn;
    @javafx.fxml.FXML
    private Button loadTaskButton;
    @javafx.fxml.FXML
    private TableView inspectionTable;
    @javafx.fxml.FXML
    private ComboBox priorityComboBox;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private TableColumn priorityColumn;
    @javafx.fxml.FXML
    private TableColumn inspectionStatusColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private DatePicker inspectionDatePicker;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField mealCategoryField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField taskIdField;
    @javafx.fxml.FXML
    private Button resetButton;
    @javafx.fxml.FXML
    private TableColumn requestIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderDisplayUpdateConfirmation(actionEvent);
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        taskIdField.clear();
        mealCategoryField.clear();
        remarksTextArea.clear();

    }

    @javafx.fxml.FXML
    public void submitInspectionRequest(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTask(ActionEvent actionEvent) {
    }
}