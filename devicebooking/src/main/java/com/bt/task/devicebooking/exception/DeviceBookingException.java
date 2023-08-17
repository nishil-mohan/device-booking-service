package com.bt.task.devicebooking.exception;

public class DeviceBookingException extends RuntimeException {

	private String errorCode;
	private String description;
	
	public DeviceBookingException(String errorCode, String description) {
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
