package com.ty.cp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String catchDuplicateEmailException(DuplicateEmailException exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(CounsellorNotFound.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String catchCounsellorNotFound(CounsellorNotFound exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(EnquiryNotFound.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String catchEnquiryNotFound(EnquiryNotFound exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String catchException(Exception exception) {
		return exception.getMessage();
	}
}
