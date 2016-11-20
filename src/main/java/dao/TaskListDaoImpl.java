package dao;

import model.Task;
import model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public class TaskListDaoImpl implements TaskListDao{

    public void add(String name){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        TaskList taskList = new TaskList();
        taskList.setName(name);

        session.save(taskList);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }

    public void delete(Integer listId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        TaskList taskList = new TaskList();
        taskList.setId(listId);

        session.delete(taskList);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        session.close();
    }

    public List<TaskList> getAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TaskList.class);
        List<TaskList> taskLists = (List<TaskList>) criteria.list();
        session.close();

        return taskLists;
    }

    public TaskList getParticularTaskList(Integer listId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TaskList.class)
                .add(Restrictions.eq("id",listId));
        TaskList taskList = (TaskList) criteria.list().get(0);

    return taskList;}
}
