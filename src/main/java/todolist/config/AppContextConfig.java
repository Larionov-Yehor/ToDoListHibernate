package todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by employee on 11/23/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("todolist.*")
public class AppContextConfig {

    @Bean
    public InternalResourceViewResolver setupViewResolver(){
        System.out.println("setupViewResolver");

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

    return resolver;}
}
