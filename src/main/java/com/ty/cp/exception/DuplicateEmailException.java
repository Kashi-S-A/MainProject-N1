package com.ty.cp.exception;

public class DuplicateEmailException extends RuntimeException{

	private String message;

	public DuplicateEmailException() {
	}

	public DuplicateEmailException(String msg) {
		message = msg;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
