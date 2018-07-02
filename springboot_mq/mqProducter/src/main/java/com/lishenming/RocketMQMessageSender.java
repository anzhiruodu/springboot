package com.lishenming;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RocketMQMessageSender {


    @Autowired
    private DefaultMQProducer defaultMQProducer;


    //发送信息
    public boolean sendMessage(String topic, String tags, byte[] body) {
        if (defaultMQProducer == null) {
            return false;
        }
        if (body != null) {
            Message msg = new Message(topic, tags, body);
            try {
                SendResult sendResult = defaultMQProducer.send(msg);
                return (sendResult.getSendStatus() == SendStatus.SEND_OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
