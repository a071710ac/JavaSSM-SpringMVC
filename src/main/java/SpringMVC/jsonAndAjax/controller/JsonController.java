package SpringMVC.jsonAndAjax.controller;

import SpringMVC.jsonAndAjax.entity.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YXS
 * @PackageName: SpringMVC.jsonAndAjax.controller
 * @ClassName: HelloController
 * @Desription:
 * @date 2023/3/12 20:27
 */
@Controller
public class JsonController {

    @RequestMapping(value = "/index1")
    public String index1() {

        JSONObject object = new JSONObject();
        object.put("name", "杰哥");
        object.put("age", 18);
        System.out.println(object.toJSONString());
        return "test1/index";

    }

    @RequestMapping(value = "/index2")
    public String index2() {

        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        object.put("name", "杰哥");
        object.put("age", 18);
        array.add(object);
        System.out.println(array.toJSONString());
        return "test1/index";

    }

    @ResponseBody
    @RequestMapping(value = "/index3", produces = "application/json")
    public String index3() {

        Student student = new Student();
        student.setName("杰哥");
        student.setAge(18);
        return JSON.toJSONString(student);

    }

    @ResponseBody
    @RequestMapping(value = "/index4", produces = "application/json")
    public Student index4() {

        Student student = new Student();
        student.setName("杰哥");
        student.setAge(28);
        return student;

    }

}
