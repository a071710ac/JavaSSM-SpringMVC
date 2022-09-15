package SpringMVC.springmvc3;

/**
 * @RequestMapping详解
 * 前面我们已经了解了如何篡创建一个控制器来处理我们的请求 接着我们只需要在控制器添加一个方法用于处理对应的请求即可 之前我们需要完整地编写一个Servlet来实现
 * 而现在我们只需要添加一个@RequestMapping即可实现 其实从它的名字我们也能得知 此注解就是将请求和处理请求的方法建立一个映射关系
 * 当收到请求时就可以根据映射关系调用对应的请求处理方法 那么我们就先来聊聊@RequestMapping吧 注解定义如下:
 *                      @Target({ElementType.TYPE, ElementType.METHOD})
 *                      @Retention(RetentionPolicy.RUNTIME)
 *                      @Documented
 *                      @Mapping
 *                      public @interface RequestMapping {
 *                          String name() default "";
 *
 *                          @AliasFor("path")
 *                          String[] value() default {};
 *
 *                          @AliasFor("value")
 *                          String[] path() default {};
 *
 *                          RequestMethod[] method() default {};
 *
 *                          String[] params() default {};
 *
 *                          String[] headers() default {};
 *
 *                          String[] consumes() default {};
 *
 *                          String[] produces() default {};
 *                      }
 * 其中最关键的是path属性(等价于value) 它决定了当前方法处理的请求路径 注意路径必须全局唯一 任何路径只能有一个方法进行处理
 * 它是一个数组 也就是说此方法不仅仅可以只用于处理某一个请求路径 我们可以使用此方法处理多个请求路径:
 *                      @RequestMapping({"/index", "/test"})
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 现在我们访问/index或是/test 都会经过此方法进行处理
 *
 * 我们也可以直接将@RequstMapping添加到类名上 表示为此类中的所有请求映射添加一个"路径前缀" 比如:
 *                      @Controller
 *                      @RequestMapping("/yyds")
 *                      public class MainController {
 *
 *                          @RequestMapping({"/index", "/test"})
 *                          public String index(){
 *                              return "/index";
 *                          }
 *
 *                      }
 * 那么现在我们需要访问/yyds/index或是/yyds/test才可以得到此页面
 *
 * 我们可以直接在IDEA下方的端点板块查看当前Web应用程序定义的所有请求映射 并且可以通过IDEA为我们提供内置Web客户端直接访问某个路径
 *
 * 路径还支持使用通配符进行匹配:
 *      > ? 表示任意一个字符 比如@RequestMapping("index/x?")可以匹配//index/xa /index/xb等等
 *      > * 表示任意0-n个字符 比如@RequestMapping("/index/*")可以匹配/index/yxsnb /index/yyds等等
 *      > ** 表示当前目录或基于当前目录的多级目录 比如@RequestMapping("/index/**")可以匹配/index /index/xxx等等
 *
 * 我们接着来看一下method属性 顾名思义 它就是请求的方法类型 我们可以跟定请求方式 比如:
 *                      @RequestMapping(value = "/index", method = RequestMethod.POST)
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 现在我们如果直接使用浏览器访问此页面 会显示405方法不支持 因为浏览器默认是直接使用GET方法获取页面 而我们这里指定为POST方法访问此地址 所以访问失败
 * 我们现在再去端点中用POST方式去访问 成功得到页面
 *
 * 我们也可以使用衍生注解直接设定为指定类型的请求映射:
 *                      @PostMapping(value = "/index")
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 这里使用了@PostMapping直接指定为POST请求类型的请求映射 同样的 还有@GetMapping可以直接指定为GET请求方式 这里就不一一演示了
 *
 * 我们可以使用params属性来指定请求必须携带哪些请求参数 比如:
 *                      @RequestMapping(value = "/index", params = {"username", "password"})
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 比如这里我们要求请求中必须携带username和password属性 否则无法访问 它还支持表达式 比如我们可以这样编写:
 *                      @RequestMapping(value = "/index", params = {"!username", "password"})
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 在username之前添加一个感叹号表示请求的不允许携带此参数 否则无法访问 我们甚至可以直接设定一个固定值:
 *                      @RequestMapping(value = "/index", params = {"username!=test", "password=123"})
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 这样 请求参数username不允许为test 并且password必须为123 否则无法访问
 *
 * header属性用法与params一致 但是它要求的是请求头中需要携带什么内容 比如:
 *                      @RequestMapping(value = "/index", headers = "!Connection")
 *                      public String index(){
 *                          return "/index";
 *                      }
 * 那么 如果请求头中携带了Connection属性 将无法访问其他两个属性:
 *      > consumes 指定处理请求的提交内容类型(Content-Type) 例如application/json text/html
 *      > produces 指定返回的内容类型 仅当request请求头中的(Accept)类型中包含该指定类型才返回
 */
public class Main {

    public static void main(String[] args) {

    }

}
