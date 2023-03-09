package SpringMVC.annotationConfiguration;

/**
 * 全注解配置形式
 * 如果你希望完完全全丢弃配置文件 使用纯注解开发 可以直接添加一个类 Tomcat会在类路径中查找实现ServetContainerInitializer接口的类
 * 如果发现的话 就用它来配置Servlet容器 Spring提供了这个接口的实现类SpringServletContainerInitializer 通过@HandlesTypes(WebApplicationInitializer.class)设置
 * 这个类反过来会查找实现WebApplicationInitializer的类 并将配置的任务交给它们来完成 因此直接实现接口即可:
 *
 *                  public class MainInitializer implements WebApplicationInitializer {
 *
 *                      @Override
 *                      public void onStartup(ServletContext servletContext) throws ServletException {
 *
 *                          // 创建注解配置WebApplicationContext
 *                          AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
 *                          context.register(WebConfiguration.class);
 *
 *                          // 创建并注册DispatcherServlet
 *                          DispatcherServlet servlet = new DispatcherServlet(context);
 *                          servletContext
 *                                  .addServlet("mvc", servlet) // Servlet名称依然加mvc
 *                                  .addMapping("/"); // 路径依然是"/" 跟之前XML配置一致
 *
 *                      }
 *
 *                  }
 *
 * 接着我们需要配置类中添加一些必要的注解:
 *
 *                  @Configuration
 *                  @EnableWebMvc // 快速配置SpringMVC注解
 *                  @ComponentScan("SpringMVC.annotationConfiguration.controller")
 *                  public class WebConfiguration {
 *
 *
 *
 *                  }
 *
 * 这样我们同样可以正常访问:
 *
 *      https://smms.app/image/D1sAFePzj7d49VL
 *
 * 之后为了方便 我们就统一使用全注解形式编写
 */
public class Main {

    public static void main(String[] args) {



    }

}
