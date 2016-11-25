package todolist.dao;

import todolist.model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
public interface TaskListDao {
    List<TaskList> getAll();
    public void add(TaskList taskList);
    public void delete(TaskList taskList);
}
