module main.airport_catering_service {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens main.airport_catering_service to javafx.fxml;
    exports main.airport_catering_service;
    exports main.airport_catering_service.controller;
    opens main.airport_catering_service.controller to javafx.fxml;
    opens main.airport_catering_service.controller.airline_representative to javafx.fxml;
    opens main.airport_catering_service.controller.catering_operations_manager to javafx.fxml;
}