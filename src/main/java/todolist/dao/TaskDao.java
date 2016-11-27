package todolist.dao;

import todolist.model.Task;

import java.util.List;

/**
 * Created by employee on 11/25/16.
 */
public interface TaskDao {

    public void add(Task task);
    public List<Task> getAll();
    public void delete(Task task);
    public void update(Task task);


}
