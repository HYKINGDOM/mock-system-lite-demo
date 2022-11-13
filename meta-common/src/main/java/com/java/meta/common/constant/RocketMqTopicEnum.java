package com.java.meta.common.constant;


import lombok.Getter;

@Getter
public enum RocketMqTopicEnum {

    CONVERT_AND_SEND_Message("rocketmq_source_code_topic", "rocketmq_source_code_group", "rocketmq_source_code_tag"),
    SYNC_SEND_MESSAGE("rocketmq_sync_send_message_topic", "rocketmq_source_code_group", "rocketmq_sync_send_message_tag"),

    SYNC_ASYNC_MESSAGE("rocketmq_async_send_message_topic", "rocketmq_source_code_group", "rocketmq_async_send_message_tag");

    private String topic;


    private String group;


    private String tag;


    RocketMqTopicEnum(String topic, String group, String tag) {
        this.topic = topic;
        this.group = group;
        this.tag = tag;
    }
}
