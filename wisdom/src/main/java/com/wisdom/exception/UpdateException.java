package com.wisdom.exception;

public class UpdateException extends RuntimeException {

	private static final long serialVersionUID = 4L;
	
	public UpdateException() {
		super();
	}
	
	public UpdateException(String message) {
		super(message);
	}
	
	public UpdateException(Exception ex) {
		super(ex);
	}

}
