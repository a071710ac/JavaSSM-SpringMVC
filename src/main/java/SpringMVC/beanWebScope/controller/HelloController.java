package SpringMVC.beanWebScope.controller;

import SpringMVC.beanWebScope.test.TestBean;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.BeanWebScope.controller
 * @ClassName: HelloContoller
 * @Desription:
 * @date 2023/3/10 16:38
 */
@Controller
public class HelloController {

//    @Autowired
//    TestBean bean;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        System.out.println("yxs");
        return new ModelAndView("test1/index");

    }

}
