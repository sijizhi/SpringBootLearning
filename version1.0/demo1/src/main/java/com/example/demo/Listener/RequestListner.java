package com.example.demo.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 20:02
 */
@WebListener
public class RequestListner implements ServletRequestListener {

    public RequestListner() {
        super();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("=======================requestDestroyed==========================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("=======================requestInitialized==========================");
    }
}
