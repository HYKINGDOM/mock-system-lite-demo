package com.java.metaconsumer.listener;

import com.alibaba.fastjson.JSONObject;
import com.java.meta.common.constant.RocketMqBizConstant;
import com.java.meta.common.domian.MessageObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 实体类消费监听器
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG
)
public class RocketConvertAndSendMessageListener implements RocketMQListener<MessageObject> {

    /**
     * 普通消息
     */
    @Override
    public void onMessage(MessageObject message) {
        Object messageMessage = message.getDataMessage();
        System.out.println(messageMessage);

        Object toJSON = JSONObject.toJSON(messageMessage);

        log.info("RocketConvertAndSendMessageListener 收到消息【{}】", toJSON);
        try {
            // 方法执行完成之后才会进行ack，否则将会重试
            TimeUnit.SECONDS.sleep(3);
            // 制造异常，将会自动进入重试队列
            // int ex = 10 / 0;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("休眠了3s后消费完成");
    }
}
