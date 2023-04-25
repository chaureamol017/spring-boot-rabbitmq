package com.mycomp.demo.web.controller;

import com.mycomp.demo.queue.QueueSender;
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
        queueSender.send("test message");
        return "ok. done";
    }

}
