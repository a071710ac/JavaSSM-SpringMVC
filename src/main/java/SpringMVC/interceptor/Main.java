package SpringMVC.interceptor;

/**
 * 创建拦截器
 * 创建一个拦截器我们需要实现一个HandlerInterceptor接口:
 *
 *                  public class MainInterceptor implements HandlerInterceptor {
 *
 *                      @Override
 *                      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 *
 *                          System.out.println("我是处理之前");
 *                          return true; // 只有返回true才会继续 否则直接结束
 *
 *                      }
 *
 *                      @Override
 *                      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 *                          System.out.println("我是处理之后");
 *                      }
 *
 *                      @Override
 *                      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
 *                          System.out.println("我是完成之后");
 *                      }
 *
 *                  }
 *
 * 接着来我们需要在配置类中进行注册:
 *
 *                  @Override
 *                  public void addInterceptors(InterceptorRegistry registry) {
 *
 *                      registry.addInterceptor(new MainInterceptor())
 *                              .addPathPatterns("/**") // 添加拦截器的匹配路径 只要匹配一律拦截
 *                              .excludePathPatterns("/home"); // 拦截器不进行拦截的路径
 *
 *                  }
 *
 * 现在我们在浏览器中访问index页面 拦截器已经生效
 *
 * 得到整理拦截器的执行顺序:
 *
 *                  我是处理之前
 *                  我是处理
 *                  我是处理之后
 *                  我是完成之后
 *
 * 也就是说 处理前和处理后 包含了真正的请求映射的处理 在整个流程结束后还执行了异常afterCompletion方法 其实整个过程与我们之前所认识的Filter类似
 * 不过在处理前 我们只需要返回true或是false表示是否被拦截即可 而不是再去使用FilterChain进行向下传递
 *
 * 那么我们就来看看 如果处理前返回false 会怎么样:
 *
 *                  我是处理之前！
 *
 * 通过结果发现一旦返回false 之后的所有流程全部取消 那么如果是在处理中发生异常了呢?
 *
 *                  @RequestMapping("/index")
 *                  public String index(){
 *
 *                      System.out.println("我是处理！");
 *                      if(true) throw new RuntimeException("");
 *                      return "index";
 *
 *                  }
 *
 * 结果为:
 *
 *                  我是处理之前
 *                  我是处理
 *                  我是完成之后
 *
 * 我们发现如果处理过程中抛出异常 那么就不会执行处理后postHandle方法 但是会执行afterCompletion方法 我们可以在此方法中获取到抛出的异常
 *
 * 多级拦截器
 * 前面我们介绍了仅仅只有一个拦截器的情况 我们接着来看如果存在多个拦截器会如何执行 我们以同样的方式创建二号拦截器:
 *
 *                  public class SubInterceptor implements HandlerInterceptor {
 *
 *                      @Override
 *                      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 *
 *                          System.out.println("[二号拦截器] 我是处理之前");
 *                          return true;
 *
 *                      }
 *
 *                      @Override
 *                      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 *                          System.out.println("[二号拦截器] 我是处理之后");
 *                      }
 *
 *                      @Override
 *                      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
 *                          System.out.println("[二号拦截器] 我是完成之后");
 *                      }
 *
 *                  }
 *
 * 注册二号拦截器:
 *
 *                  @Override
 *                  public void addInterceptors(InterceptorRegistry registry) {
 *
 *                      registry.addInterceptor(new MainInterceptor())
 *                              .addPathPatterns("/**")
 *                              .excludePathPatterns("/home");
 *
 *                      registry
 *                              .addInterceptor(new SubInterceptor())
 *                              .addPathPatterns("**");
 *
 *                  }
 *
 * 注意拦截顺序就是注册的顺序 因此拦截器会根据注册顺序依次执行 我们可以打开浏览器运行一次:
 *
 *                  [一号拦截器] 我是处理之前
 *                  [二号拦截器] 我是处理之前
 *                  我是处理
 *                  [二号拦截器] 我是处理之后
 *                  [一号拦截器] 我是处理之后
 *                  [二号拦截器] 我是完成之后
 *                  [一号拦截器] 我是完成之后
 *
 * 和多级Filter相同 在处理之前 是按照顺序从前向后进行拦截的 但是处理完成之后 就按照倒序执行处理后方法 而完成后是在所有的postHandle执行之后再同样的以倒序方式执行
 *
 * 那么如果这时一号拦截器在处理器就返回了false呢?
 *
 *                  [一号拦截器] 我是处理之前
 *
 * 我们发现 与单个拦截器的情况一样 一旦拦截器返回false 那么之后无论有无拦截器 都不再继续
 */
public class Main {

    public static void main(String[] args) {



    }

}
