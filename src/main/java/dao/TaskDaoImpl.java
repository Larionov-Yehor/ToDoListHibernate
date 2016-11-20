package dao;

import model.Task;
import model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public class TaskDaoImpl implements TaskDao{

    public void add(Task task) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
       // session.close();
        HibernateUtil.shutdown();
    }

    public void delete(Integer taskId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Task task = new Task();
        task.setId(taskId);

        session.delete(task);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        session.close();
    }

    public void deleteCoupledTasks(Integer listId){

       // Session session = HibernateUtil.getSessionFactory().openSession();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        List<Task> tasksToDelete = taskDao.getTasksForParticularList(listId);
        for(int i = 0; i<tasksToDelete.size(); i++){

            Integer taskId = tasksToDelete.get(i).getId();
            taskDao.delete(taskId);
        }

      // HibernateUtil.shutdown();

    }

    public void changeState(Integer taskId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Task.class)
                .add(eq("id",taskId));
       // Task task = (Task)criteria.uniqueResult();

        List<Task> tasks = (List<Task>) criteria.list();
        Task task = tasks.get(0);
        task.setState(!task.getState());

        session.update(task);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        session.close();

    }

    public List<Task> getAll() {


        return null;
    }

    public List<Task> getTasksForParticularList(Integer listId){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Task.class)
                .add(eq("listId",listId));

        List<Task> tasks = (List<Task>) criteria.list();

        HibernateUtil.shutdown();
        session.close();

    return tasks;}

}
