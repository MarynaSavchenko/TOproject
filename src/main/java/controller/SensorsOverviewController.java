package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main1;
import model.Sensors.ISensor;
import model.Sensors.SensorState;
import model.Sensors.ThreadSensor;
import model.Server.Server;
import resources.Resources;

public class SensorsOverviewController extends GenericOverviewController<ISensor> implements ControlledScreen{
    private MainAppController appController;

    private static final String STAGE_TITLE = "SENSORS OVERVIEW";

    private static final String SENSOR_DETAILS_DIALOG_TITLE = "SENSOR DETAILS";

    @FXML
    private TableView<ISensor> sensorsTable;

    @FXML
    private TableColumn<ISensor, String> sensorNameColumn;

    @FXML
    private TableColumn<ISensor, SensorState> sensorStateColumn;

    @FXML
    private Button showDetailsButton;

    @FXML
    private void initialize() {
        sensorsTable.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE);

        sensorNameColumn.setCellValueFactory(dataValue -> dataValue.getValue()
                .getNameProperty());
        sensorStateColumn.setCellValueFactory(dataValue -> dataValue.getValue()
                .getStateProperty());

        showDetailsButton.disableProperty().bind(
                Bindings.size(
                        sensorsTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));
        setData();
    }

    @FXML
    private void handleShowDetailsAction(ActionEvent event) {
        ISensor sensor = sensorsTable.getSelectionModel()
                .getSelectedItem();
        if (sensor != null) {
            appController.showDialog(sensor, SENSOR_DETAILS_DIALOG_TITLE, Resources.getSensorOverviewDialogPath());
        }
    }

    @Override
    public void setAppController(MainAppController appController) {
        this.appController = appController;
    }

    @Override
    public void setData() { //todo delete simple hardcoded data
        ISensor sensor1 = new ThreadSensor();
        ISensor sensor2 = new ThreadSensor();

        Server.getInstance().getSensors().add(sensor1);
        Server.getInstance().getSensors().add(sensor2);

        sensorsTable.setItems(Server.getInstance().getSensors());
    }

    @Override
    public void setScreenParent(MainAppController screenParent) {
        appController = screenParent;
    }

    @FXML
    private void goToHomeScreen(ActionEvent event){
        appController.setScreen(Main1.HOME_SCREEN_ID);
    }
}
