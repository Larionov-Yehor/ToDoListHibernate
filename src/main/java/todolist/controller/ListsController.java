package todolist.controller;

/**
 * Created by employee on 11/23/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import todolist.model.Task;
import todolist.model.TaskList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todolist.service.ListsService;
import todolist.service.ListsServiceImpl;
import todolist.service.TasksService;

import java.util.List;

@Controller
public class ListsController {

 @Autowired
 private ListsService listsService;


       @RequestMapping (value ="/")
       public String index(){

       return "redirect:/home";
       }


       @RequestMapping (value ="/home", method = RequestMethod.GET)
       public ModelMap getAll(){
            List<TaskList> taskLists = listsService.getAll();
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("taskLists", taskLists);

       return modelMap;
       }



       @RequestMapping (value = "/tasklist_page")
       public String tasklistPage(@RequestParam("taskListId") String listId,
                                  ModelMap modelMap){

       TaskList taskList = listsService.getParticularTaskList(listId);
       List<Task> taskListForPage = taskList.getCoupledTasks();

       modelMap.addAttribute("taskList",taskList);
       modelMap.addAttribute("taskListForPage", taskListForPage);

       return "tasklist_page";
       }


      @RequestMapping (value = "/new_tasklist")
      public String addPage(){
            return "new_tasklist";
      }


      @RequestMapping (value = "/add_new_tasklist", method = RequestMethod.POST)
      public String add(@RequestParam("tasklist_name") String taskListName){

             TaskList taskList = new TaskList();
             taskList.setName(taskListName);

             listsService.add(taskList);

       return "redirect:/home";
       }


       @RequestMapping (value = "/deleteList", method = RequestMethod.POST)
       public String delete(@RequestParam("listId") String listId){

            listsService.delete(listId);

       return "redirect:/home";
       }











}


