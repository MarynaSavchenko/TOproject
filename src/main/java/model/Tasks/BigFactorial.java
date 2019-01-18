package model.Tasks;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.math.BigInteger;



public class BigFactorial implements ITask<BigInteger> {

    private ObjectProperty<TaskType> type;

    private Thread threadSensor;
    private BigInteger result;
    private int input;

    public BigFactorial(int input) {
        this.input = input;
        type = new SimpleObjectProperty<>(TaskType.BIGFACTORIAL);
    }

    private static BigInteger factorial(int number)  {

        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }


    /**
     * TO DO: WHAT IF WE HAVE NOT THREADSENSORS???
     * set Sensor on which it is working
     *
     * @return computed result
     */
    @Override
    public BigInteger execute()  {
        threadSensor = Thread.currentThread();
        System.out.println("doing on " + threadSensor.getName());
        return factorial(input);
    }

    @Override
    public TaskType getType() {
        return type.get();
    }

    @Override
    public  void setResult(BigInteger result) {
        this.result = result;
    }

    @Override
    public BigInteger getResult() {
        return result;
    }

    @Override
    public void setType(TaskType details) {
        this.type.set(details);
    }

    @Override
    public ObjectProperty<TaskType> getTypeProperty() {
        return type;
    }

}
