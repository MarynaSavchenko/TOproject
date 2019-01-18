package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main1;

public class MainOverviewController implements ControlledScreen {

    MainAppController appController;

    public void setScreenParent(MainAppController screenParent){
        appController = screenParent;
    }

    @FXML
    private void goToSensors(ActionEvent event){
        appController.setScreen(Main1.SENSORS_SCREEN_ID);

    }

    @FXML
    private void goToTasks(ActionEvent event){
        appController.setScreen(Main1.TASKS_SCREEN_ID);
    }
}