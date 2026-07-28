package utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitchingHelper {

    public static void fullSceneReplacement(javafx.event.ActionEvent event, String newScene) throws IOException {
        if (newScene.isEmpty()){
            return;
        }
        newScene = newScene.trim();
        if (newScene.isEmpty()){
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitchingHelper.class.getResource("/AirlineRepresentative/createCateringOrderView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
