package SpringMVC.mvcController;

/**
 * 配置视图解析器和控制器
 * 首先我们需要实现最基本的页面解析并返回 第一步就是配置视图解析器 这里我们使用Thymeleaf为我们提供的视图解析器 导入需要的依赖:
 *
 *                  <dependency>
 *                      <groupId>org.thymeleaf</groupId>
 *                      <artifactId>thymeleaf-spring6</artifactId>
 *                      <version>3.1.1.RELEASE</version>
 *                  </dependency>
 *
 * 配置视图解析器非常简单 我们只需要将对应的ViewResolver注册为Bean即可 这里这里我们直接在配置类中编写:
 *
 *                  @Configuration
 *                  @EnableWebMvc
 *                  @ComponentScan("SpringMVC.mvcController.controller")
 *                  public class WebConfiguration {
 *
 *                      // 我们需要使用ThymeleafViewResolver作为视图解析器 并解析我们的HTML页面
 *                      @Bean
 *                      public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
 *
 *                          ThymeleafViewResolver resolver = new ThymeleafViewResolver();
 *                          resolver.setOrder(1); // 可以存在多个视图解析器 并且可以为它们设定解析顺序
 *                          resolver.setCharacterEncoding("UTF-8"); // 编码格式是重中之重
 *                          resolver.setTemplateEngine(springTemplateEngine); // 和之前JavaWeb阶段一样 需要使用模板引擎进行解析 所以这里也需要设定一下模板引擎
 *                          return resolver;
 *
 *                      }
 *                      // 配置模板引擎Bean
 *                      @Bean
 *                      public SpringTemplateEngine springTemplateEngine(ITemplateResolver resolver) {
 *
 *                          SpringTemplateEngine engine = new SpringTemplateEngine();
 *                          engine.setTemplateResolver(resolver); // 模板解析器 默认即可
 *                          return engine;
 *
 *                      }
 *                      // 配置模板解析器
 *                      @Bean
 *                      public SpringResourceTemplateResolver templateResolver() {
 *
 *                          SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
 *                          resolver.setSuffix(".html"); // 需要解析的后缀名称
 *                          resolver.setPrefix("/"); // 需要解析的HTML页面文件存放的位置 默认是webapp目录下 如果是类路径下需要添加classpath:前缀
 *                          return resolver;
 *
 *                      }
 *
 *                  }
 *
 * 现在我们就完成了视图解析器的配置 我们接着来创建一个Controller 创建Controller也非常简单 只需在一个类上添加一个@Controller注解即可
 * 它会被Spring扫描并自动注册为Controller类型的Bean 然后我们只需要在类中编写方法用于处理对应地址的请求即可:
 *
 *                  @Controller // 直接添加注解即可
 *                  public class HelloController {
 *
 *                      @RequestMapping("/index") // 直接填写访问路径
 *                      public ModelAndView index() {
 *                          return new ModelAndView("index"); // 返回ModelAndView对象 这里填入了视图的名称
 *                          // 返回会经过视图解析器进行处理
 *                      }
 *
 *                  }
 *
 * 接着我们在类路径根目录下创建一个简单html文件:
 *
 *                  <!DOCTYPE html>
 *                  <html lang="en">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>测试</title>
 *                  </head>
 *                  <body>
 *                      <p>欢迎来到GayHub全球最大同性交友网站</p>
 *                  </body>
 *                  </html>
 *
 * 我们会发现 打开浏览器之前后就可以直接访问我们的HTML页面了:
 *
 *      https://smms.app/image/ru4pBgI75JZxG6F
 *
 * 我们在之前 使用Thymeleaf模板解析后端的一些数据时 需要通过Context进行传递 而使用SpringMVC之后 数据我们可以直接向Model模型层进行提供:
 *
 *                  @RequestMapping()
 *                  public ModelAndView index() {
 *
 *                      ModelAndView modelAndView = new ModelAndView();
 *                      modelAndView.getModel.put("name", "啊这"); // 将name传递给Model
 *                      return modelAndView;
 *
 *                  }
 *
 * 这样Thymeleaf就能收我们传递的数据进行解析:
 *
 *                  <!DOCTYPE html>
 *                  <html lang="en" xmlns:th="http://www.thymeleaf.org">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>Title</title>
 *                      <script src="static/test1.js"></script>
 *                  </head>
 *                  <body>
 *                      HelloWorld！
 *                      <div th:text="${name}"></div>
 *                  </body>
 *                  </html>
 *
 * 当然为了简便 我们可以直接返回View名称 SpringMVC会将其自动包装为ModelAndView对象:
 *
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      return "index";
 *                  }
 *
 * 我们还可以单独添加一个Model作为形参进行设置 SpringMVC通过依赖注入会自动帮助我们传递实例对象:
 *
 *                  @RequestMapping("/index")
 *                  public String index(Model model) { // 这里不仅仅可以是Model 还可以是Map, ModelMap
 *
 *                      model.addAddAttribute("name", "yyds");
 *                      return "index";
 *
 *                  }
 *
 * 有了Spring框架的加持 相比我们之前编写的Web应用程序 简直方便了一个层次 你就说你爱不爱吧 你爱不爱
 *
 * 注意: 一定要保证视图名称下面出现横线并且按住Ctrl可以跳转 配置才是正确的(最新版IDEA)
 *
 * 我们的页面中可能还会包含一些静态资源 比如js, css 因此这里我们还需要配置一下 让静态资源通过Tomcat提供的默认Servlet进行解析
 * 我们需要让配置类实现一下WebMvcConfigurer接口 这样再Web应用程序启动时 会根据我们重写方法里面的内容进行进一步的配置:
 *
 *                  @Override
 *                  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
 *                      configurer.enable(); // 开启默认的Servlet
 *                  }
 *
 *                  @Override
 *                  public void addResourceHandlers(ResourceHandlerRegistry registry) {
 *                      registry.addResourceHandler("/static/**").addResourceLocations("/static/");
 *                      // 配置静态资源的访问路径
 *                  }
 *
 * 我们编写一下前端内容:
 *
 *                  <!DOCTYPE html>
 *                  <html lang="en" xmlns:th="http://www.thymeleaf.org">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>测试</title>
 *                      <!-- 引用静态资源 这里使用Thymeleaf的网址链接表达式 Thymeleaf会自动添加web应用程序的名称到链接前面 -->
 *                      <script th:src="@{/static/test1.js}"></script>
 *                  </head>
 *                  <body>
 *                      <p>欢迎来到GayHub全球最大同性交友网站</p>
 *                  </body>
 *                  </html>
 *
 * 创建test.js并编写如下内容:
 *
 *                  window.alert("欢迎来到GayHub全球最大同性交友网站")
 *
 * 最后访问页面 页面在加载时就会显示一个弹窗 这样我们就完成了最基本的页面配置 相比之前的方式 这样就简单很多了 直接避免了编写大量的Servlet来处理请求
 */
public class Main {

    public static void main(String[] args) {



    }

}
