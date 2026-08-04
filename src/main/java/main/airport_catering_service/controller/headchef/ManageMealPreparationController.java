package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class ManageMealPreparationController implements UserReceiver
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

    private Headchef loggedInUser;
    @Override
    public void setLoggedInUser(User user){
        if (user instanceof Headchef headchef){
            loggedInUser = headchef;
        }
        AlertGenerator.showAlert("Error", "This is not a valid user for this page");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void startPreparation(ActionEvent actionEvent) {
        if(taskIdField.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a task ID");
            return;
        }
        int taskId;
        try {
            taskId = Integer.parseInt(taskIdField.getText());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }
        if(taskId <= 0) {
            AlertGenerator.showAlert("Error", "Please enter a valid task ID");
            return;
        }
        if (statusComboBox.getSelectionModel().getSelectedIndex() == 0){
            AlertGenerator.showAlert("Error", "Please enter a valid status");
            return;
        }
        if (specialRequirementTextArea.getText().isEmpty()){
            AlertGenerator.showAlert("Error", "Please enter a special requirement");
            return;
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Headchef.renderDashboardView(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderManageMealPreparation(actionEvent, loggedInUser);
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