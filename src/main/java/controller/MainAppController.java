package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main1;
import resources.Resources;

import java.io.IOException;
import java.util.HashMap;

public class MainAppController extends StackPane {
    private Stage primaryStage;

    public MainAppController() {
        super();
    }

    private HashMap<String, Node> screens = new HashMap<>();


    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = myLoader.load();
            ControlledScreen myScreenController = myLoader.getController();
            myScreenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {
        if (screens.get(name) != null) {
            if (!getChildren().isEmpty()) {
                getChildren().remove(0);
                getChildren().add(0, screens.get(name));
            } else {
                getChildren().add(screens.get(name));
            }
            return true;
        } else {
            return false;
        }
    }

    public void initRootLayout(String title, String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main1.class.getResource(path));
            BorderPane rootLayout = (BorderPane) loader.load();

            GenericOverviewController controller = loader.getController();
            controller.setAppController(this);
            controller.setData();
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public <T> void showDialog(T t, String title, String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main1.class.getResource(path));
            BorderPane page = (BorderPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            stage.setScene(scene);

            SingleGenericController controller = loader.getController();
            controller.setStage(stage);
            controller.setData(t);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}