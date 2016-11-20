package dao;

import model.TaskList;

import java.util.List;

/**
 * Created by laroself on 20.11.16.
 */
public interface TaskListDao {

    public List<TaskList> getAll();
}
