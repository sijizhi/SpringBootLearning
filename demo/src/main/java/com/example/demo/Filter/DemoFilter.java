package com.example.demo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 17:29
 */
@WebFilter(urlPatterns = "/testFilter/*",filterName = "DemoFilter")
public class DemoFilter implements Filter {

    //销毁
    public void destroy() {
        System.out.println("========Filter执行销毁=============");

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("判断是否放行");
        String username=req.getParameter("username");
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpServletRequest request=(HttpServletRequest)req;
        if ("test".equals(username)){
            chain.doFilter(req, resp);//放行
        }else{
            response.sendRedirect("/testFilter.html");
            return;
        }
    }
    public void init(FilterConfig config) throws ServletException {
        System.out.println("========Filter执行初始化=============");
    }

}
