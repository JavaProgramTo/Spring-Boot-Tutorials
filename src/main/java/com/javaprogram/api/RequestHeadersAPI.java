package com.javaprogram.api;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request/headers")
public class RequestHeadersAPI {
	Logger logger = LoggerFactory.getLogger(RequestHeadersAPI.class);

	// individual headers.
	@GetMapping("individual/country")
	public ResponseEntity<String> getHeaderFromLocale(@RequestHeader(value = "locale") String locale) {
		logger.info("getmapping for request hreaders : " + locale);

		String country = "USA is leading country in the world.";
		if (locale.equals("IN")) {
			country = "India";
		} else if (locale.equals("UK")) {
			country = "United Kingdom";
		} else if (locale.equals("AUS")) {
			country = "Australia";
		} else if (locale.equals("IT")) {
			country = "Italiy";
		}

		String response = "Country for the given locale " + locale + " is " + country;
		if (locale.trim().length() == 0) {
			response = country;
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("individual/phonenumnber")
	public ResponseEntity<String> getHeaderNumberValue(@RequestHeader(value = "phone-number") long phoneNumber) {
		logger.info("getmapping for request hreaders : " + phoneNumber);
		boolean isValidNumber = false;
		if (String.valueOf(phoneNumber).length() == 10) {
			isValidNumber = true;
		}

		String response = "Given phone number " + phoneNumber + " is " + (isValidNumber ? "valid" : "invalid");

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	// All headers once

	@GetMapping("allheaders/map")
	public ResponseEntity<String> getAllHeadersAsMap(@RequestHeader Map<String, String> allHeaders) {

		logger.info("All headers are");
		Set<Entry<String, String>> entrySet = allHeaders.entrySet();

		StringBuffer buffer = new StringBuffer();

		buffer.append("header count " + allHeaders.size() + " \n");
		for (Entry<String, String> e : entrySet) {
			logger.info("Header " + e.getKey() + "= " + e.getValue());
			buffer.append("Header " + e.getKey() + "= " + e.getValue() + " \n");
		}

		return new ResponseEntity<String>(buffer.toString(), HttpStatus.OK);
	}

	@GetMapping("allheaders/multimap")
	public ResponseEntity<String> getAllHeadersAsMultiMap(@RequestHeader MultiValueMap<String, String> allHeaders) {

		logger.info("All headers with MultiValueMap");

		// StringBuffer
		StringBuffer localeBuffer = new StringBuffer();

		allHeaders.forEach((k, v) -> {
			logger.info(k + " = value = " + v.stream().collect(Collectors.toList()));

			if (k.equals("locale")) {
				localeBuffer.append(v);
			}

		});

		return new ResponseEntity<String>("Repeated header : " + localeBuffer.toString(), HttpStatus.OK);
	}

	@GetMapping("allheaders/httpheaders")
	public ResponseEntity<String> getAllHeadersAsHttpHeaders(@RequestHeader HttpHeaders allHttpHeaders) {

		logger.info("All headers with MultiValueMap");
		StringBuffer httpBuffer = new StringBuffer();

		String firstValue = allHttpHeaders.getFirst("locale");

		String hostName = allHttpHeaders.getHost().getHostName();

		int port = allHttpHeaders.getHost().getPort();

		httpBuffer.append(" first value of locale : " + firstValue).append("\nhost name : " + hostName)
				.append("\nport : " + port);

		return new ResponseEntity<String>("HttpHeaders response: " + httpBuffer.toString(), HttpStatus.OK);
	}

	@GetMapping("individual/requried")
	public ResponseEntity<String> mandateHeader(@RequestHeader(value = "locale", required = true) String locale) {

		return new ResponseEntity<String>(locale, HttpStatus.OK);
	}
	
	@GetMapping("individual/default")
	public ResponseEntity<String> Header(@RequestHeader(value = "locale", defaultValue = "USA") String locale) {

		return new ResponseEntity<String>(locale, HttpStatus.OK);
	}

}
