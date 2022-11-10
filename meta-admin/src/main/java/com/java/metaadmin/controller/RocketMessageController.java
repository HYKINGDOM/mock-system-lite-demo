package com.java.metaadmin.controller;

import com.java.metaadmin.config.CommonConstant;
import com.java.metaadmin.config.RocketMqBizConstant;
import com.java.metaadmin.domian.RocketMqMessage;
import com.java.metaadmin.producer.RocketMqProduce;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/rocket")
@Slf4j
public class RocketMessageController {

    @Resource
    private RocketMqProduce rocketMqProduce;

    private String topic;

    @GetMapping("/convertAndSendMessage")
    public Object convertAndSendMessage() {
        MDC.put(CommonConstant.DEFAULT_TRACE_ID,"wwwwwwwwwwwwwwwwwwwww22222222222222");

        RocketMqMessage rocketMqMessage = RocketMqMessage.builder().id(123123412L).message("message").version("qweqw").currentDate(LocalDate.now()).currentDateTime(LocalDateTime.now()).build();
        rocketMqProduce.convertAndSend(RocketMqBizConstant.SOURCE_TOPIC,RocketMqBizConstant.SOURCE_TAG,rocketMqMessage);

        return null;
    }
}
