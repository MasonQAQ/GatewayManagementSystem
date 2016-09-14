package gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangyue on 2016/9/10.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    public void addInterceptors (InterceptorRegistry registry){
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o) throws Exception {
                System.out.println("拦截检查："+httpServletRequest.getSession().getAttribute("username"));
                if(null!=httpServletRequest.getSession().getAttribute("username")){
                   return true;
                }
                httpServletResponse.sendRedirect("/login");
                return false;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

            }
        }).addPathPatterns("/main");
    }
}
