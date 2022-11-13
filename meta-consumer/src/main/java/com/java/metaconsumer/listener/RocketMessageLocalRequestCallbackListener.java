package com.java.metaconsumer.listener;

import com.alibaba.fastjson.JSONObject;
import com.java.meta.common.domian.MessageObject;
import com.java.metaconsumer.config.RocketMqBizConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 消费监听器
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.ASYNC_SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.ASYNC_SOURCE_TAG
)
public class RocketMessageLocalRequestCallbackListener implements RocketMQLocalRequestCallback<MessageObject> {


    @Override
    public void onSuccess(MessageObject messageObject) {
        try {
            log.info("RocketMessageLocalRequestCallbackListener onSuccess 收到消息，消息内容：{}", JSONObject.toJSON(messageObject));
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onException(Throwable e) {
        try {
            log.info("RocketMessageLocalRequestCallbackListener onException 收到消息，消息内容：{}", JSONObject.toJSON(e.getMessage()));
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException interruptedException) {
            log.error(interruptedException.getMessage());
        }
    }
}
