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
 *
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {



    }

}
