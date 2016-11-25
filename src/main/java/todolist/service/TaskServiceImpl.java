package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.dao.TaskDaoImpl;
import todolist.model.Task;
import todolist.model.TaskList;

import java.util.List;

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

        Integer neededTaskId = Integer.valueOf(taskId);

        Task task =  getAll()
                .stream()
                .filter(neededTaskList -> neededTaskList.getId().equals(neededTaskId))
                .findFirst()
                .get();

        taskDao.delete(task);

    }
}
