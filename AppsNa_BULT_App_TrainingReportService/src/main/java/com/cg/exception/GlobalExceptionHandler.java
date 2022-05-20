package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Value(value="${data.exception.msg}")
	private String msg;
	@ExceptionHandler(value=DataAlreadyExistsException.class)
	public ResponseEntity<String>DataAlreadyExistException(DataAlreadyExistsException dae){
		return new ResponseEntity<String>(msg,HttpStatus.CONFLICT);
	}
	@Value(value="${data.exception.dmsg}")
	private String deletemsg;
	@ExceptionHandler(value=DataDoesNotExistsException.class)
	public ResponseEntity<String>DataDoesNotExistException(DataDoesNotExistsException dae){
		return new ResponseEntity<String>(deletemsg,HttpStatus.CONFLICT);
	}
}
