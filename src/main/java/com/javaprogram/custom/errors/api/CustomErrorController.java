package com.javaprogram.custom.errors.api;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.javaprogram.api.RequestHeadersAPI;

@Controller
public class CustomErrorController implements ErrorController {

	Logger logger = LoggerFactory.getLogger(RequestHeadersAPI.class);

	@GetMapping("/custom/error")
	public String getCustomError(@RequestHeader(name = "code") String errorCode) {

		logger.info("error code : " + errorCode);
		if ("400".equals(errorCode)) {
			return "400";
		} else if ("404".equals(errorCode)) {
			return "404";
		}

		return "error";
	}

	@GetMapping(value = "/custom/errors")
	public String handleError(HttpServletRequest request) {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {

			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "500";
			}
		}
		return "error";
	}

	@Override
	public String getErrorPath() {
		logger.info("setting up the path for error pages.");
		return "/error";
	}

}
