package com.lishenming.web.controller;

import com.lishenming.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 *@ControllerAdvice 这个注解是处理其他的控制器抛出的异常
 * @ExceptionHandler(UserNotExistException.class)处理什么类型的异常
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//返回状态码，服务器异常500
    public Map<String , Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String , Object> map = new HashMap<>();
        map.put("id",ex.getId());
        map.put("message",ex.getMessage());
        return map;

    }

}
