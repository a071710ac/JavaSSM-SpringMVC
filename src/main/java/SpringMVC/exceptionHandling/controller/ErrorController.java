package SpringMVC.exceptionHandling.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author YXS
 * @PackageName: SpringMVC.exceptionHandling.config
 * @ClassName: ErrorController
 * @Desription:
 * @date 2023/3/12 19:05
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String error(Exception e, Model model) {

        e.printStackTrace();
        model.addAttribute("e", e);
        return "error";

    }

}
