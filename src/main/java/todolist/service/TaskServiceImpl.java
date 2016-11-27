package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.dao.TaskDaoImpl;
import todolist.model.Task;
import todolist.model.TaskList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 11/25/16.
 */
@Service
@Transactional
public class TaskServiceImpl implements TasksService{

    @Autowired(required = true)
    private TaskDaoImpl taskDao;


    @Override
    public void add(Task task) {
        taskDao.add(task);
    }


    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public void delete(String taskId) {

        Task task =  getParticularTask(taskId);

        taskDao.delete(task);
    }

    @Override
    public void changeState(String taskId) {

        Integer neededTaskId = Integer.valueOf(taskId);
        Task task =  getParticularTask(taskId);
        task.setState(!task.getState());
        taskDao.update(task);
    }

    @Override
    public List<Task> getDone(String listId) {
        List<Task> undone = getTasksByState(listId, true);
        return undone;
    }

    @Override
    public List<Task> getUndone(String listId) {
        List<Task> undone = getTasksByState(listId, false);
        return undone;
    }

    public List<Task> getTasksByState(String listId, boolean state){
        List<Task> taskList =getAll()
                            .stream()
                            .filter(task -> task.getListId().equals(Integer.valueOf(listId))
                                    &&
                                    task.getState().equals(state))
                            .collect(Collectors.toList());

        return taskList;
    }


    public Task getParticularTask(String taskId){
        Integer neededTaskId = Integer.valueOf(taskId);

        Task task =  getAll()
                    .stream()
                    .filter(neededTaskList -> neededTaskList.getId().equals(neededTaskId))
                    .findFirst()
                    .get();

        return task;
    }

    @Override
    public void update(Task task) {

        taskDao.update(task);
    }
}
