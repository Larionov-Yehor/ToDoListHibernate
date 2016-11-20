package controller;

import dao.TaskDaoImpl;
import dao.TaskListDaoImpl;
import model.Task;
import model.TaskList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/tasklist_page"})

public class Tasklist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer taskListId = Integer.valueOf(req.getParameter("taskListId"));

        TaskListDaoImpl taskListDao = new TaskListDaoImpl();
        TaskDaoImpl taskDao =  new TaskDaoImpl();

        TaskList tasklist = taskListDao.getParticularTaskList(taskListId);
        tasklist.setCoupledTasks(taskDao.getTasksForParticularList(taskListId));

        List<Task> tasks = tasklist.getCoupledTasks();
        List<Task> toDoTasks =  new ArrayList<Task>();
        List<Task> completedTasks =  new ArrayList<Task>();

        for(int i=0; i<tasks.size();i++){

            Task task = tasks.get(i);
            if(task.getState()==false){
                toDoTasks.add(task);
            }
            else {
                completedTasks.add(task) ;
            }
        }

        req.setAttribute("tasklist", tasklist);
        req.setAttribute("toDoTasks", toDoTasks);
        req.setAttribute("completedTasks", completedTasks);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/tasklist_page.jsp");
        dispatcher.forward(req, resp);
    }
}