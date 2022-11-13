package com.java.meta.common.domian;

import cn.hutool.core.lang.Assert;

import java.time.LocalDateTime;

import static com.java.meta.common.util.TraceIdUtil.getTraceId;

public final class MessageObjectBuilder {


    private final MessageObject providedMessage;


    private MessageObjectBuilder(MessageObject providedMessage) {
        Assert.notNull(providedMessage, "providedMessage must not be null");
        this.providedMessage = providedMessage;
    }

    public static MessageObjectBuilder setDataMessage(Object dataMessage) {
        MessageObject messageObject = MessageObject.builder().dataMessage(dataMessage).build();
        return new MessageObjectBuilder(messageObject);
    }


    public MessageObject build() {
        this.providedMessage.setTraceId(getTraceId());
        this.providedMessage.setCurrentDateTime(LocalDateTime.now());
        return this.providedMessage;
    }

}
