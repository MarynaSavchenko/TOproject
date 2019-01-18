import io.reactivex.Observable;
import model.Sensors.*;
import model.Tasks.BigFactorial;
import model.Tasks.TaskType;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        SensorCreator sensorCreator = new SensorCreator(ThreadSensor.class);
        sensorCreator.start();


        sleep(3000);

        BigFactorial bigFactorial = new BigFactorial(10000);

        Observable.create(emitter -> {
            try{
                emitter.onNext(bigFactorial.execute());
                emitter.onComplete();
            }
            catch (Exception e){
                e.printStackTrace();
                emitter.tryOnError(e);
            }})
                .subscribeOn(new SensorScheduler())
                .subscribe(result -> System.out.println("Result is " + result));

        BigFactorial bigFactorial3 = new BigFactorial(1000);
        Observable.create(emitter -> {
            try{
                emitter.onNext(bigFactorial3.execute());
                emitter.onComplete();
            }
            catch (Exception e){
                e.printStackTrace();
                emitter.tryOnError(e);
            }})
                .subscribeOn(new SensorScheduler())
                .subscribe(result -> System.out.println("Result is " + result));





        Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(new SensorScheduler())
                .map(String::length)
                .subscribe(length -> System.out.println("item length " + length + "received on " + Thread.currentThread().getName()));

        Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(new SensorScheduler())
                .map(String::length)
                .subscribe(length -> System.out.println("item length " + length + "received on " + Thread.currentThread().getName()));

        BigFactorial bigFactorial2 = new BigFactorial(20);
        Observable.create(emitter -> {
            try{
                emitter.onNext(bigFactorial2.execute());
                emitter.onComplete();
            }
            catch (Exception e){
                e.printStackTrace();
                emitter.tryOnError(e);
            }})
                .subscribeOn(new SensorScheduler())
                .subscribe(result -> System.out.println("Result is " + result));




        Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(new SensorScheduler())
                .map(String::length)
                .subscribe(length -> System.out.println("item length " + length + "received on " + Thread.currentThread().getName()));


        sleep(1000);

    }
}
