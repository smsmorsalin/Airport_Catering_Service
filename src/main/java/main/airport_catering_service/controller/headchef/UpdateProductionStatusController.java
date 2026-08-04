package main.airport_catering_service.controller.headchef;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import user.Headchef;
import user.User;
import user.UserReceiver;
import utility.AlertGenerator;

import java.io.IOException;

public class UpdateProductionStatusController implements UserReceiver {
    @javafx.fxml.FXML
    private TableColumn mealCategoryColumn;
    @javafx.fxml.FXML
    private TableView productionTable;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private Label completionLabel;
    @javafx.fxml.FXML
    private TextField currentStatusField;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TableColumn taskIdColumn;
    @javafx.fxml.FXML
    private TableColumn completionColumn;
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableColumn lastUpdatedColumn;
    @javafx.fxml.FXML
    private TableColumn teamColumn;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Slider completionSlider;
    @javafx.fxml.FXML
    private Button updateButton;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField taskIdField;
    @javafx.fxml.FXML
    private Button resetButton;

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
    public void updateStatus(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) throws IOException {
        Headchef.renderDisplayCookingProgress(actionEvent, loggedInUser);
    }

    @javafx.fxml.FXML
    public void resetForm(ActionEvent actionEvent) {
        taskIdField.clear();
        remarksTextArea.clear();
    }

    @javafx.fxml.FXML
    public void loadTask(ActionEvent actionEvent) {
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

    }
}