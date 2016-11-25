package todolist.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import todolist.dao.TaskDaoImpl;
import todolist.dao.TaskListDaoImpl;

import todolist.model.Task;
import todolist.model.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 11/24/16.
 */
@Service
@Transactional
public class ListsServiceImpl implements ListsService {

    @Autowired(required = true)
    TaskListDaoImpl taskListDao;
    @Autowired(required = true)
    TaskDaoImpl taskDao;

    @Override
    public List<TaskList> getAll() {
        return taskListDao.getAll();
    }

    @Override
    public void add(TaskList taskList){
        taskListDao.add(taskList);
    }

    public TaskList getParticularTaskList(String listIdParam){

        Integer listId = Integer.valueOf(listIdParam);


        TaskList taskList = getAll()
                            .stream()
                            .filter(neededList -> neededList.getId().equals(listId))
                            .findFirst()
                            .get();

        taskList.setCoupledTasks(
        taskDao.getAll()
                .stream()
                .filter(neededTask -> neededTask.getListId().equals(listId))
                .collect(Collectors.toList()));

        return taskList;
        }

    @Override
    public void delete(String listId) {

        Integer neededListId = Integer.valueOf(listId);

        TaskList taskList =  getAll()
                            .stream()
                            .filter(neededTaskList -> neededTaskList.getId().equals(neededListId))
                            .findFirst()
                            .get();

        taskListDao.delete(taskList);
    }


}
