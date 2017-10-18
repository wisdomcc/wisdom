package com.wisdom.exception;

public class PrintException extends RuntimeException {

	private static final long serialVersionUID = 3L;

	public PrintException() {
		super();
	}

	public PrintException(String message) {
		super(message);
	}

	public PrintException(Exception ex) {
		super(ex);
	}

}