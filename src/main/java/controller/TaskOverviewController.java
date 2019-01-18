package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Tasks.ITask;
import model.Tasks.TaskType;

public class TaskOverviewController extends SingleGenericController<ITask>{
    private ITask task;

    private boolean shouldBeEditable = false;     //todo add different behaviour: new task / edit

    @FXML
    private ComboBox<TaskType> taskTypesComboBox;

    @FXML
    private TextArea detailsTextArea;

    private Stage taskStage;

    @Override
    public void setStage(Stage taskStage) {
        this.taskStage = taskStage;
    }

    @Override
    public void setData(ITask task) {
        this.task = task;
        setControls();
    }

    private void setControls() {
        for (TaskType taskType : TaskType.values()) {
            taskTypesComboBox.getItems().add(taskType);
        }
    }

    @FXML @Override
    public void initialize() {
        detailsTextArea.setEditable(shouldBeEditable);
    }

    @FXML
    private void handleCloseAction(ActionEvent event) {
        taskStage.close();
    }

    //todo @FXML
    public void handleAddTaskAction(ActionEvent actionEvent) {
        shouldBeEditable = true;
    }
}
