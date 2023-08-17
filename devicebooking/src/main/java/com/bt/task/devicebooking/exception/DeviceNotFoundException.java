package com.bt.task.devicebooking.exception;


public class DeviceNotFoundException extends RuntimeException {

	private String errorCode;
	private String description;
	
	public DeviceNotFoundException(String errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}
	
	
}
