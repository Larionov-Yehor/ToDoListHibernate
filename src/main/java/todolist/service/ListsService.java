package todolist.service;

import todolist.model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
public interface ListsService {
    public List<TaskList> getAll();
}
