package com.casino.provide.request;

public class RequestGameLaunch {

	//":"<Base64 encoded SHA1 signature>",
	 
	//":"<UUID from database>",
	private String token ; 
	
	// ":"<gameid from client>"
	private String   gameid; 
		
	public RequestGameLaunch() {
		super();
	}
	
	public RequestGameLaunch(String token, String gameid) {
		super();
		this.token = token;
		this.gameid = gameid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getGameid() {
		return gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = gameid;
	}

	 

	
	
}
