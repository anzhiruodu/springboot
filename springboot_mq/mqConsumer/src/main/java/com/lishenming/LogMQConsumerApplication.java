package com.lishenming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * RocketMQ 日志消息消费程序启动类
 *
 * @author Charles
 * @email amwfhv@yeah.net
 * @create at 2018/2/1 20:24
 **/
@SpringBootApplication
public class LogMQConsumerApplication {

  public static final AtomicBoolean RUNNING = new AtomicBoolean(true);

  public static void main(String[] args) {

    SpringApplication.run(LogMQConsumerApplication.class);
    synchronized (LogMQConsumerApplication.class) {
      while (RUNNING.get()) {
        try {
          LogMQConsumerApplication.class.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
