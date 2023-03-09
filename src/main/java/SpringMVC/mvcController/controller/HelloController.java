package SpringMVC.mvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.mvcController.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/9 15:27
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/")
    public ModelAndView index() {

    }

}
