package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;

import java.io.IOException;

public class ManageMealPreparationController
{
    @javafx.fxml.FXML
    private TableColumn mealCategoryColumn;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn assignedTeamColumn;
    @javafx.fxml.FXML
    private TextArea instructionTextArea;
    @javafx.fxml.FXML
    private Button startPreparationButton;
    @javafx.fxml.FXML
    private TextArea specialRequirementTextArea;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button updateStatusButton;
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField taskIdField;
    @javafx.fxml.FXML
    private TableView preparationTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void startPreparation(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderManageMealPreparation(actionEvent);
    }

    @javafx.fxml.FXML
    public void clearForm(ActionEvent actionEvent) {
        taskIdField.clear();
        instructionTextArea.clear();
        specialRequirementTextArea.clear();
    }

    @javafx.fxml.FXML
    public void updatePreparationStatus(ActionEvent actionEvent) {
    }
}