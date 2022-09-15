package SpringMVC.springmvc11;

/*import SpringMVC.springmvc11.post.TestBeanProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * SpringMVC实现文件上传和下载
 * 利用SpringMVC 我们可以很轻松地实现文件上传和下载 同样的 我们只需要配置一个Resolver:
 *                  @Bean("multipartResolver") // 注意: 这里Bean的名称是固定的 必须是multipartResolver
 *                  public CommonsMultipartResolver commonsMultipartResolver(){
 *                      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
 *                      resolver.setMaxInMemorySize(1024 * 1024 * 10); // 最大10MB大小
 *                      resolver.setDefaultEncoding("UTF-8"); // 默认编码格式
 *                      return resolver;
 *                  }
 * 接着我们直接编写Controller即可:
 *                  @RequestMapping(value = "upload", method = RequestMethod.POST)
 *                  @ResponseBody
 *                  public String upload(@RequestParam CommonsMultipartFile file) throws IOException {
 *                      File fileObj = new File("test.png");
 *                      file.transferTo(fileObj);
 *                      System.out.println("用户上传的文件已保存到: " + fileObj.getAbsolutePath());
 *                      return "文件上传成功";
 *                  }
 * 使用CommonsMultipartFile对象来接收用户上传的文件 它是基于Apache的Commons-fileupload框架实现的 我们还需要导入一个依赖:
 *                  <dependency>
 *                      <groupId>commons-fileupload</groupId>
 *                      <artifactId>commons-fileupload</artifactId>
 *                      <version>1.4</version>
 *                  </dependency>
 * 最后在前端添加一个文件的上传点:
 *                  <div>
 *                      <form action="/upload" method="post" enctype="multipart/form-data">
 *                          <input type="file" name="file">
 *                          <input type="submit">
 *                      </form>
 *                  </div>
 * 这样 点击提交之后 文件就会上传到服务器了
 *
 * 下载其实和我们之前的写法大致一致 直接使用HttpServletResponse 并向输出流中传输数据即可
 *                  @RequestMapping(value = "/download", method = RequestMethod.GET)
 *                  public void download(HttpServletResponse response){
 *                      response.setContentType("multipart/form-data");
 *                      try (OutputStream stream = response.getOutputStream();
 *                           InputStream inputStream = new FileInputStream("test.js")){
 *                          IOUtils.copy(inputStream, stream);
 *                      } catch (IOException e){
 *                          e.printStackTrace();
 *                      }
 *                  }
 * 在前端页面添加一个下载点:
 *                  <a href="/download" download="test.png">下载最新资源</a>
 */
public class Main {

    public static void main(String[] args) {
        //DispatcherServlet d;
    }

}
