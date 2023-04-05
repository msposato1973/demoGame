package com.casino.provide.exception;

public class ErrorMessage {
	
  private String status;
  private String message;
  private int code;
  
	public ErrorMessage(String status, String message, int code) {
		super();
		this.status = status;
		this.message = message;
		this.code = code;
	}
  
}
