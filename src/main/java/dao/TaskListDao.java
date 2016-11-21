package dao;

import model.TaskList;

import java.util.List;

/**
 * Created by laroself on 20.11.16.
 */
public interface TaskListDao {

    public void add(String name);
    public void delete(Integer listId);
    public List<TaskList> getAll();
    public TaskList getParticularTaskList(Integer listId);

}
