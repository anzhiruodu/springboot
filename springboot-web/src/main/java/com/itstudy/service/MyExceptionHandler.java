package com.itstudy.service;

import com.itstudy.exception.UserNotExitsException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class MyExceptionHandler {

    //浏览器和服务器返回的都是json字符串
//    @ResponseBody
//    @ExceptionHandler(value = UserNotExitsException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code" , "user.notexits");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(value = UserNotExitsException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        /**
         * Integer statusCode = (Integer) request
         * 				.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code" , "user.notexits");
        map.put("message","用户不存在");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
