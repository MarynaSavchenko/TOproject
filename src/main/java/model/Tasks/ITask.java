package model.Tasks;


import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;

import model.Sensors.ISensor;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public interface ITask<T> {

    void setType(TaskType details);

    TaskType getType();

    void setResult(T result);

    T getResult();

    ObjectProperty<TaskType> getTypeProperty();

    T execute() throws InterruptedException;

}
