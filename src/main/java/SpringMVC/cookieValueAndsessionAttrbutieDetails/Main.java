package SpringMVC.cookieValueAndsessionAttrbutieDetails;

/**
 * CookieValue和SessionAttribute详解
 * 通过使用@CookieValue注解 我们也可以快速获取请求携带的Cookie信息:
 *
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(HttpServletResponse response,
 *                                            @CookieValue(value = "test", required = false) String test){
 *
 *                      System.out.println("获取到cookie值为："+test);
 *                      response.addCookie(new Cookie("test", "lbwnb"));
 *                      return new ModelAndView("index");
 *
 *                  }
 *
 * 同样的 Session也能使用注解快速获取:
 *
 *                  @RequestMapping(value = "/index")
 *                  public ModelAndView index(@SessionAttribute(value = "test", required = false) String test,
 *                                            HttpSession session){
 *
 *                      session.setAttribute("test", "xxxx");
 *                      System.out.println(test);
 *                      return new ModelAndView("index");
 *
 *                  }
 *
 * 可以发现 通过使用SpringMVC框架 整个Web应用程序的开发变得非常简单 大部分功能只需要一个注解就可以搞定了 正是得益于Spring框架 SpringMVC才能大显身手
 */
public class Main {

    public static void main(String[] args) {



    }

}
