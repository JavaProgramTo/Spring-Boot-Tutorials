package com.javaprogram.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

//@Component
public class EmbedServerCustomConfigration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {

		factory.setPort(9009);
		factory.setDisplayName("JavaProgramTo.com");
		factory.setServerHeader("Server header");

		factory.setContextPath("/api/v3");

	}

}
