package SpringMVC.beanWebScope.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author YXS
 * @PackageName: SpringMVC.BeanWebScope.test
 * @ClassName: TestBean
 * @Desription:
 * @date 2023/3/10 17:12
 */
public class TestBean {

    @Bean
    @RequestScope
    public TestBean testBean() {
        return new TestBean();
    }

}
