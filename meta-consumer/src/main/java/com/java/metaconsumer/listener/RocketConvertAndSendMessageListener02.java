package com.java.metaconsumer.listener;

import com.alibaba.fastjson.JSONObject;
import com.java.metaconsumer.config.RocketMqBizConstant;
import com.java.metaconsumer.config.RocketMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

import java.util.concurrent.TimeUnit;

/**
 * 相同实体类消费监听器
 * 同一个topic和tag可以有多个监听器，相当于同一个group下的消费者集群
 * 消息只会被其中一个进行消费
 *
 */
@Slf4j
// @Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG
)
public class RocketConvertAndSendMessageListener02 implements RocketMQListener<Message> {

    /**
     * 普通消息
     */
    @Override
    public void onMessage(Message message) {
        String messageMessage = message.getKeys();
        System.out.println(messageMessage);

        byte[] messageBody = message.getBody();
        Object toJSON = JSONObject.parse(messageBody);

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
