package com.mycomp.mq.demo.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycomp.mq.demo.helper.ExecutionDelay;
import com.mycomp.mq.demo.model.MessagePayload;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MessageConsumer {
    Logger logger = Logger.getLogger(MessageConsumer.class.getName());
    @Autowired private ExecutionDelay executionDelay;

    @RabbitListener(queues = {"SimpleMessageQueue"})
    public void receive(@Payload String queueData) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        final MessagePayload payload = mapper.readValue(queueData, MessagePayload.class);

        logger.log(Level.INFO, "Payload: " + payload);

        final int delay = RandomUtils.nextInt(5, 7);
        logger.log(Level.INFO, "Sleeping for sec: " + delay);

        executionDelay.forSec(delay);
    }
}
