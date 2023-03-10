package SpringMVC.cookieValueAndsessionAttrbutieDetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @author YXS
 * @PackageName: SpringMVC.cookieValueAndsessionAttrbutieDetails.config
 * @ClassName: WebConfiguration
 * @Desription:
 * @date 2023/3/10 9:16
 */
@Configuration
@EnableWebMvc
@ComponentScan("SpringMVC.cookieValueAndsessionAttrbutieDetails.controller")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(springTemplateEngine);
        return viewResolver;

    }
    @Bean
    public SpringTemplateEngine springTemplateEngine(ITemplateResolver resolver) {

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(resolver);
        return null;

    }
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setPrefix("/");
        return resolver;

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

}
