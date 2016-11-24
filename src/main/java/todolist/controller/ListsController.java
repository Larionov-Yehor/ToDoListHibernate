package todolist.controller;

/**
 * Created by employee on 11/23/16.
 */

import todolist.model.TaskList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todolist.service.ListsService;

import java.util.List;

@Controller
public class ListsController {
    ListsService listsService;

    @RequestMapping (value ="/", method = RequestMethod.GET)

    public void index(ModelMap modelMap){
        List<TaskList> taskLists = listsService.getAll();
        modelMap.put("taskLists", taskLists);
    }

    @RequestMapping (value = "/tasklist_page")
    public String add(){
        return "new_tasklist";
    }


}


