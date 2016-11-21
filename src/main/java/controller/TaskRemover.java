package controller;

import dao.TaskDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by employee on 11/15/16.
 */

@WebServlet({"/taskRemover"})

public class TaskRemover extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TaskDaoImpl taskDao = new TaskDaoImpl();
        Integer taskId = Integer.valueOf(req.getParameter("taskId"));

        taskDao.delete(taskId);

        resp.sendRedirect("/home");

    }

}