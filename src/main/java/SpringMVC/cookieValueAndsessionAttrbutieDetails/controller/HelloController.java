package SpringMVC.cookieValueAndsessionAttrbutieDetails.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.cookieValueAndsessionAttrbutieDetails.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/10 9:16
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index1")
    public ModelAndView index1(HttpServletResponse response,
                               @CookieValue(value = "test", required = false) String test) {

        System.out.println("获取到cookie值为: " + test);
        response.addCookie(new Cookie("test", "yxs"));
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index2")
    public ModelAndView index2(@SessionAttribute(value = "test", required = false) String test,
                               HttpSession session) {

        session.setAttribute("test", "yxs");
        System.out.println(test);
        return new ModelAndView("index");

    }

}
