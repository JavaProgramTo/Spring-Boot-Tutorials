package com.javaprogram.custom.errors.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.javaprogram.api.RequestHeadersAPI;

@Controller
public class DefaultErrorsAPI {

	Logger logger = LoggerFactory.getLogger(RequestHeadersAPI.class);

	@GetMapping("/error")
	public String getDefaultPage(@RequestHeader(name = "errorcode") String errorCode) {
		logger.info("error code : " + errorCode);
		return "error";
	}

}
