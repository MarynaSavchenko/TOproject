package model.Tasks;


/**
 * creating different types of tasks
 */
public class TasksFactory {

    public ITask createTask(TaskType taskType, int input){

        if (taskType == TaskType.BIGFACTORIAL) {
            BigFactorial newBigFactorial = new BigFactorial(input);
            return newBigFactorial;
        }
        else if (taskType == TaskType.TASK_TYPE_2) return null; //return new TASK_TYPE_2
        else if (taskType == TaskType.TASK_TYPE_3) return null; //return new TASK_TYPE_3
        return null;
    }
}
