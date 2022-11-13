package com.java.metaadmin.controller;

import cn.hutool.core.util.RandomUtil;
import com.java.meta.common.domian.RocketMqMessage;
import com.java.meta.common.util.TraceIdUtil;
import com.java.metaadmin.config.RocketMqBizConstant;
import com.java.metaadmin.producer.RocketMqProduce;
import com.java.metaadmin.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/rocket")
@Slf4j
@RequiredArgsConstructor
public class RocketMessageController {

    private final RocketMqProduce rocketMqProduce;

    private final MessageService messageService;


    @GetMapping("/convertAndSendMessage")
    public Object convertAndSendMessage() {
        TraceIdUtil.generateTraceId();
        RocketMqMessage rocketMqMessage = RocketMqMessage.builder().id(123123412L).message("message").version("qweqw").currentDate(LocalDate.now()).currentDateTime(LocalDateTime.now()).build();
        rocketMqProduce.convertAndSend(RocketMqBizConstant.SOURCE_TOPIC, RocketMqBizConstant.SOURCE_TAG, rocketMqMessage);
        return null;
    }


    @GetMapping("/noReturnValue")
    public Object noReturnValue() {
        TraceIdUtil.generateTraceId();
        RocketMqMessage rocketMqMessage = RocketMqMessage.builder()
                .id(RandomUtil.randomLong(8))
                .message("noReturnValue")
                .version(RandomUtil.randomString(8))
                .currentDate(LocalDate.now())
                .currentDateTime(LocalDateTime.now()).build();
        messageService.convertAndSend(rocketMqMessage);
        return null;
    }


    @GetMapping("/hasReturnValue")
    public Object hasReturnValue() {
        TraceIdUtil.generateTraceId();
        RocketMqMessage rocketMqMessage = RocketMqMessage.builder()
                .id(RandomUtil.randomLong(8))
                .message("hasReturnValue")
                .version(RandomUtil.randomString(8))
                .currentDate(LocalDate.now())
                .currentDateTime(LocalDateTime.now()).build();
        messageService.syncSend(rocketMqMessage);
        return null;
    }

    @GetMapping("/asyncReturnValue")
    public Object asyncReturnValue() {
        TraceIdUtil.generateTraceId();
        RocketMqMessage rocketMqMessage = RocketMqMessage.builder()
                .id(RandomUtil.randomLong(8))
                .message("asyncReturnValue")
                .version(RandomUtil.randomString(8))
                .currentDate(LocalDate.now())
                .currentDateTime(LocalDateTime.now()).build();
        messageService.asyncSend(rocketMqMessage);
        return null;
    }
}
