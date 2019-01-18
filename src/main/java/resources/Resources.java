package resources;

public final class Resources {
    private final static String TASKS_OVERVIEW_PANE_PATH = "../view/TasksOverviewPane.fxml";
    private final static String TASK_OVERVIEW_DIALOG_PATH = "../view/TaskOverviewDialog.fxml";
    private final static String SENSORS_OVERVIEW_PANE_PATH = "../view/SensorsOverviewPane.fxml";
    private final static String SENSOR_OVERVIEW_DIALOG_PATH = "../view/SensorOverviewDialog.fxml";
    private final static String MAIN_OVERVIEW_DIALOG_PATH = "../view/MainOverviewPane.fxml";


    public static String getTasksOverviewPanePath() {
        return TASKS_OVERVIEW_PANE_PATH;
    }

    public static String getTaskOverviewDialogPath() {
        return TASK_OVERVIEW_DIALOG_PATH;
    }

    public static String getSensorsOverviewPanePath() {
        return SENSORS_OVERVIEW_PANE_PATH;
    }

    public static String getSensorOverviewDialogPath() {
        return SENSOR_OVERVIEW_DIALOG_PATH;
    }

    public static String getMainOverviewPath() { return MAIN_OVERVIEW_DIALOG_PATH; }
}
