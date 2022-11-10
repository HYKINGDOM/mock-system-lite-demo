package com.java.metaconsumer.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 消息消费需要使用注解RocketMQMessageListener进行监听
 *
 * electorExpression = "*"：指定tag，*表示监听所有tag
 * consumerGroup：指定消费组
 *
 * 一般可以将consumerGroup和selectorExpression设置为一样
 *
 *
 * topic：指定topic，topic至关重要，通常表示某一类业务或者平台，例如订单topic、仓储topic
 *
 *
 * 监听器注解类需要实现RocketMQListener接口，泛型为发送消息时的类型
 *
 * org.apache.rocketmq.spring.core.RocketMQListener
 *
 *
 * 监听器实例
 *
 * 作者：TianXinCoord
 * 链接：https://juejin.cn/post/7104445507912597517
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 实体类消费监听器
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = RocketMqBizConstant.SOURCE_TOPIC,
        consumerGroup = RocketMqBizConstant.SOURCE_GROUP,
        selectorExpression = RocketMqBizConstant.SOURCE_TAG
)
public class RocketEntityMessageListener implements RocketMQListener<RocketMqMessage> {

    /**
     * 普通消息
     */
    @Override
    public void onMessage(RocketMqMessage message) {
        log.info("收到消息【{}】", JSONObject.toJSON(message));
        try {
            // 方法执行完成之后会自动进行进行ack，后续会分享源码解读
            TimeUnit.SECONDS.sleep(3);
            // 出现异常，将会自动进入重试队列
            // int ex = 10 / 0;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("休眠了3s后消费完成");
    }
}
