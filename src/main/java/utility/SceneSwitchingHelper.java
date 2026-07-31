package utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.User;
import user.UserReceiver;

import java.io.IOException;

public class SceneSwitchingHelper {

    public static void fullSceneReplacement(javafx.event.ActionEvent event, String fxml) throws IOException {
        if (fxml.isEmpty()){
            return;
        }
        fxml = fxml.trim();
        if (fxml.isEmpty()){
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitchingHelper.class.getResource(fxml));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

        public static void switchSceneWithData(javafx.event.ActionEvent event, String fxml, User user) {

            try {
                FXMLLoader loader = new FXMLLoader(SceneSwitchingHelper.class.getResource(fxml));
                Parent root = loader.load();
                Object controller = loader.getController();
                if (controller instanceof UserReceiver receiver) {
                    receiver.setLoggedInUser(user);
                }
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
