package com.lishenming.web.controller.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ContextRefreshedEvent
 * spring初始化完毕的事件
 */
@Component
public class QueueListenr implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderNumber = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果" + orderNumber);
                    //"placeorder success返回的结果
                    deferredResultHolder.getMap().get(orderNumber).setResult("placeorder success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
