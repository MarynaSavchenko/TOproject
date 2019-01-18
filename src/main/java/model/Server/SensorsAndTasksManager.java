package model.Server;

import io.reactivex.Observable;
import model.Sensors.SensorScheduler;
import model.Tasks.BigFactorial;
import model.Tasks.ITask;

public class SensorsAndTasksManager {

    private final SensorScheduler sensorScheduler = new SensorScheduler();

    /**
     * UWAGA_1:
     * Dlaczego zakomentowana wersja nie dziła? błąd pod czas
     * this.threadSensor = Thread.currentThread() w zadaniu Bigfactorial
     *
     * UWAGA_2:
     * używać Completable? Ale potrzebujemy result, żeby przypisać do zadania
     *
     *
     *
     * @param task - task to execute
     *             execute task on Thread from SensorScheduler,
     *             set result to this task
     *
     */
    public void assignSensor(ITask task) {

        Observable.create(emitter -> {
            try{
                emitter.onNext(task.execute());
                emitter.onComplete();
            }
            catch (Exception e){
                e.printStackTrace();
                emitter.tryOnError(e);
            }})
                .subscribeOn(new SensorScheduler())
                .subscribe(result -> task.setResult(result));
    }
}
