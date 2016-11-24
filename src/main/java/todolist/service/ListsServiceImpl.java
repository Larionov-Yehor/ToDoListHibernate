package todolist.service;

import org.springframework.transaction.annotation.Transactional;
import todolist.dao.TaskListDaoImpl;

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
        System.out.println("service");
        return taskListDao.getAll();
    }


}
