package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class HandleRejectedBatchController
{
    @javafx.fxml.FXML
    private TableColumn reasonColumn;
    @javafx.fxml.FXML
    private TableColumn actionColumn;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TableColumn assignedTeamColumn;
    @javafx.fxml.FXML
    private TextArea rejectionReasonTextArea;
    @javafx.fxml.FXML
    private TableView rejectedBatchTable;
    @javafx.fxml.FXML
    private TableColumn mealTypeColumn;
    @javafx.fxml.FXML
    private ComboBox actionComboBox;
    @javafx.fxml.FXML
    private ComboBox teamComboBox;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private Button loadBatchButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextArea chefRemarksTextArea;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField taskIdField;
    @javafx.fxml.FXML
    private TextField batchIdField;
    @javafx.fxml.FXML
    private TextField rejectedByField;
    @javafx.fxml.FXML
    private TableColumn batchIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadRejectedBatch(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitCorrectiveAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
    }
}