import model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Task.class);

        List<Task> taskList = (List<Task>)criteria.list();
        for(int i=0; i<taskList.size(); i++){
            System.out.println(taskList.get(i).getName()+" "+taskList.get(i).getDueDate());
        }
        session.getTransaction().commit();

  /* LocalDate date = new Date();
        date.setYear(116);
        date.setMonth(10);
        date.setDate(10);*//*

      //  System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
      //  System.out.println(date);

        TaskDaoImpl taskDao = new TaskDaoImpl();
         model.Task task = new model.Task("go", date, 1);
      //  taskDao.add(task);
*/


    }
}
