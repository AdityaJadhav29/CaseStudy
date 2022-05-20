package com.cg.exception;

public class DataDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataDoesNotExistsException() {
		super();
	}

	public DataDoesNotExistsException(String message) {
		super(message);
	}

}
