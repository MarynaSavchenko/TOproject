package main;

import controller.MainAppController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.Resources;

public class Main1 extends Application {

    public final static String HOME_SCREEN_ID = "HOME";
    public final static String SENSORS_SCREEN_ID = "SENSORS";
    public final static String TASKS_SCREEN_ID = "TASKS";

    private MainAppController appController;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        appController = new MainAppController();

        appController.loadScreen(Main1.HOME_SCREEN_ID, Resources.getMainOverviewPath());
        appController.loadScreen(Main1.SENSORS_SCREEN_ID, Resources.getSensorsOverviewPanePath());
        appController.loadScreen(Main1.TASKS_SCREEN_ID, Resources.getTasksOverviewPanePath());

        appController.setScreen(Main1.HOME_SCREEN_ID);

        Group root = new Group();
        root.getChildren().addAll(appController);
        Scene scene = new Scene(root);

        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}