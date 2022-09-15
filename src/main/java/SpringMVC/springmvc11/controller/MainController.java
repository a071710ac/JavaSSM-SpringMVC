package SpringMVC.springmvc11.controller;

import org.apache.commons.io.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.annotation.Repeatable;

/*@Controller
public class MainController {

    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody()
    public String upload(@RequestParam CommonsMultipartFile file) throws IOException {
        File fileObj = new File("test.jpg");
        file.transferTo(fileObj);
        System.out.println("用户上传的文件已保存到: " + fileObj.getAbsolutePath());
        return "文件上传成功 ";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public void download(HttpServletResponse response){
        response.setContentType("multipart/form-data");
        try (OutputStream stream = response.getOutputStream();
             InputStream inputStream = new FileInputStream("test.jpg")){
             IOUtils.copy(inputStream, stream);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}*/
