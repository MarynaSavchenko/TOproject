package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Sensors.ISensor;

public class SensorOverviewController extends SingleGenericController<ISensor> {
    private ISensor sensor;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextArea detailsTextArea;

    private Stage sensorStage;

    @Override
    public void setStage(Stage sensorStage) {
        this.sensorStage = sensorStage;
    }

    @FXML
    private void handleCloseAction(ActionEvent event) {
        sensorStage.close();
    }

    @FXML
    public void initialize() {
        nameTextField.setEditable(false);
        stateTextField.setEditable(false);
        detailsTextArea.setEditable(false);
    }

    public void setData(ISensor sensor) {
        this.sensor = sensor;
        setControls();
    }

    private void setControls() {
        nameTextField.setText(sensor.getName());
        stateTextField.setText(String.valueOf(sensor.getSensorState()));
    }
}
