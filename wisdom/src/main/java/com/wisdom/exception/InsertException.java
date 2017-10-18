package com.wisdom.exception;

public class InsertException extends RuntimeException {

	private static final long serialVersionUID = 2L;
	
	public InsertException() {
		super();
	}
	
	public InsertException(String message) {
		super(message);
	}
	
	public InsertException(Exception ex) {
		super(ex);
	}

}
