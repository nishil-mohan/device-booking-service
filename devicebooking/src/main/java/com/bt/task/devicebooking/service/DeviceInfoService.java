package com.bt.task.devicebooking.service;

import com.bt.task.devicebooking.model.PhoneInfo;

public interface DeviceInfoService {

	PhoneInfo getPhoneInfo(String deviceName);
	
	public PhoneInfo fallbackGetPhoneInfo(String deviceName, Exception ex);
    
}
