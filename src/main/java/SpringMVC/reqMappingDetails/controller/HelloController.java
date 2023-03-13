package SpringMVC.reqMappingDetails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.requestMappingDetails.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/9 19:29
 */
@Controller
public class HelloController {

    @RequestMapping( {"/index1", "/test1"} )
    public ModelAndView index1() {
        return new ModelAndView("test1/index");
    }

    @RequestMapping(value = "/index2_1", method = RequestMethod.POST)
    public ModelAndView index2_1() {
        return new ModelAndView("test1/index");
    }
    @PostMapping("/index2_2")
    public ModelAndView index2_2() {
        return new ModelAndView("test1/index");
    }

    @RequestMapping(value = "/index3_1", params = {"username", "password"})
    public ModelAndView index3_1() {
        return new ModelAndView("test1/index");
    }
    @RequestMapping(value = "/index3_2", params = {"!username", "password"})
    public ModelAndView index3_2() {
        return new ModelAndView("test1/index");
    }
    @RequestMapping(value = "/index3_3", params = {"username != test", "password=123"})
    public ModelAndView index3_3() {
        return new ModelAndView("test1/index");
    }

}
