package com.javaprogram.auto.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class, excludeName = "SecurityAutoConfiguration")
public class AutoConfigureApplication {

	@Bean
	public Message getMessage() {
		return new Message();
	}

	@Bean
	public MessageController getMessageController() {
		return new MessageController();
	}

	public static void main(String[] args) {
		SpringApplication.run(AutoConfigureApplication.class, args);

	}

}

class Message {

	public String getMessage() {
		return "New message generated";
	}

}

@Controller
class MessageController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Message msg;

	@PostMapping("/send")
	public void messageSender() {

		String messag = msg.getMessage();
		logger.info("Message : " + messag);
		logger.info("Message sent....");

	}
}