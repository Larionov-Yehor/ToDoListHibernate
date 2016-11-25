package todolist.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import todolist.dao.TaskListDaoImpl;

import todolist.model.Task;
import todolist.model.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
@Service
@Transactional
public class ListsServiceImpl implements ListsService {

    @Autowired(required = true)
    TaskListDaoImpl taskListDao;

    @Override
    public List<TaskList> getAll() {
        return taskListDao.getAll();
    }

    @Override
    public void add(TaskList taskList){
        taskListDao.add(taskList);
    }

    @Override
    public void delete(String listId) {
      Integer neededListId = Integer.valueOf(listId);

        TaskList taskList =  getAll()
                            .stream()
                            .filter(p -> p.getId().equals(neededListId))
                            .findFirst()
                            .get();

        taskListDao.delete(taskList);
    }


}
