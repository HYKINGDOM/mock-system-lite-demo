package com.java.metaconsumer.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;

/**
 * 实体类消费监听器
 *
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG,
        // 指定消费者线程数，默认64，生产中请注意配置，避免过大或者过小
        consumeThreadMax = 5
)
public class RocketEntityMessageListener implements RocketMQListener<Message> {

    /**
     * 普通消息
     */
//    @Override
//    public void onMessage(RocketMqMessage message) {
//        String messageMessage = message.getMessage();
//        System.out.println(messageMessage);
//        log.info("RocketEntityMessageListener 收到消息【{}】", JSONObject.toJSON(message));
//        try {
//            // 方法执行完成之后才会进行ack，否则将会重试
//            TimeUnit.SECONDS.sleep(3);
//            // 制造异常，将会自动进入重试队列
//            // int ex = 10 / 0;
//        } catch (InterruptedException e) {
//            log.error(e.getMessage());
//        }
//        log.info("休眠了3s后消费完成");
//    }

    @Override
    public void onMessage(Message message) {
        String messageMessage = message.getKeys();
        System.out.println(messageMessage);

        byte[] messageBody = message.getBody();
        Object toJSON = JSONObject.parse(messageBody);

        log.info("RocketEntityMessageListener 收到消息【{}】", toJSON);
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
