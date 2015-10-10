package org.paypal.hackathon.project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class EnhancedRestTemplate extends RestTemplate{
	private static final Logger LOGGER = LoggerFactory.getLogger(EnhancedRestTemplate.class);

	public static final int MIN_TIMEOUT = 15 * 1000;  // Enforce minimum of 15 seconds

	EnhancedRestTemplate(int timeout) {
		super(new SimpleClientHttpRequestFactory());
		initialize(timeout);
	}

	private void initialize(int timeoutValue) {

		int timeout = timeoutValue;

		if (timeoutValue < MIN_TIMEOUT) {
			timeout = MIN_TIMEOUT;
			LOGGER.warn("Using minimum timeout of {} instead of {}", Integer.valueOf(MIN_TIMEOUT), Integer.valueOf(timeoutValue));
		}

		if (getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
			LOGGER.debug("HttpUrlConnection is used -- SimpleClientHttpRequestFactory. timeout={}", Integer.valueOf(timeout));
			SimpleClientHttpRequestFactory simpleClientHttpRequestFactory =
					(SimpleClientHttpRequestFactory) getRequestFactory();
			simpleClientHttpRequestFactory.setConnectTimeout(timeoutValue);
			simpleClientHttpRequestFactory.setReadTimeout(timeoutValue);
		}else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
			LOGGER.debug("HttpClient is used -- HttpComponentsClientHttpRequestFactory. timeout={}", Integer.valueOf(timeout));
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory =
					(HttpComponentsClientHttpRequestFactory)getRequestFactory();
			httpComponentsClientHttpRequestFactory.setReadTimeout(timeout);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(timeout);
		}
	}

}
