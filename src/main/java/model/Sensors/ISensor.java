package model.Sensors;

/**
 * Interface for sensors
 * There are 3 kinds of sensors:ThreadSensor, SensorType_2, SensorType_3
 * We will work with ThreadSensor, two other are for simulating possible situations
 */
import io.reactivex.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public interface ISensor{
    /**
     * @return name of Sensor
     */
    String getName();

    /**
     * @return state of Sensor
     * Possible states are declared in enum SensorState
     */
    SensorState getSensorState();

    /**
     * @param task
     * set Task to Sensor
     */
    void setTask(Runnable task);

    void getDetails();

    ObjectProperty<SensorState> getStateProperty();

    StringProperty getNameProperty();

    Observable getPublishSubject();
}
