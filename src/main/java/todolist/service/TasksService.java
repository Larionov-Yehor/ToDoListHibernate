package todolist.service;

import todolist.model.Task;
import todolist.model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/25/16.
 */
public interface TasksService {

    public List<Task> getAll();
    public void add(Task task);
    public void delete(String taskId);
    public void changeState(String taskId);
    public List<Task> getDone(String listId);
    public List<Task> getUndone(String listId);
    public Task getParticularTask(String taskId);
    public void update(Task task);

}
