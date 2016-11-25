package todolist.service;

import todolist.model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
public interface ListsService {
    public List<TaskList> getAll();
    public void add(TaskList taskList);
    public void delete(String listId);
    public TaskList getParticularTaskList(String listId);
}
