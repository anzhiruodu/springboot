package com.lishenming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * basicErrorController,springboot处理异常错误的机制
 * @RequestMapping(produces = "text/html")请求头如果是html的
 *浏览器：Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*
 *
 */



@SpringBootApplication
//@RestController
public class DemoApplication {

    public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @GetMapping("/hello")
//    public String  hello(){
//     return "hello mySecurity";
//    }
}
