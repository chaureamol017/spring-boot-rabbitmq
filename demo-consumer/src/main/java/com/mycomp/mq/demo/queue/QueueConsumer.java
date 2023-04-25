package com.mycomp.mq.demo.queue;

import com.mycomp.mq.demo.helper.ExecutionDelay;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class QueueConsumer {
    Logger logger = Logger.getLogger(QueueConsumer.class.getName());
    @Autowired private ExecutionDelay executionDelay;

    @RabbitListener(queues = {"MyQueue"})
    public void receive(@Payload String fileBody) {
        logger.log(Level.INFO, "Message: " + fileBody);

        final int delay = RandomUtils.nextInt(7, 10);

        executionDelay.forSec(delay);
    }
}
