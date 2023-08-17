package com.bt.task.devicebooking.restclient;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bt.task.devicebooking.model.PhoneInfo;

@Component
public class MockFonoApiClient {

	private static final String FONO_API_BASE_URL = "http://localhost:8080/v1/getdevice?device={device}";

	private final RestTemplate restTemplate;

	public MockFonoApiClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Cacheable("phoneInfo" )
	public PhoneInfo getPhoneInfo(String deviceName) {
		return restTemplate.getForObject(FONO_API_BASE_URL, PhoneInfo.class,deviceName);
	}

}
