package SpringMVC.springmvc5.controller;

import SpringMVC.springmvc5.test.TestBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*@Controller
public class MainController {

    /*@RequestMapping(value = "/index")
    public String index(){
        return "redirect:home";
    }
    @RequestMapping("/home")
    public String home(){
        return "/home";
    }*/

    /*@RequestMapping(value = "/index")
    public String index(){
        return "forward:home";
    }
    @RequestMapping("/home")
    public String home(){
        return "/home";
    }

    @Resource
    TestBean bean;
    @RequestMapping(value = "/index")
    public String index(){
        System.out.println(bean);
        return "/index";
    }


}*/
