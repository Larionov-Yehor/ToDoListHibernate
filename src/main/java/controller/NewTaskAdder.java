package controller;

import dao.TaskDaoImpl;
import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/newTaskAdder"})
public class NewTaskAdder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("task_name");
        String description = req.getParameter("task_description");
        String dateStr = req.getParameter("task_date");
        String taskListId = req.getParameter("task_list");

        Date date = new Date();

        String [] parts = dateStr.split("-");
        int year = Integer.valueOf(parts[0]);
        int month = Integer.valueOf(parts[1]);
        int day = Integer.valueOf(parts[2]);

        date.setYear(year-1900);
        date.setMonth(month);
        date.setDate(day);

        Task task = new Task();
        task.setName(title);
        task.setState(false);
        task.setDueDate(date);
        task.setDescription(description);
        task.setListId(Integer.valueOf(taskListId));

        TaskDaoImpl taskDao =  new TaskDaoImpl();

            taskDao.add(task);

        resp.sendRedirect("/home");

    }
}