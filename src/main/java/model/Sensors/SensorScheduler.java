package model.Sensors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.NewThreadWorker;
import javafx.collections.ObservableList;
import model.Server.Server;
import java.util.concurrent.ThreadFactory;


class SensorThreadFactory implements ThreadFactory {


    /**
     * TO DO:
     * it can run indefinitely
     *
     * @param r - task to execute on this Thread
     * @return Thread, where task will be executed
     * first getting a SensorsList and searching through it
     * while Sensor of State ON and Runnable is found
     * setTask r to this ThreadSensor
     */
    @Override
    public Thread newThread(Runnable r) {
        ObservableList<ISensor> threadSensors = Server.getInstance().getSensors();


        for (ISensor threadSensor : threadSensors) {
            if ((threadSensor.getSensorState() == SensorState.ON) && (threadSensor instanceof Runnable)) {
                threadSensor.setTask(r);
                return new Thread((Runnable) threadSensor, threadSensor.getName());
            }
        }


        Observable observable = threadSensors.get(0).getPublishSubject();

        for (int i = 1; i < threadSensors.size(); i++) {
           observable = observable.mergeWith(threadSensors.get(i).getPublishSubject());
       }

        ThreadSensor threadSensor = (ThreadSensor) observable.blockingFirst();

        return new Thread(threadSensor, threadSensor.getName());

    }
}



/**
 * own scheduler to createWorker on Thread from SensorThreadFactory
 */
public class SensorScheduler extends Scheduler {
    @Override
    public Worker createWorker() {
        return new NewThreadWorker(new SensorThreadFactory());
    }
}
