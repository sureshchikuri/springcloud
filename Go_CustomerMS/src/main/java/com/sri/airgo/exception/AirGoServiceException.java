package com.sri.airgo.exception;

public class AirGoServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	private String errorCode;

	public AirGoServiceException(String code, String message) {
		super(message);
		this.errorCode = code;
	}

	public AirGoServiceException(String message) {
		super(message);

	}
}