package controller;

import dao.TaskDaoImpl;
import dao.TaskListDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by employee on 11/18/16.
 */
@WebServlet({"/listRemover"})

public class TaskListRemover extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TaskListDaoImpl taskListDao = new TaskListDaoImpl();
        TaskDaoImpl taskDao = new TaskDaoImpl();

        Integer taskListId = Integer.valueOf(req.getParameter("taskListId"));

        taskDao.deleteCoupledTasks(taskListId);

        taskListDao.delete(taskListId);

        resp.sendRedirect("/home");
    }

}