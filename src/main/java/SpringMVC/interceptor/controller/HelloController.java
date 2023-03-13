package SpringMVC.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YXS
 * @PackageName: SpringMVC.interceptor.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/12 16:16
 */
@Controller
public class HelloController {

    @RequestMapping("/index1")
    public String index1() {

        System.out.println("我是处理");
        return "test1/index";

    }

    @RequestMapping("/index2")
    public String index2() {

        System.out.println("我是处理");
        if (true) throw new RuntimeException("");
        return "test1/index";

    }

}
