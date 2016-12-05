package todolist.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import todolist.model.TaskList;
import todolist.service.ListsService;

/**
 * Created by employee on 11/29/16.
 */
@Controller
@RequestMapping("/taskList")
public class ListController {

    @Autowired
    ListsService listsService;

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    TaskList getTaskListInJSON(@PathVariable String id) {


    return listsService.getParticularTaskList(id);

    }

}