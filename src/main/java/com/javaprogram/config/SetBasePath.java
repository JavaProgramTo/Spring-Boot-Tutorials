package com.javaprogram.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

// now this is disabled. To enable, just uncomment @Bean annotation.
@Component
public class SetBasePath {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// @Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> customizer = factory -> factory
				.setContextPath("/api/v2");

		logger.info("Setting up the custom base path ");
		return customizer;
	}
}
