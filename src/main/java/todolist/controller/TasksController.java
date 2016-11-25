package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import todolist.model.Task;
import todolist.model.TaskList;
import todolist.service.ListsService;
import todolist.service.ListsServiceImpl;
import todolist.service.TaskServiceImpl;
import todolist.service.TasksService;

import java.util.Date;
import java.util.List;

/**
 * Created by employee on 11/25/16.
 */
@Controller
public class TasksController{

    @Autowired
    private TasksService tasksService;
    @Autowired
    private ListsService listsService;

    @RequestMapping(value = "/new_task")
    public String addPage(ModelMap modelMap){
        List<TaskList> taskLists = listsService.getAll();
        modelMap.addAttribute("taskLists", taskLists);
        return "new_task";
    }


    @RequestMapping(value = "/add_new_task")
    public String add(@RequestParam("task_name") String taskName,
                      @RequestParam("task_description") String taskDescription,
                      @RequestParam("task_date") String date,
                      @RequestParam("task_list") String taskListId){

        Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setDueDate(Task.parseDate(date));
        task.setState(false);
        task.setListId(Integer.valueOf(taskListId));

        tasksService.add(task);

        return "redirect:/home";

    }

    @RequestMapping(value = "/taskDelete")
    public String delete(@RequestParam("taskId") String taskId){

    tasksService.delete(taskId);
    return "redirect:/home";
    }


}
