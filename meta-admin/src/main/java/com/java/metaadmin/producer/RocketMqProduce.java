package com.java.metaadmin.producer;

import com.alibaba.fastjson.JSON;
import com.java.metaadmin.config.CommonConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.slf4j.MDC;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息的生产者
 *
 * @author 胡毅
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RocketMqProduce {

    private final RocketMQTemplate rocketMessageTemplate;

    /**
     * 发送消息并没有返回值
     * @param topic
     * @param tag
     * @param object
     */
    public void convertAndSend(String topic, String tag, Object object) {
        String destination = topic + ":" + tag;

        Message<Object> buildMessage = MessageBuilder.withPayload(object)
                // 在header重视设置traceID
                .setHeader(RocketMQHeaders.KEYS, MDC.get(CommonConstant.DEFAULT_TRACE_ID))
                .setHeader(CommonConstant.DEFAULT_TRACE_ID, MDC.get(CommonConstant.DEFAULT_TRACE_ID)).build();

        rocketMessageTemplate.convertAndSend(destination, buildMessage);
        log.info("destination = {},convertAndSend", destination);
    }

    /**
     * 同步消息
     * @param topic
     * @param tag
     * @param object
     */
    public void syncSend(String topic, String tag, Object object) {
        String destination = topic + ":" + tag;
        long timeout = 100L;

        Message<Object> buildMessage = MessageBuilder.withPayload(object)
                // 在header重视设置traceID
                .setHeader(RocketMQHeaders.KEYS, MDC.get(CommonConstant.DEFAULT_TRACE_ID))
                .setHeader(CommonConstant.DEFAULT_TRACE_ID, MDC.get(CommonConstant.DEFAULT_TRACE_ID)).build();

        SendResult result = rocketMessageTemplate.syncSend(destination, buildMessage, timeout);
        log.info("destination = {},syncSend sendStatus = {}", destination, result.getSendStatus());
    }

    /**
     * 异步消息
     * @param topic
     * @param tag
     * @param object
     */
    public void asyncSend(String topic, String tag, Object object) {
        String destination = topic + ":" + tag;
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("异步消息成功,执行方法");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("异步消息失败,执行方法");
            }
        };
        rocketMessageTemplate.asyncSend(destination, JSON.toJSONString(object), callback);
    }
}
