package com.javaprogram.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class SpringBootAppApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	/*
	 * 
	 * public JettyEmbeddedServletContainerFactory
	 * jettyEmbeddedServletContainerFactory() { JettyEmbeddedServletContainerFactory
	 * jettyContainer = new JettyEmbeddedServletContainerFactory();
	 * 
	 * jettyContainer.setPort(9000); jettyContainer.setContextPath("/home"); return
	 * jettyContainer; }
	 * 
	 */

//	  @Bean public ConfigurableServletWebServerFactory webServerFactory() {
//	  JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
//	  factory.setPort(9000); factory.setContextPath("/myapp");
//	  factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
//	  return factory; }

}
