package com.example.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 21:16
 */
public class LoginInterceptor implements HandlerInterceptor {

    //进入ctroller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //一般判断tocken，不符合就直接response重定向等
        String access_token=request.getParameter("access_token");
        System.out.println("===============preHandle1==============");
        return HandlerInterceptor.super.preHandle(request, response,handler );//放行
    }
    // 调用controller之后，页面渲染前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========postHandle1============");
        HandlerInterceptor.super.postHandle(request,response ,handler ,modelAndView );
    }
    //全部结束后，常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========afterCompletion1============");
        HandlerInterceptor.super.afterCompletion(request,response ,handler ,ex );
    }
}
