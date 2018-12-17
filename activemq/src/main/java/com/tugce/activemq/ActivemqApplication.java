package com.tugce.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class ActivemqApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActivemqApplication.class, args);
		System.out.println("Activemq is loaded");

		/*
		* Install ActiveMq
		* Open http://localhost:8161/admin/queues.jsp
		*
		* */
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("tugce.queue");
	}

}

