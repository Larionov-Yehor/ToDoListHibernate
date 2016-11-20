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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yurik on 14.11.16.
 */
@WebServlet({"/newTask"})
public class NewTask extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{


        TaskListDaoImpl taskListDao = new TaskListDaoImpl();

        List<TaskList> taskLists = taskListDao.getAll();

         req.setAttribute("taskLists", taskLists);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/new_task.jsp");

        dispatcher.forward(req, resp);
    }
}