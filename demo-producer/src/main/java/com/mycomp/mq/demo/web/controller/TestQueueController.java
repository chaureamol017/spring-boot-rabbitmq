package com.mycomp.mq.demo.web.controller;

import com.mycomp.mq.demo.model.MessagePayload;
import com.mycomp.mq.demo.queue.QueueSender;
import com.mycomp.mq.demo.util.MessageUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestQueueController {
    @Autowired private QueueSender queueSender;

    @GetMapping
    public String send(){
        final String payload = RandomStringUtils.randomAlphanumeric(40, 70);
        queueSender.send(payload);
        return "ok. done";
    }

    @GetMapping(path = "/message")
    public String sendMessage(){
        MessagePayload payload = MessageUtil.createRandom();
        queueSender.send(payload);
        return "ok. done";
    }

}
