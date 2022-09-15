package SpringMVC.springmvc8;

/**
 * 自定义异常处理
 * 当我们的请求映射方法中出现异常时 会直接展示在前端页面 这是因为SpringMVC为我们提供了默认的异常处理页面
 * 当出现异常时 我们的请求会被直接交给专门用于异常处理的控制器进行处理
 *
 * 我们可以自定义一个异常处理控制器 一旦出现指定异常 就会转接到此控制器执行:
 *                  @ExceptionHandler(Exception.class)
 *                  public String error(Exception e, Model model){ // 可以直接添加形参来获取异常
 *                      e.printStackTrace();
 *                      model.addAttribute("e", e);
 *                      return "500";
 *                  }
 * 接着我们编写一个专门显示异常的页面:
 *                  <!DOCTYPE html>
 *                  <html lang="en" xmlns:th="http://www.thymeleaf.org">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>出错了</title>
 *                  </head>
 *                  <body>
 *                      <div style="color: red" th:text="${e}">500 - 服务器遇到了一点问题XD </div>
 *                  </body>
 *                  </html>
 * 接着修改:
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      if (true) throw new RuntimeException("您的氪金力度不足 无法访问! ");
 *                      return "/index";
 *                  }
 * 访问后 我们发现控制台会输出异常信息 同时页面也是我们自定义的一个页面
 */
public class Main {

    public static void main(String[] args) {

    }

}
