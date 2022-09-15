package SpringMVC.springmvc10;

/**
 * AJAX请求
 * 前面我们讲解了如何向浏览器发送一个JSON格式的数据 那么我们现在来看看如何向服务器请求数据
 *
 * ajax即Asynchronous Javascript And XML(异步javaScript和XML) 它的目标就是实现页面中的数据动态更新 而不是直接刷新整个页面 它是一个概念
 *
 * 它在JQuery框架中有实现 因此我们直接导入JQuery (JQuery极大地简化了js的开发 封装了很多内容 感兴趣的可以了解一下):
 *                  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 * 接着我们就可以直接使用了 首先修改一下前端页面:
 *                  <!DOCTYPE html>
 *                  <html lang="en" xmlns:th="http://www.thymeleaf.org">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>Title</title>
 *                      <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 *                      <script th:src="@{/static/test.js}"></script>
 *                  </head>
 *                  <body>
 *                      <div>
 *                          你好:
 *                          <span id="username"></span>
 *                          您的年龄是:
 *                          <span id="password"></span>
 *                          <button onclick="updateData()">点我更新页面数据</button>
 *                      </div>
 *                  </body>
 *                  </html>
 * 现在我们希望用户名称和年龄需要在我们点击按钮之后才会更新 我们接着来编写一下JS:
 *                  function updateData() {
 *                      // 美元符. 的方式来使用Ajax请求 这里使用的是get方式 第一个参数为请求地址(注意: 需要带上Web应用程序名称) 第二个参数为成功获取到数据的方法 data就是返回的数据内容
 *                      $.get("/mvc/data", function (data) { // 获取成功执行的方法
 *                          window.alert('接收到异步请求数据: ' + JSON.stringify(data)) // 弹窗展示数据
 *                          $("#username").text(data.username) // 这里使用了JQuery提供的选择器 直接选择id为username的元素 更新数据
 *                          $("#password").text(data.password)
 *                      })
 *                  }
 * 使用JQuery非常方便 我们直接通过JQuery的选择器就可以快速获取页面中的元素 注意: 这里获取的元素是被JQuery封装过的元素 需要使用JQuery提供的方法来进行操作
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      return "/index";
 *                  }
 *                  @RequestMapping(value = "/data", produces = "application/json")
 *                  @ResponseBody
 *                  public User user(){
 *                      User user = new User();
 *                      user.setUsername("叶玄朔");
 *                      user.setPassword("12345678");
 *                      return user;
 *                  }
 * 这样 我们就实现了从服务端获取数据并更新数据并更新到页面中 (实际上之前 我们在javaWeb阶段使用XHR请求也演示过 不过当时是纯粹的数据)
 *
 * 那么我们接着来看 如何向服务器发送一个JS对象数据并进行解析:
 *                  submitData = function(){
 *                      $.post("/mvc/submit", { // 这里使用POST方法发送请求
 *                          name: "Test", // 第二个参数是要传递的对象 会以表单数据的方式发送
 *                          age: 20
 *                      }, function (data) {
 *                          window.alert(JSON.stringify(data)) // 发送成功执行的方法
 *                      })
 *                  }
 * 服务器只需要在请求参数位置添加一个对象接收即可 (和前面是一样的 因为这里也是提交的表单数据):
 *                  @RequestMapping(value = "/submit")
 *                  @ResponseBody
 *                  public String submit(User user){
 *                      System.out.println("接收到数据: " + user);
 *                      return "{\"success\": true}";
 *                  }
 *
 * 我们也可以将js对象转换为JSON字符串的形式进行传输 这里需要使用ajax方法来处理:
 *                  submitData = function(){
 *                      $.ajax({ // 最基本的请求方式 需要自己设定一些参数
 *                          type: 'POST', // 设定请求方法
 *                          url: "/mvc/submit", // 请求地址
 *                          data: JSON.stringify({username: "赛博朋克", password: 2088}), // 转换为JSON字符串进行发送
 *                          success: function (data) {
 *                              window.alert(JSON.stringify(data))
 *                          },
 *                          contentType: "application/json" // 请求头Content-Type 一定要设定为JSON格式
 *                      })
 *                  }
 * 如果我们需要读取前端发送给我们的JSON格式数据 那么这个时候就需要添加@RequestBody注解:
 *                  @RequestMapping(value = "/submit")
 *                  @ResponseBody
 *                  public String submit(@RequestBody User user){
 *                      System.out.println("接收到数据: " + user);
 *                      return "{\"success\": true}";
 *                  }
 * 这样 我们就实现了前后端使用JSON字符串进行通信
 */
public class Main {

    public static void main(String[] args) {

    }

}
