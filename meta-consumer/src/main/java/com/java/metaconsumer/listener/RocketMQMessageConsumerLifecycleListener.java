package com.java.metaconsumer.listener;

import com.alibaba.fastjson.JSONObject;
import com.java.metaconsumer.config.RocketMqBizConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 循环拉取监听器监听器
 */
@Slf4j
//@Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.PUSH_SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.PUSH_SOURCE_TAG
)
public class RocketMQMessageConsumerLifecycleListener implements RocketMQPushConsumerLifecycleListener {


    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        try {
            log.info("RocketMQMessageConsumerLifecycleListener prepareStart 收到消息，消息内容：{}", JSONObject.toJSON(consumer));
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
