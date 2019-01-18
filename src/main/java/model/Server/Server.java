package model.Server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Sensors.ISensor;
import model.Sensors.ThreadSensor;
import model.Tasks.BigFactorial;
import model.Tasks.ITask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SINGELTON INSTANCE
 */
public class Server {

    private ObservableList<ISensor> sensors;
    private ObservableList<ITask> tasks;
    private static SensorsAndTasksManager sensorsAndTasksManager;

    /**
     * TO DO: IS IT POSSIBLE TO HAVE ONE LIST FOR EVERY TYPE OF SENSORS???
     * Server has SensorsAndTasksManager, which is responsible for assigning tasks to sensors
     * Server has 2 types of ListsSensors:
     *      one contains of ThreadSensors, we need this list in SensorThreadfactory
     *      other is for other
     */
    private Server() {
        sensorsAndTasksManager = new SensorsAndTasksManager();
        sensors = FXCollections.observableArrayList();
        tasks = FXCollections.observableArrayList();
    }

    private static class InstanceHolder {
        private static final Server INSTANCE = new Server();
    }

    public static Server getInstance(){
        return InstanceHolder.INSTANCE;
    }


    /**
     * TO DO
     */
    public void pingSensors(){}


    public ObservableList<ISensor> getSensors(){
        return sensors;
    }

    public ObservableList<ITask> getTasks(){
        return tasks;
    }

    public SensorsAndTasksManager getSTmanager(){ return sensorsAndTasksManager; }
}

