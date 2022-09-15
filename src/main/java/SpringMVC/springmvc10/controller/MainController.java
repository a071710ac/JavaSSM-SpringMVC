package SpringMVC.springmvc10.controller;

import SpringMVC.springmvc4.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
public class MainController {

    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
    @RequestMapping(value = "/data", produces = "application/json")
    @ResponseBody
    public User user(){
        User user = new User();
        user.setUsername("叶玄朔");
        user.setPassword("12345678");
        return user;
    }

    @RequestMapping(value = "/submit")
    @ResponseBody
    public String submit(@RequestBody User user){
        System.out.println("接收到数据: " + user);
        return "{\"success\": true}";
    }

}*/
