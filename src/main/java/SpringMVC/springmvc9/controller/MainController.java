package SpringMVC.springmvc9.controller;

import SpringMVC.springmvc4.entity.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
public class MainController {

    /*@RequestMapping(value = "/index")
    public String index(){
        JSONObject object = new JSONObject();
        object.put("name", "杰哥");
        object.put("age", 18);
        // System.out.println(object.toJSONString()); // 以JSON格式输出JSONObject字符串
        return "/index";
    }
    @RequestMapping(value = "/home", produces = "application/json")
    @ResponseBody
    public User home(){
        User user = new User();
        user.setUsername("yxs");
        user.setPassword("123456");
        return user;
    }*/

    /*@RequestMapping(value = "/index")
    public String index(){
        JSONObject object = new JSONObject();
        object.put("name", "杰哥");
        object.put("age", 18);
        JSONArray array = new JSONArray();
        array.add(object);
        System.out.println(array.toJSONString());
        return "/index";
    }

}*/
