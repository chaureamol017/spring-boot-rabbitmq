package com.mycomp.mq.demo.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycomp.mq.demo.model.MessagePayload;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {
    @Autowired private RabbitTemplate rabbitTemplate;
    @Autowired private Queue myQueue;
    @Autowired private Queue messageQueue;

    public void send(final String payload) {
        rabbitTemplate.convertAndSend(this.myQueue.getName(), payload);
    }

    public void send(final MessagePayload payload) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(payload);
            rabbitTemplate.convertAndSend(this.messageQueue.getName(), json);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
