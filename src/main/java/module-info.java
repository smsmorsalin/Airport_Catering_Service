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
    opens main.airport_catering_service.controller.food_quality_control_officer to javafx.fxml;
    opens main.airport_catering_service.controller.kitchen_production_manager to javafx.fxml;
    opens main.airport_catering_service.controller.finance_and_billing_manager to javafx.fxml;
    opens main.airport_catering_service.controller.customer_support_officer to javafx.fxml;
    opens main.airport_catering_service.controller.dispatch_coordinator to javafx.fxml;
    opens main.airport_catering_service.controller.inventory_manager to javafx.fxml;
    opens main.airport_catering_service.controller.headchef to  javafx.fxml;
    opens main.airport_catering_service.controller.truck_operator to javafx.fxml;
    opens nonuser to javafx.base;

}