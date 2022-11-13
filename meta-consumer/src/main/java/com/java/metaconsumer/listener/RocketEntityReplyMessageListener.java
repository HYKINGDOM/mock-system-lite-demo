package com.java.metaconsumer.listener;

import com.alibaba.fastjson.JSONObject;
import com.java.meta.common.domian.MessageObject;
import com.java.metaconsumer.config.RocketMqBizConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 实体类带响应消费监听器
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = RocketMqBizConstant.SYNC_SOURCE_TOPIC, consumerGroup = RocketMqBizConstant.SOURCE_GROUP, selectorExpression = RocketMqBizConstant.SYNC_SOURCE_TAG)
public class RocketEntityReplyMessageListener implements RocketMQReplyListener<MessageObject, String> {

    /**
     * 带回复消息，当未回复时发送者sendAndReceive将一直等，直到超时
     */
    @Override
    public String onMessage(MessageObject messageObject) {
        try {
            log.info("RocketEntityReplyMessageListener onMessage 收到消息，消息内容：{}", JSONObject.toJSON(messageObject));
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "休眠3s, 返回提示";
    }
}
