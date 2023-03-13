package SpringMVC.uploadAndDownload;

/**
 * 实现文件上传和下载
 * 利用SpringMVC 我们可以很轻松地实现文件上传和下载 同样的 我们只需要配置一个Resolver:
 *
 *                  @Bean("multipartResolver")   // 注意这里Bean的名称是固定的 必须是multipartResolver
 *                  public CommonsMultipartResolver commonsMultipartResolver(){
 *
 *                      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
 *                      resolver.setMaxUploadSize(1024 * 1024 * 10);   // 最大10MB大小
 *                      resolver.setDefaultEncoding("UTF-8");   // 默认编码格式
 *                      return resolver;
 *
 *                  }
 *
 *
 */
public class Main {

    public static void main(String[] args) {



    }

}
