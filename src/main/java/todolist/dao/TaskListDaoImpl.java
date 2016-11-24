package todolist.dao;

import todolist.model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
@Repository("TaskList")
public class TaskListDaoImpl implements todolist.dao.TaskListDao {

    SessionFactory sessionFactory;

    @Override
    public List<TaskList> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TaskList.class);
        return  criteria.list();
    }


}
