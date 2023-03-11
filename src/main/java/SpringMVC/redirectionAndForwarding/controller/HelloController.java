package SpringMVC.redirectionAndForwarding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YXS
 * @PackageName: SpringMVC.RedirectionAndForwarding.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/10 11:22
 */
@Controller
public class HelloController {

    @RequestMapping("/index1")
    public String index1() {
        return "redirect:home1";
    }
    @RequestMapping("/home1")
    public String home1() {
        return "home";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "forward:home2";
    }
    @RequestMapping("/home2")
    public String home2() {
        return "home";
    }

}
