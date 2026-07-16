module main.airport_catering_service {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.airport_catering_service to javafx.fxml;
    exports main.airport_catering_service;
}