package model.Sensors;


import model.Server.Server;


/**
 *class-thread, which is responsible for adding maxAmount of Sensors of sensorType
 * from time to time to Server's list
 */
public class SensorCreator extends Thread {

    private Class sensorClass;
    private int maxAmount = 2;

    /**
     * @param sensorClass
     * SensorCreator will create sensors of sensorClass
     */
    public SensorCreator(Class sensorClass){

        if(ISensor.class.isAssignableFrom(sensorClass)){
            this.sensorClass = sensorClass;
        }
        else{
            throw new RuntimeException("Wrong class for sensor\n");
        }

    }

    /**
     * adding maxAmount of threads from time to time
     */
    @Override
    public void run() {
        for (int i = 0; i < maxAmount; i++){
            try {
                sleep((int) (Math.random() * 100) + 1000);
                addNewSensor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * adding Sensor (created in method createSensor) to Server's list of Sensors
     */
    private void addNewSensor() {

        Server.getInstance().getSensors().add(createSensor());
    }

    private ISensor createSensor(){
        try {
            return (ISensor)sensorClass.newInstance();
        }catch(InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }
}
