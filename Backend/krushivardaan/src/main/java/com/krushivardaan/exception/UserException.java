package com.krushivardaan.exception;

import java.time.LocalDateTime;

public class UserException extends RuntimeException {

	private final String errorCode;
	private final LocalDateTime timeStamp;

	public UserException(String message, String errorCode, LocalDateTime timeStamp) {
		super(message);
		this.errorCode = errorCode;
		this.timeStamp = timeStamp;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

}
