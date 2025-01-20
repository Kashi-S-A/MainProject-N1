package com.ty.cp.exception;

public class EnquiryNotFound extends RuntimeException {

	private String message;

	public EnquiryNotFound() {
	}

	public EnquiryNotFound(String msg) {
		message = msg;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
