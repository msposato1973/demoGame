package com.casino.provide.request;

public class RequestSimulatedGameProvide {

	private String signature ; 
	private Params params;
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Params getParams() {
		return params;
	}
	public void setParams(Params params) {
		this.params = params;
	}
	
	public RequestSimulatedGameProvide(String signature, Params params) {
		super();
		this.signature = signature;
		this.params = params;
	} 
	
	public RequestSimulatedGameProvide() {
		super();
	} 
	
}
