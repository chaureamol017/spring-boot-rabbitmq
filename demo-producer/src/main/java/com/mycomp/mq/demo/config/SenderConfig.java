package com.mycomp.mq.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("MyQueue", true);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue("SimpleMessageQueue", true);
    }

}
