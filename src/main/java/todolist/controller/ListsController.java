package todolist.controller;

/**
 * Created by employee on 11/23/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import todolist.model.TaskList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todolist.service.ListsService;

import java.util.List;

@Controller
public class ListsController {
 @Autowired
 ListsService listsService;


       @RequestMapping (value ="/")
       public String index(ModelMap modelMap){
       return "redirect:/home";
       }


       @RequestMapping (value ="/home", method = RequestMethod.GET)
       public ModelMap getAll(){
       List<TaskList> taskLists = listsService.getAll();
       ModelMap modelMap = new ModelMap();
       modelMap.addAttribute("taskLists", taskLists);
       return modelMap;
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


