package com.ty.cp.exception;

public class CounsellorNotFound extends RuntimeException{

	private String message;
	
	public CounsellorNotFound() {
	}
	
	public CounsellorNotFound(String msg) {
		message=msg;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
