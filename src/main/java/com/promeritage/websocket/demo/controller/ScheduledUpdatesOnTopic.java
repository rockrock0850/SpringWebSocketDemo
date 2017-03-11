package com.promeritage.websocket.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledUpdatesOnTopic {

	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(fixedDelay = 1000)
	public void publishUpdates() {
		System.out.println("click....");
		template.convertAndSend("/topic/greetings", new Greeting("Hello! Test!"));
	}

}