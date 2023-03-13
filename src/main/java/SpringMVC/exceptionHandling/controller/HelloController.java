package SpringMVC.exceptionHandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YXS
 * @PackageName: SpringMVC.exceptionHandling.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/12 19:00
 */
@Controller
public class HelloController {

    @RequestMapping("/index1")
    public String index1() {

        System.out.println();
        if (true) throw new RuntimeException("你的氪金力度不足 无法访问");
        return "test1/index";

    }

}
