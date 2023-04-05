package com.casino.provide.exception;

public class InvalidSignatureError extends Exception {

	private static final long serialVersionUID = 1L;

	  public InvalidSignatureError(String msg) {
	    super(msg);
	  }
}
