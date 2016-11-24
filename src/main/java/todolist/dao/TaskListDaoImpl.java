package todolist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import todolist.model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
@Repository("taskList")
public class TaskListDaoImpl implements TaskListDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaskList> getAll() {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TaskList.class);
        System.out.println("dao");
        return  (List<TaskList>) criteria.list();
    }


}
