import model.Sensors.ISensor
import model.Sensors.SensorCreator
import model.Sensors.ThreadSensor
import model.Server.Server
import spock.lang.Specification
import spock.lang.Unroll

class SensorCreatorTest extends Specification {

    @Unroll
    def "adding new sensor (of different types) should increase size of list of 1"(){
        given:
        SensorCreator sc = new SensorCreator(sensorClass)
        int sensorsSize = Server.getInstance().getSensors().size()

        when:
        sc.addNewSensor()

        then:
        Server.getInstance().getSensors().size() == sensorsSize + 1

        where:
        sensorClass | _
        ThreadSensor.class | _
        SensorType_2.class | _
        SensorType_3.class | _
    }
}
