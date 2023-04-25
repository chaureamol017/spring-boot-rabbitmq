package com.mycomp.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApiApplication.class, args);
	}

}
