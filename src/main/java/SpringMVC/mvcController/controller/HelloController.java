package SpringMVC.mvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/index1")
    public ModelAndView index1() {
        return new ModelAndView("index");
    }

    @RequestMapping("/index2")
    public ModelAndView index2() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModel().put("name", "啊这");
        return modelAndView;

    }

    @RequestMapping("/index3")
    public String index3(Model model) {

        model.addAttribute("name", "yyds");
        return "index";

    }


}
