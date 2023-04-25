package com.mycomp.mq.demo.queue;

import com.mycomp.mq.demo.model.MessagePayload;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {
    @Autowired private AmqpTemplate amqpTemplate;
    @Autowired private AmqpTemplate amqpMessageConverterTemplate;
    @Autowired private Queue myQueue;
    @Autowired private Queue messageQueue;

    public void send(final String payload) {
        amqpTemplate.convertAndSend(this.myQueue.getName(), payload);
    }

    public void send(final MessagePayload payload) {
        amqpMessageConverterTemplate.convertAndSend(this.messageQueue.getName(), payload);
    }
}
