package SpringMVC.springmvc5;

/**
 * SpringMVC重定向和请求转发
 * 重定向和请求转发也非常简单 我们只需要在视图名称前面添加一个前缀即可 比如重定向:
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      return "redirect:home";
 *                  }
 *                  @RequestMapping(value = "/home")
 *                  public String home(){
 *                      return "home";
 *                  }
 *
 * 通过添加redirect:前缀 就可以很方便地实现重定向 那么请求转发呢 其实也是一样的 使用forward前缀 表示字符给其他请求映射:
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      return "forward:home";
 *                  }
 *                  @RequestMapping("/home")
 *                  public String home(){
 *                      return "/home";
 *                  }
 * 使用SpringMVC 只需要一个前缀就可以实现重定向和请求转发 非常方便
 *
 * Bean的Web作用域
 * 在信息Spring时我们讲解了Bean的作用域 包括singleton和prototype Bean分别会以单例和原型模式进行创建 而在SpringMVC中 它的作用域被细分:
 *      > request 对于每次HTTP请求 使用request作用域定义的Bean都将产生一个新实例 请求结束后Bean也消失
 *      > session 对于每一个会话 使用session作用域定义的Bean都将产生一个新实例 会话过期后Bean也消失
 *      > global session 不常用 不做讲解
 * 这里我们创建一个测试类来试试看:
 *                  public class TestBean {
 *
 *                  }
 * 接着将其注册为Bean 注意: 这里需要添加@RequestScope或是@SessionScope表示此Bean的Web作用域:
 *                  @Bean
 *                  @RequestScope
 *                  //@SessionScope
 *                  public TestBean testBean(){
 *                      return new TestBean();
 *                  }
 * 接着我们将其自动注入到Controller中:
 *                  @Controller
 *                  public class MainController{
 *                      @Resource
 *                      TestBean bean;
 *
 *                      @RequestMapping(value = "/index")
 *                      public ModelAndView index(){
 *                          System.out.println(bean);
 *                          return new ModelAndView("/index");
 *                      }
 *                  }
 *
 * 我们发现 每次发起得到的Bean实例都不同 接着我们将其作用域修改为@SessionScope 这样作用域就上升到Session
 * 只要清理浏览器的Cookie 那么都会被认为是同一个会话 只要是同一个会话 那么Bean实例始终不变
 *
 * 实际上 它也是通过代理实现的 我们调用Bean中的方法会被转发到真正的Bean对象去执行
 */
public class Main {

    public static void main(String[] args) {

    }

}
