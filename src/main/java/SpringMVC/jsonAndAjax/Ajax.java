package SpringMVC.jsonAndAjax;

/**
 * AJAX请求
 * 前面我们讲解了如何向浏览器发送一个JSON格式的数据 那么我们现在来看看如何向服务器请求数据
 *
 *         https://www.runoob.com/wp-content/uploads/2013/09/ajax-yl.png
 *
 * Ajax即Asynchronous JavaScript And XML(异步JavaScript和XML) 它的目标就是实现页面中的数据动态更新 而不是直接刷新整个页面 它是一个概念
 *
 * 它在JQuery框架中有实现 因此我们直接导入JQuery(JQuery极大地简化了JS的开发 封装了很多内容 感兴趣的可以了解一下):
 *
 *                  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 *
 * 接着我们就可以直接使用了 首先修改一下前端页面:
 *
 *                  <!DOCTYPE html>
 *                  <html lang="en" xmlns:th="http://www.thymeleaf.org">
 *                  <head>
 *                      <meta charset="UTF-8">
 *                      <title>Title</title>
 *                      <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 *                      <script th:src="@{/static/test.js}"></script>
 *                  </head>
 *                  <body>
 *                      你好,
 *                      <span id="username"></span>
 *                      您的年龄是:
 *                      <span id="age"></span>
 *                      <button onclick="updateData()">点我更新页面数据</button>
 *                  </body>
 *                  </html>
 *
 * 现在我们希望用户名称和年龄需要在我们点按纽之后才会更新 我们接着来编写一下JS:
 *
 *                  function updateData() {
 *
 *                      // 美元符.的方式来使用Ajax请求 这里使用的是get方式 第一个参数为请求的地址(注意需要带上Web应用程序名称) 第二个参数为成功获取到数据的方法 data就是返回的数据内容
 *                      $.get("/mvc/data", function (data) { // 获取成功执行的方法
 *                          window.alert('接收到异步请求数据: ' + JSON.stringify(data)) // 弹窗展示数据
 *                          $("#username").text(data.name) // 这里使用了JQuery提供的选择器 直接选择id为username的元素, 更新数据
 *                          $("#age").text(data.age)
 *                      })
 *
 *                  }
 *
 * 使用JQuery非常方便 我们直接通过JQuery的选择器就可以快速获取页面中的元素 注意: 这里获取的元素是被JQuery封装过的元素 需要使用JQuery提供的方法来进行操作:
 *
 *                  @ResponseBody
 *                  @RequestMapping(value = "/data", produces = "application/json")
 *                  public Student get() {
 *
 *                      Student student = new Student();
 *                      student.setName("杰哥");
 *                      student.setAge(18);
 *                      return student;
 *
 *                  }
 *
 * 这样 我们就实现了从服务端获取并更新到页面中(实际上之前 我们在JavaWeb阶段使用XHR请求也演示过 不过当时是纯粹的数据)
 *
 * 那么我们接着来看 如何向服务端发送一个JS对象数据并进行解析:
 *
 *                  function submitData() {
 *
 *                      $.post("/mvc/submit", { // 这里使用POST方法发送请求
 *                          name: "测试", // 第二个参数是要传递的对象 会以表单数据的方式发送
 *                          age: 18
 *                      }, function (data) {
 *                          window.alert(JSON.stringify(data)) // 发送成功执行的方法
 *                      })
 *
 *                  }
 *
 * 服务器端只需要请求参数位置添加一个对象接收即可(和前面是一样的 因为这里也是提交的表单数据):
 *
 *                  @ResponseBody
 *                  @RequestMapping("/submit")
 *                  public String submit(Student student){
 *
 *                      System.out.println("接收到前端数据：" + student);
 *                      return "{\"success\": true}";
 *
 *                  }
 *
 * 这里还需要修改一下配置类里面的FastJSON转换器 因为基于我们的配置是只支持JSON数据格式的
 * 所以我们需要限定一下当发送只有是JSON数据格式才进行转换 其他则默认不转换:
 *
 *                  @Override
 *                  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
 *
 *                      FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
 *                      converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
 *                      converters.add(converter);
 *
 *                  }
 *
 * 我们也可以将JS对象转换为JSON字符串的形式进行传输 这里需要使用ajax方法来处理:
 *
 *                  function  submitAjaxData() {
 *
 *                      $.ajax({ // 最基本的请求方式 需要自己设定一些参数
 *                          type: 'POST', // 设定请求方式
 *                          url: "/mvc/submit", // 请求地址
 *                          data: JSON.stringify({name: "测试", age: 18}), // 转换为JSON字符串进行
 *                          success: function (data) {
 *                              window.alert(JSON.stringify(data))
 *                          },
 *                          contentType: "application/json" // 请求头Content-Type一定要设定为JSON格式
 *                      })
 *
 *                  }
 *
 * 如果我们需要读取前端发送给我们的JSON格式数据 那么这个时候需要添加@RequestBody注解:
 *
 *                  @RequestMapping("/submit")
 *                  @ResponseBody
 *                  public String submit(@RequestBody JSONObject object){
 *
 *                      System.out.println("接收到前端数据："+object);
 *                      return "{\"success\": true}";
 *
 *                  }
 *
 * 这样 我们就实现了前后端使用JSON字符串进行通信
 */
public class Ajax {

    public static void main(String[] args) {



    }

}
