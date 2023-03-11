package SpringMVC.beanWebScope;

/**
 * Bean的Web作用域
 * 在学习Spring时我们讲解了Bean的作用域 包括singleton和prototype
 * Bean分别会以单例和多例模式进行创建 而在SpringMVC中 它的作用域被继续细分:
 *
 *      > request: 对于每次HTTP请求 使用request作用域定义的Bean都将产生一个新实例 请求结束后Bean也消失
 *      > session: 对于每一个会话 使用session作用域定义的Bean都将产生一个新实例 会话过期后Bean也消失
 *      > global session: 不常用 不做讲解(可自行了解)
 *
 * 这里我们创建一个测试类来试试看:
 *
 *                  public class TestBean {
 *
 *                  }
 *
 * 接着将其注册为Bean 注意这里需要添加 @RequestScope 或是 @SessionScope 表示此Bean的Web作用域:
 *
 *                  @Bean
 *                  @RequestScope
 *                  public TestBean testBean() {
 *                      return new TestBean();
 *                  }
 *
 * 接着我们将其自动注入到Controller中:
 *
 *                  @Controller
 *                  public class MainController {
 *
 *                      @Resource
 *                      TestBean bean;
 *
 *                      @RequestMapping(value == "/index")
 *                      public ModelAndView index() {
 *
 *                          System.out.println(bean);
 *                          return new ModelAndView("index");
 *
 *                      }
 *
 *                  }
 *
 * 我们发现 每次发起得到的Bean实例都不同 接着我们将其作用域修改为@SessionScope 这样作用域就上升到Session
 * 只要清理浏览器的Cookie 那么都会被认为是同一个会话 只要是同一个会话 那么Bean实例始终不变
 */
public class Main {

    public static void main(String[] args) {



    }

}
