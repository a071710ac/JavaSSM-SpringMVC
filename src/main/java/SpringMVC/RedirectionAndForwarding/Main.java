package SpringMVC.RedirectionAndForwarding;

/**
 * 重定向与请求转发
 * 重定向和请求转发也非常简单 我们只需要再视图名称前面添加一个前缀即可 比如重定向:
 *
 *                  @RequestMapping("/index1")
 *                  public String index1() {
 *                      return "redirect:home";
 *                  }
 *
 *                  @RequestMapping("/home")
 *                  public String home() {
 *                      return "home";
 *                  }
 *
 * 通过添加redirect:前缀 就可以很方便地实现重定向 那么请求转发呢 其实也是一样的 使用 forward: 前缀表示转发给其他请求映射:
 *
 *                  @RequestMapping("/index")
 *                  public String index(){
 *                      return "forward:home";
 *                  }
 *
 *                  @RequestMapping("/home")
 *                  public String home(){
 *                      return "home";
 *                  }
 *
 * 使用SpringMVC 只需要一个前缀就可以实现重定向和请求转发 非常方便
 */
public class Main {

    public static void main(String[] args) {



    }

}
