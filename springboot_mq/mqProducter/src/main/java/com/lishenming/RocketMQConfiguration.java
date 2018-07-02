package com.lishenming;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Value("${rocketmq.instanceName}")
    private String instanceName;

    private DefaultMQProducer defaultMQProducer;

    @Bean()
    public DefaultMQProducer defaultMQProducer() {
        try {
            DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producerGroup);
            defaultMQProducer.setNamesrvAddr(nameSrvAddr);
            defaultMQProducer.setInstanceName(instanceName);
            defaultMQProducer.setVipChannelEnabled(false);

            defaultMQProducer.start();
            logger.debug("defaultMQProducer 初始化完成！！！");
            this.defaultMQProducer = defaultMQProducer;
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        logger.debug("Producer Started.");
        return defaultMQProducer;
    }

    @PreDestroy
    public void destroy() {
        if (this.defaultMQProducer != null) {
            defaultMQProducer.shutdown();
        }
    }
}
