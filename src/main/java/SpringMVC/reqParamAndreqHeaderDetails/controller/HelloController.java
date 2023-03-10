package SpringMVC.reqParamAndreqHeaderDetails.controller;

import SpringMVC.reqParamAndreqHeaderDetails.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.reqParamAndreqHeaderDetails.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/9 23:41
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index1")
    public ModelAndView index1(@RequestParam("username") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index2")
    public ModelAndView index2(@RequestParam(value = "username", required = false) String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index3")
    public ModelAndView index3(@RequestParam(value = "username", required = false, defaultValue = "Coke") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index4")
    public ModelAndView index4(HttpServletRequest request) {

        System.out.println("接收到请求参数: " + request.getParameterMap().keySet());
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index5")
    public ModelAndView index5(HttpSession session) {

        System.out.println(session.getAttribute("test"));
        session.setAttribute("test", "鸡你太美");
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index6")
    public ModelAndView index6(User user) {

        System.out.println("获取到cookie值为: " + user);
        return new ModelAndView("index");

    }

}
