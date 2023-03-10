package SpringMVC.reqParamAndreqHeaderDetails.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author YXS
 * @PackageName: SpringMVC.reqParamAndreqHeaderDetails.config
 * @ClassName: MainInitializer
 * @Desription:
 * @date 2023/3/9 23:43
 */
/*public class MainInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);
        servletContext
                .addServlet("mvc", servlet)
                .addMapping("/");

    }

}*/
