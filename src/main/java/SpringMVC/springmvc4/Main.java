package SpringMVC.springmvc4;

/**
 * @RequestParam和@RequestHeader详解
 * 我们接着来看 如何获取到请求中的参数
 *
 * 我们只需要为方法添加一个形式参数 并在形式参数前面添加@RequestParam注解即可:
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(@RequestParam("username") String username){
 *                      System.out.println("接收到请求参数: " + username);
 *                      return new ModelAndView("/index");
 *                  }
 * 我们需要在@RequestParam中填写参数名称 参数的值会自动传递给形式参数 我们可以直接在方法中使用
 * 注意: 如果参数名称与形式参数名称相同 即使不添加@RequestParam也能获取到参数值
 *
 * 一旦添加@RequestParam 那么此请求必须携带指定参数 我们也可以将require属性设定为false来将属性设定为非必须
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(@RequestParam(value = "username", required = false) String username){
 *                      System.out.println("接收到请求参数: " + username);
 *                      return new ModelAndView("/index");
 *                  }
 * 我们还可以直接设定一个默认值 当请求参数缺失时 可以直接使用默认值:
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(@RequestParam(value = "username", required = false, defaultValue = "伞兵一号") String username){
 *                      System.out.println("接收到请求参数: " + username);
 *                      return new ModelAndView("/index");
 *                  }
 *
 * 如果需要使用Servlet原本的一些类 比如:
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(HttpServletRequest request){
 *                      System.out.println("接收到请求参数: " + request.getParameterMap().keySet());
 *                      return new ModelAndView("/index");
 *                  }
 * 直接添加HttpServetRequest为形式参数即可 SpringMVC会自动传递该请求原本的HttpServletRequest对象
 * 我们也可以添加HttpServletResponse作为形式参数 甚至可以直接将HttpSession也作为参数传递:
 *                  @RequestMapping()
 *                  public ModelAndView index(HttpSession session){
 *                      System.out.println(session.getAttribute("test"));
 *                      session.setAttribute("test", "鸡你太美");
 *                      return new ModelAndView("/index");
 *                  }
 * 我们还可以直接将请求传递给一个实体类:
 *                  @Data
 *                  public class User {
 *                      String username;
 *                      String password;
 *                  }
 * 注意: 必须携带set方法或是构造方法中包含所有参数 请求参数会自动根据类中的字段名称进行匹配:
 *                  @RequestMapping(value = "/index")
 *                  public String index(User user){
 *                      System.out.println("接收到请求参数: " + user);
 *                      return "/index";
 *                  }
 *
 * @RequestHeader与@RequestParam用法一致 不过它是用于获取请求头参数的 这里就不演示了
 *
 * @CookieValue和@SessionAttrbutie
 * 通过使用@CookieValue注解 我们也可以快速获取请求携带的Cookie信息:
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(HttpServletResponse response,
 *                                            @CookieValue(value = "test", required = false) String test){
 *
 *                      System.out.println();
 *                      response.addCookie(new Cookie("test", "yxsnb"));
 *                      return new ModelAndView("/index");
 *                  }
 *
 * 同样的 Session也能使用注解快速获取:
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(@SessionAttribute(value = "test", required = false)String test,
 *                                            HttpSession session){
 *
 *                      session.setAttribute("test", "xxxx");
 *                      System.out.println(test);
 *                      return new ModelAndView("/index");
 *                  }
 * 可以发现 通过使用SpringMVC框架 整个Web应用程序的开发变得非常简单 大部分功能只需要一个注解就可以搞定了 正是得益与Spring框架 SpringMVC才能大显身手
 */
public class Main {

    public static void main(String[] args) {

    }

}
