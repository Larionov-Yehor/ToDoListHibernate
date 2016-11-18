package dao;

import model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

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
        session.close();
    }

    public void delete(Task task) {

    }

    public void changeState(Task task) {

    }

    public List<Task> getAll(int id) {


        return null;
    }


}
