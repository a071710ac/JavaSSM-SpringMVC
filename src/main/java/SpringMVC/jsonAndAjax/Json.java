package SpringMVC.jsonAndAjax;

/**
 * JSON数据格式
 * 既然要实现前后端分离 那么我们就必须约定一种更加高效的数据传输模式 来向前端页面传输后端提供的数据
 * 因此JSON横空出世 它非常容易理解 并且与前端的兼容性极好 因此现在比较主流的数据传输方式则是通过JSON格式承载的
 *
 * 一个JSON格式的数据长这样 以学生对象为例:
 *
 *                  {"name": "杰哥", "age": 18}
 *
 * 多个学生可以以数组的形式表示:
 *
 *                  [{"name": "杰哥", "age": 18}, {"name": "阿伟", "age": 18}]
 *
 *  嵌套关系可以表示为:
 *
 *                  {"studentList": [{"name": "杰哥", "age": 18}, {"name": "阿伟", "age": 18}], "count": 2}
 *
 * 它直接包括了属性的名称和属性的值 与JavaScript的对象极为相似 它到达前端后 可以直接转换为对象
 * 以对象的形式进行操作和内容的读取 相当于以字符串形式表示了一个JS对象 我们可以直接在浏览器控制台窗口中测试:
 *
 *                  // 将JSON格式字符串转换为JS对象
 *                  let obj = JSON.parse('{"studentList": [{"name": "杰哥", "age": 18}, {"name": "阿伟", "age": 18}], "count": 2}')
 *                  // 直接访问第一个学生的名称
 *                  obj.studentList[0].name
 *
 * 我们也可以将JS对象转换为JSON字符串:
 *
 *                  JSON.stringify(obj)
 *
 * 我们后端就可以以JSON字符串的形式向前端返回数据 这样前端在拿到数据之后 就可以快速获取 非常方便
 *
 * 那么后端如何快速创建一个JSON格式的数据呢? 我们首先需要导入以下依赖:
 *
 *                  <dependency>
 *                      <groupId>com.alibaba</groupId>
 *                      <artifactId>fastjson</artifactId>
 *                      <version>1.2.78</version>
 *                  </dependency>
 *
 * JSON解析框架有很多种 比较常用的是Jackson和FastJSON 这里我们使用阿里巴巴的FastJSON进行解析
 *
 * 首先要介绍的是JSONObject 它和Map的使用方法一样(实现了Map接口) 比如我们向其中存放几个数据:
 *
 *                  @RequestMapping(value = "/index")
 *                  public String index() {
 *
 *                      JSONObject object = new JSONObject();
 *                      object.put("name", "杰哥");
 *                      object.put("age", 18);
 *                      System.out.println(object.toJSONString()); // 以JSON格式输出JSONObject字符串
 *                      return "index";
 *
 *                  }
 *
 * 最后我们得到的结果为:
 *
 *                  {"name":"杰哥","age":18}
 *
 * 实际上JSONObject就是对JSON数据的一种对象表示 同样的还有JSONArray 它表示一个数组 用法和List一样 数组中可以嵌套其他的JSONObject或是JSONArray:
 *
 *                  @RequestMapping(value = "/index")
 *                  public String index(){
 *                      JSONObject object = new JSONObject();
 *                      object.put("name", "杰哥");
 *                      object.put("age", 18);
 *                      JSONArray array = new JSONArray();
 *                      array.add(object);
 *                      System.out.println(array.toJSONString());
 *                      return "index";
 *                  }
 *
 * 得到结果为:
 *                  [{"name":"杰哥","age":18}]
 *
 * 当出现循环引用时 会按照以下语法来解析:
 *
 *      https://img2018.cnblogs.com/blog/1758707/201908/1758707-20190814212141691-1998020800.png
 *
 * 我们可以也直接创建一个实体类 将实体类转换为JSON格式的数据:
 *
 *                  @RequestMapping(value = "/index", produces = "application/json")
 *                  @ResponseBody
 *                  public String data(){
 *
 *                      Student student = new Student();
 *                      student.setName("杰哥");
 *                      student.setAge(18);
 *                      return JSON.toJSONString(student);
 *
 *                  }
 *
 * 这里我们修改了produces的值 将返回的内容类型设定为application/json 表示服务器端返回了一个JSON格式的数据(当然不设置也行 也能展示 这样是为了规范)
 * 然后我们在方法上添加一个@ResponseBody表示方法返回(也可以在类上添加@RestController表示此Controller默认返回的是字符串数据)的结果不是视图名称而是直接需要返回一个字符串作为页面数据
 * 这样 返回给浏览器的就是我们直接返回的字符串内容
 *
 * 接着我们使用JSON工具类将其转换为JSON格式的字符串 打开浏览器得到JSON格式数据
 *
 * SpringMVC非常智能 我们可以直接返回一个对象类型 它会被自动转换为JSON字符串格式:
 *
 *                  @RequetsMapping(value = "/data", produces = "application/json")
 *                  @ResponseBody
 *                  public Student data() {
 *
 *                      student student = new Student();
 *                      student.setName("杰哥");
 *                      student.setAge(18);
 *                      return student;
 *
 *                  }
 *
 * 注意: 需要在配置类中添加一下FastJSON转换器(默认只支持jackSon):
 *
 *                  @Override
 *                  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
 *                      converters.add(new FastJsonHttpMessageConverter());
 *                  }
 */
public class Json {

    public static void main(String[] args) {



    }

}
