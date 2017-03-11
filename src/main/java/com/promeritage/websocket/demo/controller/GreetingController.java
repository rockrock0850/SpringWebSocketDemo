package com.promeritage.websocket.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetingController {

	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public @ResponseBody ModelAndView client(HttpServletRequest request) throws Exception {
		return new ModelAndView("/client");
	}
	
	@RequestMapping(value = "/client2", method = RequestMethod.GET)
	public @ResponseBody ModelAndView client2(HttpServletRequest request) throws Exception {
		return new ModelAndView("/client2");
	}
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(message.getName());
    }
	
    @MessageMapping("/hello2")
    @SendTo("/topic/greetings2")
    public Greeting greeting2(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(message.getName());
    }
}
