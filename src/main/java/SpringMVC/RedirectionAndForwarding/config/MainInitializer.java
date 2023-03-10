package SpringMVC.RedirectionAndForwarding.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author YXS
 * @PackageName: SpringMVC.RedirectionAndForwarding.config
 * @ClassName: MainIntitation
 * @Desription:
 * @date 2023/3/10 11:20
 */
/*public class MainInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);
        servletContext
                .addServlet(".html", servlet)
                .addMapping("/");

    }

}*/
