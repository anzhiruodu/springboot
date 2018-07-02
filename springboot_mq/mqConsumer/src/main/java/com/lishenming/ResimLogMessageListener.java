package com.lishenming;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resim MQ日志消息监听器
 *
 * @author Charles
 * @email amwfhv@yeah.net
 * @create at 2018/2/2 09:09
 **/
@Configuration("resimLogMessageListener")
public class ResimLogMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(ResimLogMessageListener.class);
    private static final String JSON_LAYOUT_LOG_TIME_NODE = "instant";
    private static final String EPOCH_SECOND = "epochSecond";
    private static final String NANO_OF_SECOND = "nanoOfSecond";
    private static final String TIME_TO_PUT_INTO = "time";


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                    ConsumeConcurrentlyContext consumeConcurrentlyContext) {

        if (!CollectionUtils.isEmpty(list)) {
            Map<String, List<JSONObject>> tempMap = new HashMap<>();
            if (list.size() > 1) {
                list.forEach(msg -> {
                    String tag = msg.getTags();
                    String topic = msg.getTopic();
                    String json = new String(msg.getBody());
                    try {
                        JSONObject jsonObject = addTimeToGivenJsonString(json);
                        if (jsonObject != null) {
                            if (tempMap.get(msg.getTags()) == null) {
                                tempMap.put(msg.getTags(), new ArrayList<>());
                            }
                            tempMap.get(msg.getTags()).add(jsonObject);
                        }
                    } catch (Exception e) {
                        logger.warn("topic={} ,tag = {} str = {} JSON解析异常!消息丢弃 {}", topic, tag, json, e);
                    }
                });

                if (!CollectionUtils.isEmpty(tempMap)) {
                    tempMap.forEach((index, tempList) -> {
                        try {

                        } catch (Exception e) {
                            logger.warn("topic={} ,size = {} 存储到ES异常: {}", index, tempList.size(), e);
                        }
                    });
                }

            } else {
                MessageExt messageExt = list.get(0);
                String tag = messageExt.getTags();
                String topic = messageExt.getTopic();
                String json = new String(messageExt.getBody());
                try {
                    JSONObject jsonObject = addTimeToGivenJsonString(json);

                    if (jsonObject != null) {
                        logger.info(jsonObject.toJSONString());
                    }
                } catch (Exception e) {
                    logger.warn("topic={} ,tag = {} str = {} JSON解析存储异常!消息丢弃 {}", topic, tag, json, e);
                }
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }


    private JSONObject addTimeToGivenJsonString(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject logTime = jsonObject.getJSONObject(JSON_LAYOUT_LOG_TIME_NODE);

        LocalDateTime logDateTime = LocalDateTime.ofEpochSecond(
                logTime.getLongValue(EPOCH_SECOND), logTime.getIntValue(NANO_OF_SECOND),
                ZoneOffset.UTC);

        jsonObject.put(TIME_TO_PUT_INTO, logDateTime.toString());
        return jsonObject;
    }
}

