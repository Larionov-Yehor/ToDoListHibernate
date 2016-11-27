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
    public String addPage(ModelMap modelMap,
                          @RequestParam("listId") String listId){

       TaskList taskList = listsService.getParticularTaskList(listId);
       modelMap.addAttribute("taskList", taskList);

       return "new_task";
    }


    @RequestMapping(value = "/add_new_task")
    public String add(@RequestParam("task_name") String taskName,
                      @RequestParam("task_description") String taskDescription,
                      @RequestParam("task_date") String date,
                      @RequestParam("listId") String taskListId){

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

    @RequestMapping(value = "/taskMarker")
    public String changeTaskStatus(@RequestParam("taskId")String taskId){
    tasksService.changeState(taskId);
    return "redirect:/home";
    }

    @RequestMapping(value = "/edit_task")
    public String editTask(@RequestParam("taskId")String taskId, ModelMap modelMap){

        Task task = tasksService.getParticularTask(taskId);
        List<TaskList> taskLists = listsService.getAll();

        modelMap.addAttribute("taskLists", taskLists);
        modelMap.addAttribute("task", task);

    return "edit_task";
    }

    @RequestMapping(value = "/save_edited_task")
    public String save(
                      @RequestParam("task_id") String taskId,
                      @RequestParam("task_name") String taskName,
                      @RequestParam("task_description") String taskDescription,
                      @RequestParam("task_date") String date,
                      @RequestParam("task_list") String taskListId
    ){

       Task task = tasksService.getParticularTask(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setDueDate(Task.parseDate(date));
        task.setState(false);
        task.setListId(Integer.valueOf(taskListId));

        tasksService.update(task);

        return "redirect:/home";
    }



}
