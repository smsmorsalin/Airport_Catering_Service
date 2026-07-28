package main.airport_catering_service.controller.finance_and_billing_manager;

import javafx.event.ActionEvent;
import user.FinanceAndBillingManager;

import javax.imageio.IIOException;
import java.io.IOException;

public class dashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sidebarLogOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sidebarHomePageOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sideBarCalculateCostButtonOnAction(ActionEvent actionEvent) throws IOException {
        FinanceAndBillingManager.viewCalculateCost(actionEvent);
    }
}