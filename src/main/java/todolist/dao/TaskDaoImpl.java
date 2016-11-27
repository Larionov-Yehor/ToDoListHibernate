package todolist.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import todolist.model.Task;

import java.util.List;

/**
 * Created by employee on 11/25/16.
 */

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Task task) {
        sessionFactory.getCurrentSession().save(task);
    }

    public List<Task> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        return  (List<Task>) criteria.list();
    }

    @Override
    public void delete(Task task) {
        sessionFactory.getCurrentSession().delete(task);
    }

    @Override
    public void update(Task task) {
        sessionFactory.getCurrentSession().update(task);
    }

   /* @Override
    public void update(Task task) {

    }*/


}
