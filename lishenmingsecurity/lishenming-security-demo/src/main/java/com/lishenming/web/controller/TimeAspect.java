package com.lishenming.web.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切片
 * spring官网11章aop切片；详细讲解
 * 可以拿到传入的参数的值，，
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.lishenming.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect start");
        Object proceed = pjp.proceed();//返回的是什么类型，那么就可以强转为什么类型，例如返回的是map，
        System.out.println("aspect end");

        return null;
    }

}
