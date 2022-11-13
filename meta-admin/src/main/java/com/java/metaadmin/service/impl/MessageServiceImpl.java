package com.java.metaadmin.service.impl;

import com.java.meta.common.constant.RocketMqTopicEnum;
import com.java.meta.common.domian.MessageObject;
import com.java.meta.common.domian.MessageObjectBuilder;
import com.java.metaadmin.producer.RocketMqProduce;
import com.java.metaadmin.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {


    private final RocketMqProduce rocketMqProduce;


    @Override
    public void convertAndSend(Object object) {
        RocketMqTopicEnum sendMessage = RocketMqTopicEnum.CONVERT_AND_SEND_Message;
        MessageObject messageObject = MessageObjectBuilder.setDataMessage(object).build();
        rocketMqProduce.convertAndSend(sendMessage.getTopic(), sendMessage.getTag(), messageObject);
    }

    @Override
    public void syncSend(Object object) {
        RocketMqTopicEnum sendMessage = RocketMqTopicEnum.SYNC_SEND_MESSAGE;
        MessageObject messageObject = MessageObjectBuilder.setDataMessage(object).build();
        rocketMqProduce.syncSend(sendMessage.getTopic(), sendMessage.getTag(), messageObject);
    }

    @Override
    public void asyncSend(Object object) {
        RocketMqTopicEnum sendMessage = RocketMqTopicEnum.SYNC_ASYNC_MESSAGE;
        MessageObject messageObject = MessageObjectBuilder.setDataMessage(object).build();
        rocketMqProduce.asyncSend(sendMessage.getTopic(), sendMessage.getTag(), messageObject);
    }
}
