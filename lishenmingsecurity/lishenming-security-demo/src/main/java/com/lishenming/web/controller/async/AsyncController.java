package com.lishenming.web.controller.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder deferredResultHolder;

    @GetMapping("/order")
    public DeferredResult<String> order() throws InterruptedException {
        logger.info("主线程开始");
        String order  = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(order);
        DeferredResult<String> deferredResult = new DeferredResult();
        deferredResultHolder.getMap().put(order,deferredResult);
        logger.info("主线程结束");
        return deferredResult;
    }


}
