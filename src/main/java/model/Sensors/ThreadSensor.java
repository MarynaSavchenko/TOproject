package model.Sensors;

import io.reactivex.subjects.PublishSubject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThreadSensor implements  ISensor, Runnable{

    private ObjectProperty<SensorState> sensorState;
    private Runnable task = null;
    private static int counter = 0;
    private StringProperty name;
    private PublishSubject<ThreadSensor> threadPublishSubject;


    public ThreadSensor() {
        this.name = new SimpleStringProperty("Thread_" + counter++);
        this.sensorState = new SimpleObjectProperty<>(SensorState.ON);
        this.threadPublishSubject = PublishSubject.create();
    }

    @Override
    public void setTask(Runnable task) {
        this.task = task;
    }

    @Override
    public void getDetails() {

    }

    /**
     * thread is waiting for new task to be added
     * when new task is added it changes state to WORKING
     * and execute task
     * after it change state to ON
     * and set task to null
     */
    @Override
    public void run() {

        sensorState.set(SensorState.WORKING);
        task.run();
        sensorState.set(SensorState.ON);
        threadPublishSubject.onNext(this);
//        threadPublishSubject.onComplete();
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public StringProperty getNameProperty() {
        return name;
    }


    @Override
    public SensorState getSensorState() {
        return sensorState.get();
    }

    @Override
    public ObjectProperty<SensorState> getStateProperty() {
        return sensorState;
    }

    public PublishSubject getPublishSubject (){
        return this.threadPublishSubject;
    }

}