package dao;

import model.Task;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public interface TaskDao {

    public void add(Task task);
    public void delete(Task task);
    public void changeState(Task task);
    public List<Task> getAll(int id);


}
