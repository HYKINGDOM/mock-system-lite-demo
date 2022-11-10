package com.java.metaadmin.controller;

import com.java.metaadmin.producer.RocketMqProduce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rocket")
@Slf4j
public class RocketMessageController {

    @Resource
    private RocketMqProduce rocketMqProduce;

    private String topic;

    @GetMapping("/")
    public Object convertAndSendMessage() {
        //rocketMqProduce.convertAndSend();

        return null;
    }
}
