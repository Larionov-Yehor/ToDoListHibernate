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
@Repository
public class TaskListDaoImpl implements TaskListDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaskList> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TaskList.class);
        return  (List<TaskList>) criteria.list();
    }

    @Override
    public void add(TaskList taskList){
        sessionFactory.getCurrentSession().save(taskList);
    }

    @Override
    public void delete(TaskList taskList) {
        sessionFactory.getCurrentSession().delete(taskList);
    }




}
