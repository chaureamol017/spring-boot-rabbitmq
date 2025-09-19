package com.mycomp.mq.demo.queue;

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
    public void receive(@Payload MessagePayload payload) {
        logger.log(Level.INFO, "SimpleMessageQueue: Payload: " + payload);

        final int delay = RandomUtils.nextInt(5, 7);
        executionDelay.forSec(delay);
    }
}
