package SpringMVC.interceptor.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YXS
 * @PackageName: SpringMVC.interceptor.config
 * @ClassName: SybInterceptor
 * @Desription:
 * @date 2023/3/12 18:39
 */
/*public class SubInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[二号拦截器] 我是处理之前");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[二号拦截器] 我是处理之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[二号拦截器] 我是完成之后");
    }

}*/
