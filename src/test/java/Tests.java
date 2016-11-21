/**
 * Created by employee on 11/21/16.
 */

import dao.TaskDaoImpl;
import dao.TaskListDaoImpl;
import model.Task;
import model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hibernate.criterion.Restrictions.eq;

public class Tests {


 private Integer wantedListId =1;
 private TaskListDaoImpl taskListDao = new TaskListDaoImpl();
 private TaskDaoImpl taskDao =  new TaskDaoImpl();

    @Test
    public void assertCorrectParticularListGet(){

        TaskList taskList = taskListDao.getParticularTaskList(1);
        assertThat(taskList.getId(), equalTo(wantedListId));
    }

    @Test
    public void assertCorrectGetOfCoupledTasksForParticularList(){

        List<Task> tasks = taskDao.getTasksForParticularList(wantedListId);

        for(int i=0; i<tasks.size(); i++){
            Task task = tasks.get(i);
            assertThat(task.getId(),equalTo(wantedListId));
        }

    }

   @Test
    public void assertCorrectTaskListAdding(){

        TaskListDaoImpl taskListDao = new TaskListDaoImpl();
        String wantedNewTaskListName = "Car wash";
        taskListDao.add(wantedNewTaskListName);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TaskList.class)
                .add(eq("name",wantedNewTaskListName));

        TaskList taskList = (TaskList) criteria.list().get(0);

        HibernateUtil.shutdown();
        session.close();
        assertThat(taskList.getName(), equalTo(wantedNewTaskListName));
    }


    @Test
    public void assertCorrectTaskAdding(){

        Task task = new Task();

        String taskName = "testTask123";
        task.setName(taskName);
        task.setState(Boolean.FALSE);
        task.setDueDate(Task.parseDate("2016-11-22"));
        task.setListId(wantedListId);

        taskDao.add(task);

        Task theSameTaskFromDB = taskDao.getParticularTask(taskName);
        taskDao.delete(theSameTaskFromDB.getId());

        System.out.println(task.getDueDate());
        System.out.println(theSameTaskFromDB.getDueDate());

        assertThat(task.getName(), equalTo(theSameTaskFromDB.getName()));
        assertThat(task.getListId(), equalTo(theSameTaskFromDB.getListId()));
        assertThat(task.getState(), equalTo(theSameTaskFromDB.getState()));
        assertThat(task.getDueDate().toString(), equalTo(theSameTaskFromDB.getDueDate().toString()));

    }

}
