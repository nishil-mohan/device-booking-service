package com.bt.task.devicebooking.model;

import lombok.Data;

@Data
public class ErrorResponse {

	private final String errorCode;
	private final String errorDescription;
}
