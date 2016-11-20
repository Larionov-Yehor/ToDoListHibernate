package dao;

import model.Task;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public interface TaskDao {

    public void add(Task task);
    public void delete(Integer taskId);
    public void changeState(Integer taskId);
    public List<Task> getAll();


}
