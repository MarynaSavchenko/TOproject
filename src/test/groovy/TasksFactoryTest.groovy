import model.Tasks.BigFactorial
import model.Tasks.ITask
import model.Tasks.TaskType
import model.Tasks.TasksFactory
import spock.lang.Specification

class TasksFactoryTest extends Specification {
    def "createTask(TaskType.BIGFACTORIAL) should return a task which is instance of BigFactorial"(){
        given:
        TasksFactory tf = new TasksFactory()

        when:
        ITask task = tf.createTask(TaskType.BIGFACTORIAL)

        then:
        task instanceof BigFactorial
    }


}