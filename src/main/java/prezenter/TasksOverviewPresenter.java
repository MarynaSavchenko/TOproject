package prezenter;

import controller.*;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Main1;
import model.Server.Server;
import model.Tasks.BigFactorial;
import model.Tasks.ITask;
import model.Tasks.TaskType;
import model.Tasks.TasksFactory;
import resources.Resources;

public class TasksOverviewPresenter extends GenericOverviewController<ITask> implements ControlledScreen {

    private MainAppController appController;

    private static final String STAGE_TITLE = "TASKS OVERVIEW";


    private ITask task;

    private static final String ADD_TASK_DIALOG_TITLE = "ADD TASK";

    private static final String SHOW_TASK_DIALOG_TITLE = "TASK DETAILS";

    @FXML
    private TableView<ITask> tasksTable;

    @FXML
    private TableColumn<ITask, TaskType> typeColumn;


    @FXML
    private Button showDetailsButton;

    @FXML
    private Button addTaskButton;

    @FXML
    private void initialize() {
        tasksTable.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE);

        typeColumn.setCellValueFactory(dataValue -> dataValue.getValue().getTypeProperty());
//        sensorStateColumn.setCellValueFactory(dataValue -> dataValue.getValue()
//                .getStateProperty());

        showDetailsButton.disableProperty().bind(
                Bindings.size(
                        tasksTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));
        setData();
    }


    @Override
    public void setAppController(MainAppController appController) {
        this.appController = appController;
    }

    @Override
    public void setData() {
        ITask task1 = new TasksFactory().createTask(TaskType.BIGFACTORIAL, 11);
        ITask task2 = new TasksFactory().createTask(TaskType.BIGFACTORIAL, 13);


        Server.getInstance().getTasks().add(task1);
        Server.getInstance().getTasks().add(task2);

        tasksTable.setItems(Server.getInstance().getTasks());
    }

    @FXML
    public void handleAddTaskAction(ActionEvent actionEvent) {
        //todo edit
        appController.showDialog(new BigFactorial(12), ADD_TASK_DIALOG_TITLE, Resources.getTaskOverviewDialogPath());
    }

    @FXML
    private void handleShowDetailsAction(ActionEvent event) {
        ITask task = tasksTable.getSelectionModel()
                .getSelectedItem();
        if (task != null) {
            appController.showDialog(task, SHOW_TASK_DIALOG_TITLE, Resources.getTaskOverviewDialogPath());
        }
    }

    @Override
    public void setScreenParent(MainAppController screenParent) {
        appController = screenParent;
    }

    @FXML
    private void goToHomeScreen(ActionEvent event) {
        appController.setScreen(Main1.HOME_SCREEN_ID);
    }
}
