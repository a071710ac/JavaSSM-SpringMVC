package SpringMVC.springmvc4.controller;

import SpringMVC.springmvc4.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*@Controller
public class MainController {

    /*@RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request){
        System.out.println("接收到请求参数: " + request.getParameterMap().keySet());
        return new ModelAndView("/index");
    }*/

    /*@RequestMapping(value = "/index")
    public ModelAndView index(HttpSession session){
        System.out.println(session.getAttribute("test"));
        session.setAttribute("test", "鸡你太美");
        return new ModelAndView("/index");
    }*/

    /*@RequestMapping(value = "/index")
    public String index(User user){
        System.out.println("接收到请求参数: " + user);
        return "/index";
    }*/

    /*@RequestMapping(value = "/index")
    public ModelAndView index(HttpServletResponse response,
                              @CookieValue(value = "test", required = false) String test){

        System.out.println("获取到Cookie值为: " + test);
        response.addCookie(new Cookie("test", "yxsnb"));
        return new ModelAndView("/index");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(@SessionAttribute(value = "test", required = false)String test,
                              HttpSession session){

        session.setAttribute("test", "xxxx");
        System.out.println(test);
        return new ModelAndView("/index");
    }

}*/
