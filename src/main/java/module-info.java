module main.airport_catering_service {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.airport_catering_service to javafx.fxml;
    exports main.airport_catering_service;
    exports main.airport_catering_service.controller;
    opens main.airport_catering_service.controller to javafx.fxml;
}