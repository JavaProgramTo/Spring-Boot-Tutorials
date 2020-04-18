package com.javaprogram.custom.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import com.javaprogram.springbootapp.SpringBootAppApplication;

@SpringBootApplication(scanBasePackages = "com.javaprogram.custom.errors")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class CustomErrorApplication {

	private static Logger logger = LoggerFactory.getLogger(CustomErrorApplication.class);

	public static void main(String[] args) {
		logger.info("Container started.....");
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}
