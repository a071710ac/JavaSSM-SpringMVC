package SpringMVC.springmvc2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Controller
public class MainController {

    // http://localhost:3306/mvc/index
    /*@RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }*/

    /*@RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModel().put("name", "啊这");
        return modelAndView;
    }*/

    /*@RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("name", "yyds"); // 这里不仅仅可以是Model 还可以是Map ModelMap
        return "/index";
    }

}*/
