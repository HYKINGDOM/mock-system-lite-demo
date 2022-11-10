package com.java.metaconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;

import java.util.concurrent.TimeUnit;

/**
 * 实体类带响应消费监听器
 *
 */
@Slf4j
// @Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG
)
public class RocketEntityReplyMessageListener implements RocketMQReplyListener<RocketMqMessage, String> {

    /**
     * 带回复消息，当未回复时发送者sendAndReceive将一直等，直到超时
     */
    @Override
    public String onMessage(RocketMqMessage message) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "休眠3s才返回";
    }
}
