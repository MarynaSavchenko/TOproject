package controller;

public abstract class GenericOverviewController<T> {
    public abstract void setAppController(MainAppController appController);

    public abstract void setData();
}
