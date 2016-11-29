package todolist.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import todolist.model.TaskList;
import todolist.service.ListsService;

/**
 * Created by employee on 11/29/16.
 */
@Controller
@RequestMapping("/taskLists")
public class ListController {

    @Autowired
    ListsService listsService;

    @RequestMapping(method = RequestMethod.GET)
    String allTaskLists(ModelMap modelMap){
    modelMap.addAttribute("taskLists", listsService.getAll());
    return "home";
    }

 /*   @RequestMapping(method = RequestMethod.POST)
    String newTaskList(@RequestParam("title")String name){
    TaskList taskList = new TaskList();
    taskList.setName(name);
    listsService.add(taskList);
    return "home";
    }*/



}