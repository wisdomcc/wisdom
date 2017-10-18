package com.wisdom.exception;

public class FetchException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FetchException() {
		super();
	}
	
	public FetchException(String message) {
		super(message);
	}
	
	public FetchException(Exception ex) {
		super(ex);
	}

}
