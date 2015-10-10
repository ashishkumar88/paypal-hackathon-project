package org.paypal.hackathon.project.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnhancedRestTemplateFactory {

	private static Map<Integer, EnhancedRestTemplate> timeoutRestTemplateMap = new ConcurrentHashMap<Integer, EnhancedRestTemplate>();

	/**
	 * @param timeoutInMilliseconds
	 * @return cached EnhancedRestTemplate or creates one and then returns it.<br/>
	 * This is essentially named Singletons named by timeout values.
	 */
	public static EnhancedRestTemplate getSingleton(int timeoutInMilliseconds) {
		Integer timeoutKey = Integer.valueOf(timeoutInMilliseconds);
		EnhancedRestTemplate enhancedRestTemplate = timeoutRestTemplateMap.get(timeoutKey);
		if(enhancedRestTemplate == null) {
			enhancedRestTemplate = new EnhancedRestTemplate(timeoutInMilliseconds);
			timeoutRestTemplateMap.put(timeoutKey, enhancedRestTemplate);
		}
		return enhancedRestTemplate;
	}

}
