package com.itstudy.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    //服务器创建和销毁的方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web应用启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
