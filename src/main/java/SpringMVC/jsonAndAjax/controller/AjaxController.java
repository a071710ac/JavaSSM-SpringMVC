package SpringMVC.jsonAndAjax.controller;

import SpringMVC.jsonAndAjax.entity.Student;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YXS
 * @PackageName: SpringMVC.jsonAndAjax.controller
 * @ClassName: AjaxControlller
 * @Desription:
 * @date 2023/3/12 21:45
 */
@Controller
public class AjaxController {

    @RequestMapping(value = "/index")
    public String index() {
        return "test2/index";
    }

    @ResponseBody
    @RequestMapping(value = "/data", produces = "application/json")
    public Student get() {

        Student student = new Student();
        student.setName("杰哥");
        student.setAge(18);
        return student;

    }
    @ResponseBody
    @RequestMapping(value = "/submit1")
    public String submit(Student student) {

        System.out.println("接收到前端数据: " + student);
        return "{\"success\": true}";

    }
    @ResponseBody
    @RequestMapping(value = "/submit2")
    public String submitAjax(@RequestBody JSONObject object) {

        System.out.println("接收到前端数据: " + object);
        return "{\"success\": true}";

    }

}
