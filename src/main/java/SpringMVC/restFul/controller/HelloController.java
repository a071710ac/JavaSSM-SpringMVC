package SpringMVC.restFul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author YXS
 * @PackageName: SpringMVC.restFul.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/11 10:42
 */
@Controller
public class HelloController {

    @RequestMapping("/index1/{str}")
    public String index1_1(@PathVariable String str) {

        System.out.println(str);
        return "index";

    }
    @RequestMapping("/index2/{str}")
    public String index1_2(@PathVariable("str") String text) {

        System.out.println(text);
        return "index";

    }

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") String text) {

        System.out.println("获取用户: " + text);
        return "index";

    }
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String post(String username) {

        System.out.println("添加用户: " + username);
        return "index";

    }
    @RequestMapping(value = "/index/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String text) {

        System.out.println("删除用户: " + text);
        return "index";

    }
    @RequestMapping(value = "/index", method = RequestMethod.PUT)
    public String put(String username) {

        System.out.println("修改用户: " + username);
        return "index";

    }

}
