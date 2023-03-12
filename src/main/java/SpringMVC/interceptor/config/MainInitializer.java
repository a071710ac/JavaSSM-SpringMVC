package SpringMVC.interceptor.config;

import jakarta.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author YXS
 * @PackageName: SpringMVC.interceptor.config
 * @ClassName: MainIn
 * @Desription:
 * @date 2023/3/12 16:10
 */
public class MainInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);
        servletContext
                .addServlet("mvc", servlet)
                .addMapping("/");

    }

}
