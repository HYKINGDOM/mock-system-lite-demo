package com.java.meta.common.domian;

import cn.hutool.core.lang.Assert;
import com.java.meta.common.util.TraceIdUtil;

import java.time.LocalDateTime;

import static com.java.meta.common.util.TraceIdUtil.getTraceId;

public final class MessageObjectBuilder {


    private static MessageObject providedMessage;


    private MessageObjectBuilder(MessageObject providedMessage) {
        Assert.notNull(providedMessage, "providedMessage must not be null");
        MessageObjectBuilder.providedMessage = providedMessage;
    }

    public static MessageObjectBuilder setDataMessage(Object dataMessage) {
        MessageObject messageObject = MessageObject.builder().dataMessage(dataMessage).build();
        return new MessageObjectBuilder(messageObject);
    }


    public MessageObject build() {
        providedMessage.setTraceId(getTraceId());
        providedMessage.setCurrentDateTime(LocalDateTime.now());
        return providedMessage;
    }


    public static MessageObject parseDataMessage(Object dataMessage) {
        MessageObject messageObject = MessageObject.builder().dataMessage(dataMessage).build();
        TraceIdUtil.setTraceId(messageObject.getTraceId());
        return messageObject;
    }

}
