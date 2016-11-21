package dao;

import model.Task;
import model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public interface TaskDao {

    public void add(Task task);
    public void delete(Integer taskId);
    public void changeState(Integer taskId);
    public void deleteCoupledTasks(Integer listId);
    public List<Task> getTasksForParticularList(Integer listId);

}
