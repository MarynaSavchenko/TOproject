package controller;

import javafx.stage.Stage;

public abstract class SingleGenericController<T> {
    public abstract void setData(T t);

    public abstract void setStage(Stage stage);

    public abstract void initialize();
}
