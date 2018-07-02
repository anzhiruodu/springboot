package com.lishenming;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class application {


    @Autowired
    private RocketMQMessageSender rocketMQMessageSender;

    public static void main(String[] args) {

        SpringApplication.run(application.class);
//        synchronized (RocketMQMessageSender.class) {
//            while (RUNNING.get()) {
//                try {
//                    RocketMQMessageSender.class.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("beans.xml");
//        applicationContext1.start();

//        RocketMQMessageSender rocketMQMessageSender = new RocketMQMessageSender();
    }

    @PostConstruct
    public void start(){
//        People people = new People();
//        people.setColor("yellow");
//        people.setCountry("china");
//        people.setEthnic("zhonghua");
//        String string = JSONObject.toJSONString(people);
//        rocketMQMessageSender.sendMessage("log","log1",string.getBytes());

    }
}
