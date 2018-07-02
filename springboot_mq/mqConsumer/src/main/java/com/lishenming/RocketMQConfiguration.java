package com.lishenming;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;


@Configuration
@PropertySource(value = "classpath:/rocketmq_${spring.profiles.active}.properties")
public class RocketMQConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQConfiguration.class);
    @Value("${rocketmq.namesrvAddr}")
    private String nameSrvAddr;

    @Value("${rocketmq.producerGroup}")
    private String producerGroup;
    @Value("${rocketmq.consumerGroup}")
    private String consumerGroup;

    @Autowired
    @Qualifier("resimLogMessageListener")
    private ResimLogMessageListener resimLogMessageListener;

    private DefaultMQPushConsumer defaultMQPushConsumer;

    @Bean(name = "operationMQPushConsumer")
    public DefaultMQPushConsumer operationMQPushConsumer(){
        logger.info("RocketMQ operationMQPushConsumer Starting ....");
        logger.info("*  NameServerAddress is {} , consumerGroup is {}", nameSrvAddr, consumerGroup);
        this.defaultMQPushConsumer = new DefaultMQPushConsumer(consumerGroup);
        this.defaultMQPushConsumer.setNamesrvAddr(nameSrvAddr);
        try {
            this.defaultMQPushConsumer.subscribe("log","*");
            this.defaultMQPushConsumer.registerMessageListener(resimLogMessageListener);
            this.defaultMQPushConsumer.start();

        } catch (MQClientException e) {
            logger.error("RocketMQ operationMQPushConsumer Start  Exception ! e={}", e);
        }
        logger.info("RocketMQ operationMQPushConsumer Start Success!");
        return this.defaultMQPushConsumer;
    }

    @PreDestroy
    public void destroy() {
        if (defaultMQPushConsumer != null) {
            defaultMQPushConsumer.shutdown();
        }
    }

}
