package com.lishenming.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * filter和interceptor的执行顺序：
 * 先filter再interceptor
 * aspect：拿不到http请求和相应的对象，可以拿到参数的值，
 * filter拿不到请求的参数的值，只有http请求
 * interceptor拿不到请求方法的参数的值，拿的到方法
 * 拦截器需要在spring中WebMvcConfigurerAdapter注册才能使用
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
