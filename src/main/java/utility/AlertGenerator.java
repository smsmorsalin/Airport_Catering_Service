package utility;

import javafx.scene.control.Alert;

public class AlertGenerator {
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }
}
