package com.javaprogram.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

//@Component
public class TomcatEmbedServerCustomConfigration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		logger.info("Setting the Tomcat specific configurations. started");
		factory.setPort(9009);
		factory.setDisplayName("JavaProgramTo.com");
		factory.setServerHeader("Server header of tomcat");

		factory.setContextPath("/api/v4");
		logger.info("Setting the Tomcat specific configurations. ended");
	}

}
