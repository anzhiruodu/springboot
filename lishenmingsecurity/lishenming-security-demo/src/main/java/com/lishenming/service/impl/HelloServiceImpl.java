package com.lishenming.service.impl;

import com.lishenming.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {

        System.out.println("greeting"+name);
        return "hello "+name;
    }
}
