package SpringMVC.mvcController.config;

import jakarta.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author YXS
 * @PackageName: SpringMVC.mvcController.config
 * @ClassName: MainInitializer
 * @Desription:
 * @date 2023/3/9 16:03
 */
/*public class MainInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);
        servletContext
                .addServlet("mvc", servlet)
                .addMapping("/");

    }

}*/
