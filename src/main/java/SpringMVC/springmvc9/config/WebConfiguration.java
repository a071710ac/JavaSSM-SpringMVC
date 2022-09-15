package SpringMVC.springmvc9.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;

/*@Configuration
@EnableWebMvc
@ComponentScan("SpringMVC.springmvc9.controller")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(@Autowired SpringTemplateEngine springTemplateEngine){ // 我们需要使用ThymeleafViewResolver作为视图解析器 并解析我们的HTML页面
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setOrder(1); // 可以存在多个视图解析器 并且可以为他们设定解析顺序
        resolver.setCharacterEncoding("UTF-8"); // 编码格式是重中之重
        resolver.setTemplateEngine(springTemplateEngine); // 和之前javaWeb阶段一样 需要使用模板引擎进行解析 所以这里也需要设定一下模板引擎
        return resolver;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){ // 配置模板解析器
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setSuffix(".html"); // 需要解析的后缀名称
        resolver.setPrefix("/WEB-INF/template"); // 需要解析的HTML页面文件存放的位置
        return resolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(@Autowired ITemplateResolver resolver){ // 配置模板引擎Bean
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(resolver); // 模板解析器 默认即可
        return engine;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // 开启默认的Servlet
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/"); // 配置静态资源的访问路径
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter());
    }
}*/
