package com.bt.task.devicebooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bt.task.devicebooking.data.entity.Phone;
import com.bt.task.devicebooking.model.PhoneInfo;
import com.bt.task.devicebooking.restclient.MockFonoApiClient;
import com.bt.task.devicebooking.service.DeviceInfoService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

	private MockFonoApiClient mockFonoApiClient;
	private MockFonoApiClient fonoApiClient;

	public DeviceInfoServiceImpl(MockFonoApiClient mockFonoApiClient, MockFonoApiClient fonoApiClient) {
		this.mockFonoApiClient = mockFonoApiClient;
		this.fonoApiClient = fonoApiClient;
	}

	@CircuitBreaker(name = "fonoApiCircuitBreaker", fallbackMethod = "fallbackGetPhoneInfo")
	public PhoneInfo getPhoneInfo(String deviceName) {
		return fonoApiClient.getPhoneInfo(deviceName);
	}

	public PhoneInfo fallbackGetPhoneInfo(String deviceName, Exception ex) {
		return mockFonoApiClient.getPhoneInfo(deviceName);
	}


}

