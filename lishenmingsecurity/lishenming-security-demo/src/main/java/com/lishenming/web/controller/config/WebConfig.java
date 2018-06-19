package com.lishenming.web.controller.config;

import com.lishenming.filter.TimeFilter;
import com.lishenming.web.controller.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 异步开启拦截器
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

    /**
     * 两种异步的方式，
     * registerCallableInterceptors
     * registerDeferredResultInterceptors
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerDeferredResultInterceptors();
        //configurer.registerCallableInterceptors()
        //configurer.setTaskExecutor()//自定义线程池，这个可以重用，spring(DeferredResult)自带的不会重用DeferredResult
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     *
     * @return
     * 这个配置，可以自定义路径，拦截器在指定的路径起作用，
     * 但是也可以在TimeFilter上面加入注解@conponet，也可以将拦截器加入到容器中，但是不能自定义
     */
//    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }




}
