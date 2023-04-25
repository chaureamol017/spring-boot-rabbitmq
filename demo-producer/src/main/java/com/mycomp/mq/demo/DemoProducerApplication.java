package com.mycomp.mq.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProducerApplication.class, args);
	}

}
