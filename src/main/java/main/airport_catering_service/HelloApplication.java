package main.airport_catering_service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.DummyDataGenerator;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/main/airport_catering_service/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Airport Catering Service");
        stage.setScene(scene);
        stage.show();


//        DummyDataGenerator.DeleteAllUser();
//        DummyDataGenerator.morsalin();
        DummyDataGenerator.totalUser();


    }
}