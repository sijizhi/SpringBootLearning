package com.example.demo.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 19:39
 */
@WebServlet(urlPatterns = "/testServlet",name = "TestServlet")
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("my servlet");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
