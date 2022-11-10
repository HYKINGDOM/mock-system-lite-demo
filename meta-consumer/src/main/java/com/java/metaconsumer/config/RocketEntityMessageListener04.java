package com.java.metaconsumer.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * String实体类消费监听器
 *
 */
@Slf4j
// @Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG
)
public class RocketEntityMessageListener04 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到消息【{}】", JSONObject.toJSON(message));
    }
}
