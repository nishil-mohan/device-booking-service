package com.bt.task.devicebooking.restclient;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.bt.task.devicebooking.model.PhoneInfo;

public class FonoApiClient {

	private static final String FONO_API_KEY = "YOUR_FONOAPI_KEY"; // Replace with your actual API key
	private static final String FONO_API_BASE_URL = "https://fonoapi.freshpixl.com/v1/";


	private final RestTemplate restTemplate;

	public FonoApiClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public PhoneInfo getPhoneInfo(String deviceName) {
		return restTemplate.getForEntity(FONO_API_BASE_URL, PhoneInfo.class, 
				Map.of("device", deviceName)).getBody();
	}

}
