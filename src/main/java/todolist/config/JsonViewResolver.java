package todolist.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import todolist.model.TaskList;

import java.util.Locale;

/**
 * Created by employee on 12/5/16.
 */
public class JsonViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);

        return view;}


}


